package com.example.linkn.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private LocationManager locationManager;
    private LocationListener locationListener;
    private GoogleMap mMap;
    private Marker yourLocation;
    private FirebaseFirestore mDatabase;
    ArrayList<String> koordinaten=new ArrayList<>();
    public FirebaseAuth auth;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    TextView adressTextView,phoneTextView;




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 50, 0, locationListener);
            }
        }
    }

    public void getFarmshops(){
        mDatabase.collection("Farmshop")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                koordinaten.add(document.getString("ort")+"+"+document.getString("straße")+"+"+document.getString("hausnummer")+"+"+document.getString("plz"));
                                //Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            //Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
        mDatabase.collection("Farmshop")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int i=0;
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                koordinaten.add(document.getString("ort")+"+"+document.getString("straße")+"+"+document.getString("hausnummer")+"+"+document.getString("plz"));
                                //Log.d(TAG, document.getId() + " => " + document.getData());
                                System.out.println(koordinaten.get(i).toString());
                                i++;
                            }
                        } else {
                            //Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        mDatabase = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
       getFarmshops();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(49.029090,  8.461969))
                .title("Hagsfelder Hofladen")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
      //          .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));



        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
              //  mMap.clear();

                if(yourLocation!=null&&yourLocation.isVisible()){
                  yourLocation.setVisible(false);
                }
                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());

                yourLocation = mMap.addMarker(new MarkerOptions()
                        .position(userLocation)
                        .title("aktueller Standort"));

              //mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 12));

          /*      getFarmshops();
                if(koordinaten==null){
                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(49.013611,  8.40444))
                            .title("Null Liste")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                }else{
                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(49.013611,  8.40444))
                            .title(koordinaten.size()+"")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                }
*/




            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }


        };







        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions( this, new String [] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else{
            //minTime legt fest, wie oft die Location aktualisiert wird, pro sekunde, halbe Minute usw.
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3, 0, locationListener);
        }
        // Add a marker on the Position of the user


    }
    public void goToFarmshop(View view){

        setContentView(R.layout.farm_shop_profile);
        adressTextView = (TextView) findViewById(R.id.adressTextView);
        phoneTextView = (TextView) findViewById(R.id.phoneTextView);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //gibt den String des aktuellen Users
        String uid = user.getUid();

        DocumentReference Farmshop=mDatabase.collection("Farmshop").document(uid);

        Farmshop.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                DocumentSnapshot document=task.getResult();
                String adresse=document.getString("straße")+" "+document.getString("hausnummer")+" "+document.getString("plz")+" "+document.getString("ort");
                String phone=document.getString("phone");
                // String geb=document.getString("born");
                adressTextView.setText(adresse);
                phoneTextView.setText(phone);
            }
        });


    }
    public void profilButton(View view){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            startActivity(new Intent(MapsActivity.this, MainActivity.class));

        }else{
            startActivity(new Intent(MapsActivity.this, Profile.class));
        }
    }
}
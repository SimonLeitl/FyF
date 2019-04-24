package com.example.linkn.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    public static final String FARMSHOP = "Farmshop";

    private LocationManager locationManager;
    private LocationListener locationListener;
    private GoogleMap mMap;
    private Marker yourLocation;
    private FirebaseFirestore mDatabase;

    public FirebaseAuth auth;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    TextView adressTextView, phoneTextView, shopnameTextView;
    ListView ladenNameView;

    private Task<List<FarmShopMarker>> farmShopMarkerFuture;




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 50, 0, locationListener);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.map);
        mDatabase = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        farmShopMarkerFuture = getFarmShopMarkerFuture();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Transformiert DatankresultSet zu FarmerShopMarker Objekt um eine Abstraktionsebene für
     * das Mapping zu schaffen und den passenden Adress String zu generieren.
     * <p>
     * Hierfür ist in der Klasse FarmShopMarker ein Builder implementiert der das setzen von
     * Attributen schöner gestaltet (@see com.example.linkn.myapplication.FarmShopMarker.FarmShopMarkerBuilder).
     */
    private Function<DocumentSnapshot, FarmShopMarker> mapQueryDocumentSnapshotToFarmshopMarker() {

        return documentSnapshot -> new FarmShopMarker.FarmShopMarkerBuilder()
                .setId(documentSnapshot.getId())
                .setShopName(documentSnapshot.getString(FarmShopMarker.SHOP_NAME))
                .setCity(documentSnapshot.getString(FarmShopMarker.CITY))
                .setStreet(documentSnapshot.getString(FarmShopMarker.STREET))
                .setStreetNumber(documentSnapshot.getString(FarmShopMarker.STREET_NUMBER))
                .setZipCode(documentSnapshot.getString(FarmShopMarker.ZIP_CODE))
                .build();
    }

    @SuppressLint("NewApi")
    private Optional<Address> getAddressByFarmShopMarker(FarmShopMarker farmShopMarker) {

        Geocoder geocoder = new Geocoder(getApplicationContext());

        Optional<Address> address = Optional.empty();

        try {
            address = Optional.ofNullable(geocoder.getFromLocationName(farmShopMarker.getAddressString(), 1).get(0));
        } catch (IOException | IndexOutOfBoundsException e) {
            Log.i("FarmShopMarker", "Can not find address with geocode for farmshop marker adress: " + farmShopMarker.getAddressString());
        }

        return address;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        addFarmshopMarkersToMap();

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //  mMap.clear();

                if (yourLocation != null && yourLocation.isVisible()) {
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


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            //minTime legt fest, wie oft die Location aktualisiert wird, pro sekunde, halbe Minute usw.
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3, 0, locationListener);
        }
        // Add a marker on the Position of the user


    }


    @SuppressLint("NewApi")
    private void addFarmshopMarkersToMap() {

        farmShopMarkerFuture.onSuccessTask(farmShopMarkers -> {

            farmShopMarkers.forEach(farmShopMarker -> {
                Optional<Address> address = getAddressByFarmShopMarker(farmShopMarker);

                if (address.isPresent()) {

                    MarkerOptions markerOptions = new MarkerOptions()
                            .position(new LatLng(address.get().getLatitude(), address.get().getLongitude()))
                            .title(farmShopMarker.getShopName())
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

                    Marker marker = mMap.addMarker(markerOptions);
                    marker.setTag(farmShopMarker.getId());
                    mMap.setOnMarkerClickListener(this);
                }

            });


            return null;
        });
    }

    public boolean onMarkerClick(final Marker marker) {
// Überprüfung ob man auf eigenen Standort klickt. Sonst stürzt App ab.
        if(!marker.getTitle().equalsIgnoreCase(yourLocation.getTitle())){
        goToFarmshop(marker);
        }
        return true;

    }

    public void goToFarmshop(Marker marker) {


        setContentView(R.layout.farm_shop_profile);
        adressTextView = (TextView) findViewById(R.id.adressTextView);
        phoneTextView = (TextView) findViewById(R.id.phoneTextView);
        shopnameTextView = (TextView) findViewById(R.id.shopnameTextView);



        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //gibt den String des aktuellen Users
        String uid = user.getUid();
        String id=(String) marker.getTag();




        DocumentReference Farmshop = mDatabase.collection("Farmshop").document(id);

        Farmshop.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                DocumentSnapshot document = task.getResult();
                String adresse = document.getString("straße") + " " + document.getString("hausnummer") + " " + document.getString("plz") + " " + document.getString("ort");
                String phone = document.getString("phone");
                String shopname= document.getString("shopname");
                // String geb=document.getString("born");
                adressTextView.setText(adresse);
                phoneTextView.setText(phone);
                shopnameTextView.setText(shopname);
            }
        });


    }

    public void profilButton(View view) {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            startActivity(new Intent(MapsActivity.this, MainActivity.class));

        } else {
            startActivity(new Intent(MapsActivity.this, Profile.class));
        }
    }

    @SuppressLint("NewApi")
    private Task<List<FarmShopMarker>> getFarmShopMarkerFuture() {

        TaskCompletionSource<List<FarmShopMarker>> farmShopMarkers = new TaskCompletionSource<>();

        Task<QuerySnapshot> farmShopDatabaseTask = mDatabase.collection(FARMSHOP).get();

        farmShopDatabaseTask.addOnSuccessListener(queryDocumentSnapshots -> {

            farmShopMarkers.setResult(queryDocumentSnapshots.getDocuments()
                    .stream()
                    .map(mapQueryDocumentSnapshotToFarmshopMarker()).collect(Collectors.toList()));
        });

        return farmShopMarkers.getTask();
    }

    @SuppressLint("NewApi")
    public void listButton(View view) {

        setContentView(R.layout.farm_list_item);
        ladenNameView = findViewById(R.id.ladenNameListView);

        farmShopMarkerFuture.onSuccessTask(farmShopMarkers -> {

            List<String> farmShopNames = farmShopMarkers
                    .stream()
                    .map(farmShopMarker -> farmShopMarker.getShopName())
                    .collect(Collectors.toList());

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, farmShopNames);

            ladenNameView.setAdapter(adapter);

            return null;
        });
    }
}
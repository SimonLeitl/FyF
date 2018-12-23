package com.example.linkn.myapplication;

import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class FarmShopMarkerActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener {

    @Override
    public boolean onMarkerClick(Marker marker) {

        if (marker.getTag() instanceof FarmShopMarker) {

            FarmShopMarker farmShopMarker = (FarmShopMarker) marker.getTag();

//            Intent profileIntent = new Intent(getActivity(), Profile.class);
//            profileIntent.putExtra("bla", "asdasd");

//            startActivity(profileIntent);
        }

        return true;
    }
}
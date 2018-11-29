package com.example.linkn.myapplication;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationOfDevice implements LocationListener {

    private static double lat =0.0;
    private static double lon = 0.0;
    private final String mSnippet;
    private final LatLng mPosition;

    /*
    private static double alt = 0.0;
    private static double speed = 0.0;
    private final String mTitle = "";
    */

    // Breitengrad
    public static double getLat()
    {
        return lat;
    }

    // Längengrad
    public static double getLon()
    {
        return lon;
    }

    /*
    public static double getAlt()
    {
        return alt;
    }

    public static double getSpeed()
    {
        return speed;
    }
    */

    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(getLat(), getLon()))
                .title("Current Location"));
    }
    public LocationOfDevice(double lati, double lng, String title, String snippet) {
        lati = lat;
        lng = lon;
        mPosition = new LatLng(lat, lng);
      //  mTitle = title;
        mSnippet = snippet;
    }

    public LocationOfDevice(double lati, double lng, String mSnippet) {
        lati = lat;
        lng = lon;
        this.mSnippet = mSnippet;
        mPosition = new LatLng(lati, lng);
    }

    // gibt die Koordinaten in Goolgefromat wieder
    public LatLng getPosition() {
        return mPosition;
    }

   // public String getTitle() {
      //  return mTitle;
   // }

    public String getSnippet() {
        return mSnippet;
    }

    @Override
    public void onLocationChanged(Location location)
    {
        lat = location.getLatitude();
        lon = location.getLongitude();
        /*
        alt = location.getAltitude();
        speed = location.getSpeed();
        */
    }

    @Override
    public void onProviderDisabled(String provider) {}
    @Override
    public void onProviderEnabled(String provider) {}
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}
}
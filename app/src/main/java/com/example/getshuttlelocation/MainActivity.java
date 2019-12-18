package com.example.getshuttlelocation;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        client = LocationServices.getFusedLocationProviderClient(this);


        //client = LocationServices.getFusedLocationProviderClient(this);

        // worked on fake device but not real one
//        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
//        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);


        // didn't crash but never called on location chnaged
        final LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(android.location.Location location) {
                double latitude=location.getLatitude();
                double longitude=location.getLongitude();
                String msg="New Latitude: "+latitude + "New Longitude: "+longitude;
                System.out.println(msg);
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
        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = null;
        for ( String provider : lm.getProviders(true) ) {
            location =  lm.getLastKnownLocation(provider);
            lm.requestLocationUpdates(provider, 3000, 0, locationListener);
        }
         //3 seconds and 10 meters
        //Location loc = getLastKnownLocation(LocationManager.GPS_PROVIDER);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, locationListener);
        //Task<Location> l = client.getLastLocation();
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        System.out.println(latitude);
        System.out.println(longitude);
      /*  if (location == null){
            lm.getLastKnownLocation(location);
        }*/
//        System.out.println("STEMI");
//        System.out.println(location.getResult().getLatitude() + ", " + location.getResult().getLongitude());

    }

    private void checkPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
    }
}

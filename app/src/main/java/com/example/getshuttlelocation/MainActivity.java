package com.example.getshuttlelocation;

import android.Manifest;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient client;

    private void checkPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        client = LocationServices.getFusedLocationProviderClient(this);

        final LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(android.location.Location location) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                String msg = "New Latitude2: " + latitude + " New Longitude2: " + longitude;
                System.out.println(msg);

                Context context = getApplicationContext();
                CharSequence text = msg;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
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

//        while (true) {
//            client.getLastLocation()
//                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
//                        @Override
//                        public void onSuccess(Location location) {
//                            // Got last known location. In some rare situations this can be null.
//                            if (location != null) {
//                                String msg = "New Latitude1: " + location.getLatitude() + " New Longitude1: " + location.getLongitude();
//                                System.out.println(msg);
//
//                                Context context = getApplicationContext();
//                                CharSequence text = msg;
//                                int duration = Toast.LENGTH_SHORT;
//
//                                Toast toast = Toast.makeText(context, text, duration);
//                                toast.show();
//                                // Logic to handle location object
//                            }
//                        }
//                    });
//        }

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        android.location.Location location = null;
        while (true) {
            //System.out.println(lm.GPS_PROVIDER);
            location = lm.getLastKnownLocation(lm.GPS_PROVIDER);
            //Location l = location.getResult();
            String msg = "New Latitude1: " + location.getLatitude() + " New Longitude1: " + location.getLongitude();
            System.out.println(msg);

            Context context = getApplicationContext();
            CharSequence text = msg;
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
//        Criteria criteria = new Criteria();
//        criteria.setAccuracy(Criteria.ACCURACY_FINE);
//
//        String provider = lm.getBestProvider(criteria, true);
//        location = lm.getLastKnownLocation(provider);
//
//        //location = lm.getLastKnownLocation(lm.GPS_PROVIDER);
//        String msg = "New Latitude1: " + location.getLatitude() + " New Longitude1: " + location.getLongitude();
//        System.out.println(msg);
//        lm.requestLocationUpdates(provider, 0, 0, locationListener);
//        while (true) {
//            Criteria criteria = new Criteria();
//            criteria.setAccuracy(Criteria.ACCURACY_FINE);
//
//            String provider = lm.getBestProvider(criteria, true);
//            location = lm.getLastKnownLocation(provider);
//
//            //location = lm.getLastKnownLocation(lm.GPS_PROVIDER);
//            String msg = "New Latitude1: " + location.getLatitude() + " New Longitude1: " + location.getLongitude();
//            System.out.println(msg);
//            lm.requestLocationUpdates(lm.GPS_PROVIDER, 0, 0, locationListener);
//        }
//        for (String provider : lm.getProviders(true)) {
//            System.out.println(provider);
//            location = lm.getLastKnownLocation(provider);
//            String msg = "New Latitude1: " + location.getLatitude() + " New Longitude1: " + location.getLongitude();
//            System.out.println(msg);
//            lm.requestLocationUpdates(provider, 0, 0, locationListener);
//        }
//        System.out.println("passive");
//        location = lm.getLastKnownLocation("gps");
//        String msg = "New Latitude1: " + location.getLatitude() + " New Longitude1: " + location.getLongitude();
//        System.out.println(msg);
//        lm.requestLocationUpdates("gps", 0, 0, locationListener);
        // ????????????
//        for (String provider : lm.getProviders(true)) {
//            System.out.println(provider);
//            location = lm.getLastKnownLocation(provider);
//            String msg = "New Latitude1: " + location.getLatitude() + " New Longitude1: " + location.getLongitude();
//            System.out.println(msg);
//            lm.requestLocationUpdates(provider, 0, 0, locationListener);
//        }
        // ????????????
        //3 seconds and 10 meters
        //Location loc = getLastKnownLocation(LocationManager.GPS_PROVIDER);
        //lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
        //Task<Location> l = client.getLastLocation();
        //double longitude = location.getLongitude();
        //double latitude = location.getLatitude();
        //System.out.println(latitude);
        //System.out.println(longitude);
      /*  if (location == null){
            lm.getLastKnownLocation(location);
        }*/
//        System.out.println("STEMI");
//        System.out.println(location.getResult().getLatitude() + ", " + location.getResult().getLongitude());

    }
}
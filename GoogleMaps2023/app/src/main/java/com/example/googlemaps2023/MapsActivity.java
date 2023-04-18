package com.example.googlemaps2023;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemaps2023.databinding.ActivityMapsBinding;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if(mapFragment != null) {
            mapFragment.getMapAsync(this);
        } else {
            Toast.makeText(this, "Could not find mapFragment!", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
        /*try {
            List<Address> addresses = geocoder.getFromLocationName("Panania", 100, -54,100, -14, 170);
            for (Address a : addresses) {
                LatLng l = new LatLng(a.getLatitude(), a.getLongitude());
                mMap.addMarker(new MarkerOptions().position(l));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(l));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            List<Address> addresses = geocoder.getFromLocationName("109 University Square, Erie, PA, USA", 5);
            for (Address a : addresses) {
                LatLng l = new LatLng(a.getLatitude(), a.getLongitude());
                mMap.addMarker(new MarkerOptions().position(l));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(l));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
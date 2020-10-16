package com.demo.mapsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng> latLngs = new ArrayList<>();
    TextView tvMask;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMask = findViewById(R.id.tv_mark);
        tvMask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng latLng = latLngs.get(random.nextInt(latLngs.size()));
                mMap.clear();
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Marker in Sydney"));
            }
        });
        latLngs.add(new LatLng(-36.8864113, 174.7048393));
        latLngs.add(new LatLng(-36.8885275, 174.7366464));
        latLngs.add(new LatLng(-36.8810594, 174.7634187));
        latLngs.add(new LatLng(-36.8507373, 174.7583024));
        latLngs.add(new LatLng(-36.7285388, 174.7086970));
        latLngs.add(new LatLng(-36.7168158, 174.7429512));
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng latLng = latLngs.get(random.nextInt(latLngs.size()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
    }
}

/**
 * function changePan(){
 * var latlngbounds = new GLatLngBounds( );
 * <p>
 * latlngbounds.extend(new GLatLng(39.907,116.387));
 * latlngbounds.extend(new GLatLng(39.935,116.407));
 * latlngbounds.extend(new GLatLng(39.944,116.432));
 * latlngbounds.extend(new GLatLng(39.924,116.427));
 * <p>
 * map.setCenter( latlngbounds.getCenter( ), map.getBoundsZoomLevel( latlngbounds ) );
 * <p>
 * }
 */
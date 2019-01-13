package com.neelk.dvhacks;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private final double LAT = 37.381610;
    private double LNG = -121.958310;
    private double LATs1 = 37.386200;
    private double LNGs1 = -121.960900;
    private double LATs2 = 37.394810;
    private double LNGs2 = -121.947290;
    private double LATs3 = 37.388870;
    private double LNGs3 = -121.986780;

    public MapFragment() {

    }


    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();


        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map, container, false);

        if (this.mMap == null) {
            SupportMapFragment mapFrag = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            mapFrag.getMapAsync(this);

        }
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng loc = new LatLng(LAT, LNG);
        mMap.addMarker(new MarkerOptions().position(loc).title("Current Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));

        LatLng s1 = new LatLng(LATs1, LNGs1);
        mMap.addMarker(new MarkerOptions().position(s1).title("Starbucks"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(s1));

        LatLng s2 = new LatLng(LATs2, LNGs2);
        mMap.addMarker(new MarkerOptions().position(s2).title("Starbucks"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(s2));

        LatLng s3 = new LatLng(LATs3, LNGs3);
        mMap.addMarker(new MarkerOptions().position(s3).title("Starbucks"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(s3));
        CameraPosition camera_position = new CameraPosition.Builder().target(new LatLng(LAT, LNG)).zoom(12).build();
        CameraUpdate updateCamera = CameraUpdateFactory.newCameraPosition(camera_position);
        googleMap.animateCamera(updateCamera);

    }
}

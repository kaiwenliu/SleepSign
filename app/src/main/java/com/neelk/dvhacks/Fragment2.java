package com.neelk.dvhacks;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.graphics.Camera;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

public class Fragment2 extends Fragment implements ActivityCompat.OnRequestPermissionsResultCallback{

    private CameraManager manager;

    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance(Activity activity) {
        Fragment2 fragment = new Fragment2();

        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, 0);
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);


        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment2, container, false);
        return view;
    }


}

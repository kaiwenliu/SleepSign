package com.neelk.dvhacks;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

import static android.support.v4.content.PermissionChecker.checkCallingOrSelfPermission;
import static android.support.v4.content.PermissionChecker.checkSelfPermission;

public class Fragment2 extends Fragment implements ActivityCompat.OnRequestPermissionsResultCallback {


    private static Activity a;

    private Button startCamera;


    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance(Activity activity) {

        a = activity;
        Fragment2 fragment = new Fragment2();

        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, 0);
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);


        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        startCamera = view.findViewById(R.id.cameraButton);
        startCamera.setOnClickListener(takePictureClicked);
        return view;
    }

    private View.OnClickListener takePictureClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getActivity(), CameraActivity.class));
        }
    };

    /*
    private boolean hasPermissions(){}
    String permission = Manifest.permission.CAMERA;
    int res = getContext().checkCallingOrSelfPermission(permission);
    return (res == Packag);
    */



}

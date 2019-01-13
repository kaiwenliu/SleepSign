



package com.neelk.dvhacks;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Home extends Fragment {

    private TextView outputTextView;


    public Home() {
        // Required empty public constructor
    }


    public static Home newInstance() {
        Home fragment = new Home();

       return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        outputTextView = view.findViewById(R.id.ouputTextView);


        if(CameraActivity.output != null){
            outputTextView.setText(CameraActivity.output);
        }
        return view;
    }


}

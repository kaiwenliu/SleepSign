



package com.neelk.dvhacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Home extends Fragment {

    private TextView outputTextView;
    private TextView warningTextView;
    private ImageView uberLogo;
    private String uberLink = "https://auth.uber.com/login/?breeze_local_zone=dca1&next_url=https%3A%2F%2Friders.uber.com%2F&state=Uf1MkuXXpbwgH2JBuC5AMO1hBq5LiqndQ2uRKAaWIKg%3D";


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
        warningTextView = view.findViewById(R.id.warningTextView);
        uberLogo  = view.findViewById(R.id.uberImageView);
        uberLogo.setOnClickListener(uberOnClick);



        if(CameraActivity.output != null){
            outputTextView.setText(CameraActivity.output);
            if(CameraActivity.output.contains("0.9")){
                warningTextView.setText("WARNING: YOU ARE VERY SLEEPY" + "\n" + "Call an Uber or Go To a Coffee Shop");
            }
        }

            return view;
    }

    private View.OnClickListener uberOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent =  new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(uberLink));
            startActivity(intent);
        }
    };


}

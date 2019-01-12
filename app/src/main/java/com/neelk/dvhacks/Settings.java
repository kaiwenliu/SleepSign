package com.neelk.dvhacks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Settings extends Fragment {

    private Button logOut;

    public Settings() {

    }


    public static Settings newInstance() {
        Settings fragment = new Settings();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        logOut = view.findViewById(R.id.logOut);
        logOut.setOnClickListener(logOutOnClick);
        return view;
    }

    private View.OnClickListener logOutOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getActivity(), MainActivity.class));
        }
    };

}

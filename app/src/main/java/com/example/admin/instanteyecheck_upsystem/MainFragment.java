package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.admin.instanteyecheck_upsystem.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    public MainFragment() {
        // Required empty public constructor
    }

    Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button btn1 = (Button) rootView.findViewById(R.id.option1);
        btn1.setOnClickListener(this); // calling onClick() method
        Button btn2 = (Button) rootView.findViewById(R.id.option2);
        btn2.setOnClickListener(this);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.option1:
                Intent intent = new Intent(getActivity(), question1.class);
                startActivity(intent);
                break;

            case R.id.option2:
                Intent intent1 = new Intent(getActivity(), detection.class);
                startActivity(intent1);
                break;

            default:
                break;
        }
    }
    }


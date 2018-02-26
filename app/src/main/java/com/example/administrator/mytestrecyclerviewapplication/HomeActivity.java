package com.example.administrator.mytestrecyclerviewapplication;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;

import com.example.administrator.mytestrecyclerviewapplication.mfragment.Home_Fragment;


public class HomeActivity extends FragmentActivity {
private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       Home_Fragment home_fragment= new Home_Fragment();
        fragmentTransaction.replace(R.id.line2,home_fragment)
                .commit();


    }
}

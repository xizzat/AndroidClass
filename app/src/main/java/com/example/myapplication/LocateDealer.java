package com.example.myapplication;

import android.app.Activity;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;

/**
 * Created by rifathi on 9/6/2017.
 */

public class LocateDealer extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locate_dealer_page);

        String feature = getIntent().getStringExtra("feature");

    }
}

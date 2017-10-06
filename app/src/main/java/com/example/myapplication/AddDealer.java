package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by rifathi on 9/7/2017.
 */

public class AddDealer extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.add_update_dealer_page);
        setContentView(R.layout.get_support_page);

        String feature = getIntent().getStringExtra("feature");

    }
}
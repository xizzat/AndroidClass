package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by rifathi on 9/6/2017.
 */

public class MyAccount extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_account_page);

        String feature = getIntent().getStringExtra("feature");

    }
}

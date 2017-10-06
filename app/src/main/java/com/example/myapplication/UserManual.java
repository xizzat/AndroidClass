package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by rifathi on 9/6/2017.
 */

public class UserManual extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_manual_page);

        String feature = getIntent().getStringExtra("feature");

    }
}

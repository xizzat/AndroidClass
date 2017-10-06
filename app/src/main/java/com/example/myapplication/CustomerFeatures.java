package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by rifathi on 9/5/2017.
 */

public class CustomerFeatures extends Activity  {
    String[] featuresArray = {"About", "My Account","Locate Dealer","Get Support", "User Manual", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_feature_main_page);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.feature_list, featuresArray);

        OnItemClickListener itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                Intent intent = null;

                if(position == 0)
                    intent = new Intent(CustomerFeatures.this, About.class);
                else if(position == 1)
                    intent = new Intent(CustomerFeatures.this, MyAccount.class);
                else if(position == 2)
                    intent = new Intent(CustomerFeatures.this, LocateDealer.class);
                else if(position == 3)
                    intent = new Intent(CustomerFeatures.this, GetSupport.class);
                else if(position == 4)
                    intent = new Intent(CustomerFeatures.this, UserManual.class);

                //Get the value of the item you clicked
                String itemClicked = featuresArray[position];
                intent.putExtra("feature", itemClicked);
                startActivity(intent);

            }
        };

        ListView listView = (ListView) findViewById(R.id.customer_feature_list);
        listView.setOnItemClickListener(itemClickListener);
        listView.setAdapter(adapter);

   }


}

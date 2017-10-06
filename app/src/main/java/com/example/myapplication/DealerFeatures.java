package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by rifathi on 9/5/2017.
 */

public class DealerFeatures extends Activity {
    String[] featuresArray = {"About", "My Account","Locate Dealer","Add Dealer", "Update Dealer", "Get Support", "User Manual"};
    private String dealerId;

//    public DealerFeatures(String dealerId) {
//        this.dealerId = dealerId;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dealer_feature_main_page);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.feature_list, featuresArray);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                Intent intent = null;

                if(position == 0)
                    intent = new Intent(DealerFeatures.this, About.class);
                else {
                    if(position == 1)
                        intent = new Intent(DealerFeatures.this, MyAccount.class);
                    else if(position == 2)
                        intent = new Intent(DealerFeatures.this, LocateDealer.class);
                    else if(position == 3)
                        intent = new Intent(DealerFeatures.this, AddDealer.class);
                    else if(position == 4)
                        intent = new Intent(DealerFeatures.this, UpdateDealer.class);
                    else if(position == 5)
                        intent = new Intent(DealerFeatures.this, GetSupport.class);
                    else if(position == 6)
                        intent = new Intent(DealerFeatures.this, UserManual.class);
                }


                //Get the value of the item you clicked
                String itemClicked = featuresArray[position];
                intent.putExtra("feature", itemClicked);
                startActivity(intent);

            }
        };

        ListView listView = (ListView) findViewById(R.id.dealer_feature_list);
        listView.setOnItemClickListener(itemClickListener);
        listView.setAdapter(adapter);
   }

}
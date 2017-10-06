package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;


/**
 * Created by RIFATHI on 8/29/2017.
 */

public class MainPage extends Activity {
    private Button dealerBtn, customerBtn;
    private static final String DEALER = "dealer";
    private static final String CUSTOMER = "customer";
    private static final int LOGIN_DIALOG = 1;
    private static final int FAIL_LOGIN_DIALOG = 2;
    private int msg;

    /*
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        dealerBtn = (Button)findViewById(R.id.start_dealer_btn);
        dealerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this, DealerFeatures.class);
                startActivity(i);
            }});

        customerBtn = (Button)findViewById(R.id.start_customer_btn);
        customerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPage.this, CustomerFeatures.class);
                startActivity(i);
            }});
    }

    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        dealerBtn = (Button)findViewById(R.id.start_dealer_btn);
        dealerBtn.setOnClickListener(clickButton(DEALER));

        customerBtn = (Button)findViewById(R.id.start_customer_btn);
        customerBtn.setOnClickListener(clickButton(CUSTOMER));
    }

    private View.OnClickListener clickButton(final String userType) {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userType.equals(DEALER))
                    displayLoginAlert(LOGIN_DIALOG);
                else if(userType.equals(CUSTOMER)) {
                    Intent i = new Intent(MainPage.this, CustomerFeatures.class);
                    startActivity(i);
                }

            }
        };
    }

    private void displayLoginAlert(int dialogType) {

        LayoutInflater li = LayoutInflater.from(this);
        View loginAlertView = li.inflate(R.layout.login_alert, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainPage.this);
        alertDialogBuilder.setView(loginAlertView);

        final EditText userInput = (EditText) loginAlertView.findViewById(R.id.editTextDialogUsername);
        final EditText passwordInput = (EditText) loginAlertView.findViewById(R.id.editTextDialogPassword);
        final TextView message = (TextView)loginAlertView.findViewById(R.id.verifyUserText);

        alertDialogBuilder
                .setTitle("Enter Login Details")
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                //check valid user
                                msg = isValidUser(userInput.getText().toString(),passwordInput.getText().toString());

                                if(msg == 1) {
                                    Intent i = new Intent(MainPage.this, DealerFeatures.class);
                                    startActivity(i);

                                }
                                else {
                                    displayLoginAlert(FAIL_LOGIN_DIALOG);
                                }

                            }
                        })
                .setNegativeButton("Cancel", clickCancelButtonDialog());

        if(dialogType == FAIL_LOGIN_DIALOG)
            message.setText(loginMessage(msg));

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    private DialogInterface.OnClickListener clickCancelButtonDialog() {
        return new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id) {
                dialog.cancel();
            }
        };
    }

    private int isValidUser(String username, String password) {
        if(!username.equals(null) && !password.equals(null)) {
            if(username.equals("rihaab")) {
                if(password.equals("start"))
                    return 1;//valid user
                else
                    return 2;//valid username invalid password
            }
            else {
                if(password.equals("start"))
                    return 3;//invalid username valid password
                else
                    return 4;//invalid username and invalid password
            }
        }
        else
            return 0;//empty username and password
    }

    private String loginMessage(int i) {
        String message = null;

        if(i == 0)
            message = "Either username or password is empty.";
        else if(i == 2)
            message = "Invalid password.";
        else if(i == 3)
            message = "Invalid username.";
        else if(i == 4)
            message = "Invalid username and password.";

        return message;
    }
}

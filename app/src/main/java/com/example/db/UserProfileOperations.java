package com.example.db;

/**
 * Created by rifathi on 9/6/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.db.UserProfileDBManager;
import com.example.persistence.UserProfile;

import java.util.ArrayList;
import java.util.List;

public class UserProfileOperations {
    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    public static final String LOG_TAG = "USER_PROFILE_MGMNT";

    private static final String[] columns = {
            UserProfileDBManager.COLUMN_ID,
            UserProfileDBManager.COLUMN_USERNAME,
            UserProfileDBManager.COLUMN_PASSWORD,
            UserProfileDBManager.COLUMN_FIRSTNAME,
            UserProfileDBManager.COLUMN_LASTNAME
    };

    public UserProfileOperations(Context context) {
        dbhandler = new UserProfileDBManager(context);
    }

    public void open(){
        Log.i(LOG_TAG,"Database Opened");
        database = dbhandler.getWritableDatabase();
    }

    public void close(){
        Log.i(LOG_TAG, "Database Closed");
        dbhandler.close();
    }

    public UserProfile addUserProfile(UserProfile userprofile) {
        ContentValues values = new ContentValues();
        values.put(UserProfileDBManager.COLUMN_USERNAME, userprofile.getUsername());
        values.put(UserProfileDBManager.COLUMN_PASSWORD, userprofile.getPassword());
        values.put(UserProfileDBManager.COLUMN_FIRSTNAME, userprofile.getFirstname());
        values.put(UserProfileDBManager.COLUMN_LASTNAME, userprofile.getLastname());
        long insertid = database.insert(UserProfileDBManager.TABLE_USERPROFILE,null,values);
        userprofile.setUserid(insertid);
        return userprofile;
    }

    public UserProfile getUserProfile(long id) {
        Cursor cursor = database.query(UserProfileDBManager.TABLE_USERPROFILE, columns, UserProfileDBManager.COLUMN_ID
                + "=?",new String[]{String.valueOf(id)},null,null, null, null);

       if (cursor != null)
            cursor.moveToFirst();

        UserProfile usr = new UserProfile(Long.parseLong(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));

        return usr;
    }

    public List<UserProfile> getAllUsers() {
        Cursor cursor = database.query(UserProfileDBManager.TABLE_USERPROFILE,columns,null,null,null, null, null);

        List<UserProfile> userList = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                UserProfile usr = new UserProfile();
                usr.setUserid(cursor.getLong(cursor.getColumnIndex(UserProfileDBManager.COLUMN_ID)));
                usr.setUsername(cursor.getString(cursor.getColumnIndex(UserProfileDBManager.COLUMN_USERNAME)));
                usr.setPassword(cursor.getString(cursor.getColumnIndex(UserProfileDBManager.COLUMN_PASSWORD)));
                usr.setFirstname(cursor.getString(cursor.getColumnIndex(UserProfileDBManager.COLUMN_FIRSTNAME)));
                usr.setLastname(cursor.getString(cursor.getColumnIndex(UserProfileDBManager.COLUMN_LASTNAME)));
                userList.add(usr);
            }
        }
        return userList;
    }

    public int updateUserProfile(UserProfile userProfile) {
        int rowIndex = 0;

        ContentValues values = new ContentValues();
        values.put(UserProfileDBManager.COLUMN_USERNAME, userProfile.getUsername());
        values.put(UserProfileDBManager.COLUMN_PASSWORD, userProfile.getPassword());
        values.put(UserProfileDBManager.COLUMN_FIRSTNAME, userProfile.getFirstname());
        values.put(UserProfileDBManager.COLUMN_LASTNAME, userProfile.getLastname());

        rowIndex = database.update(UserProfileDBManager.TABLE_USERPROFILE, values,
                UserProfileDBManager.COLUMN_ID + "=?", new String[] {String.valueOf(userProfile.getUserid())});

        return rowIndex;
    }

    public void deleteUserProfile(UserProfile userProfile) {
        database.delete(UserProfileDBManager.TABLE_USERPROFILE, UserProfileDBManager.COLUMN_ID + "=" + userProfile.getUserid(), null);
    }
}


package com.example.myapplication;
//Nim : 10119098
//Nama : Dila Adiliani
//Kelas : IF-3
//Tanggal Pengerjaan 21 April 2022

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SpalshScreenActivity extends AppCompatActivity {
    SharedPreferences getPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);
        //hide navbar
        getSupportActionBar().hide();
        //get shared preferences
        getPrefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        //intent activity after 2 sec
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                    finish();
                    //check if the user has logged in before
                    if(getPrefs.getBoolean("isLogin", false)){
                        //if logged in, go to the main activity
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }else {
                        //if not logged in, go to the login activity
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
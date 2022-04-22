package com.example.myapplication;
//Nim : 10119098
//Nama : Dila Adiliani
//Kelas : IF-3
//Tanggal Pengerjaan 21 April 2022

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
   TextView nama, kelas, nim, deskripsi;
   SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //hide navbar
        getSupportActionBar().hide();
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        nama = findViewById(R.id.textNama);
        kelas = findViewById(R.id.textKelas);
        nim = findViewById(R.id.textNim);
        deskripsi = findViewById(R.id.textDes);
        //set from sharedpreferences
        nama.setText("Dila Adiliani");
        kelas.setText("IF-3");
        nim.setText("10119098");
        //deskripsi.setText(sharedPreferences.getString("deskripsi", ""));
    }
}
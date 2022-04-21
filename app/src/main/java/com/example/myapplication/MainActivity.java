package com.example.myapplication;
//Nim : 10119098
//Nama : Dila Adiliani
//Kelas : IF-3
//Tanggal Pengerjaan 21 April 2022

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView nama;
    SharedPreferences sharedPreferences;
    Button btnProfil,btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hide navbar
        getSupportActionBar().hide();
        nama = findViewById(R.id.textNama);
        //get shared preference
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        //get value with key "nama"
        String namaValue = sharedPreferences.getString("nama", "nama");
        //set value ke textview
        nama.setText("Hello "+namaValue);
        btnProfil = findViewById(R.id.btnProfil);
        btnLogout = findViewById(R.id.btnLogout);
        btnProfil.setOnClickListener(v -> {
            //intent to profile activity
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        });
        btnLogout.setOnClickListener(v -> {
            //clear shared preference
            SharedPreferences.Editor editor = sharedPreferences.edit();
            //isLogin set to false
            editor.putBoolean("isLogin", false);
            //commit changes
            editor.commit();
            //toast berhasil logout
            Toast.makeText(this, "Berhasil logout", Toast.LENGTH_SHORT).show();
            //intent to login activity
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });
    }
}
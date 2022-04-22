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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    EditText nim,password, nama,kelas,deskripsi;
    Button btnRegister;
    TextView btnLogin;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //hide navbar
        getSupportActionBar().hide();
        nim = findViewById(R.id.txtusername);
        password = findViewById(R.id.txtpassword);
        nama = findViewById(R.id.txtNama);
        kelas = findViewById(R.id.txtKelas);
        deskripsi = findViewById(R.id.txtDes);
        btnRegister = findViewById(R.id.btnSignup);
        btnLogin = findViewById(R.id.btnLogin);

        btnRegister.setOnClickListener(v -> {
            sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("nim", nim.getText().toString());
            editor.putString("password", password.getText().toString());
            editor.putString("nama", nama.getText().toString());
            editor.putString("kelas", kelas.getText().toString());
            editor.putString("deskripsi", deskripsi.getText().toString());
            editor.apply();
            //Toast berhasil mendaftar
            Toast.makeText(this, "Berhasil mendaftar", Toast.LENGTH_SHORT).show();
           //intent to login activity
           startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
        });
        btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
        });
    }
}
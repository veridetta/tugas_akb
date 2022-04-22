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

public class LoginActivity extends AppCompatActivity {
    EditText nim, password;
    TextView btnSignup;
    Button btnLogin;
    SharedPreferences sharedPreferences;
    String nim_key = "nim", password_key = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //hide navbar
        getSupportActionBar().hide();
        nim = findViewById(R.id.txtusername);
        password = findViewById(R.id.txtpassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        //get shared preferences
        sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        btnLogin.setOnClickListener(v -> {
            String username_text = nim.getText().toString();
            String password_text = password.getText().toString();
            if(username_text.equals("") || password_text.equals("")){
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            }else{
                if(username_text.equals(sharedPreferences.getString(nim_key,"")) && password_text.equals(sharedPreferences.getString(password_key,""))){
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                    //set shared preferences login status
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isLogin",true);
                    editor.apply();
                    //intent to main activity
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }else{
                    //TOast wrong nim or password
                    Toast.makeText(this, "Wrong NIM or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSignup.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
        });
    };
}
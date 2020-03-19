package com.example.blujackkost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPass;
    Button btnLogin, btnRegistrasi;

    void validasi(){
        etUsername = findViewById(R.id.et_username);
        etPass = findViewById(R.id.et_pass);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistrasi = findViewById(R.id.btnRegistrasi);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        validasi();

    }

    public void onClickRegistrasi(View view) {
        Intent intent = new Intent(view.getContext(), RegisterActivity.class);
        startActivity(intent);

    }

    public void onClickLogin(View view) {
    }
}

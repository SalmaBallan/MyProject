package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {

    private EditText etMail, etPassword;
    private Button btnRegister, btnCancel;
    private TextView tvWelcome;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etMail = findViewById(R.id.etMail);
        etPassword= findViewById(R.id.etPassword);
        btnRegister= findViewById(R.id.btnRegister);
        btnCancel= findViewById(R.id.btnCancel);
        preferences= getSharedPreferences("UserInfo",0 );
    }
    public void register(View view) {
        String input_mail = etMail.getText().toString();
        String input_password = etPassword.getText().toString();
        if (input_mail.length() > 0) {
            //open prefrences file
            SharedPreferences.Editor editor = preferences.edit();
            // save key, value data
            // keyword: username/password, value: input_mail/input_password
            editor.putString("username", input_mail);
            editor.putString("password", input_password);
            editor.apply();
            Toast.makeText(this, "User registered!", Toast.LENGTH_LONG).show();
            Intent intent_main = new Intent(this, MainActivity.class);
            startActivity(intent_main);
        } else {
            Toast.makeText(this, "Empty values please insert!", Toast.LENGTH_SHORT).show();

        }
    }
        public void cancel (View view){
        Intent intent_cancel = new Intent(this, MainActivity.class);
        startActivity(intent_cancel);
        }
}
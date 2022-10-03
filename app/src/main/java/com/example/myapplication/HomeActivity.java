package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    // first step in object programming
Button buttonplus, buttonminus;
EditText editTextNumber, editTextNumberSigned;
TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // linking objects with design by id
        buttonplus = findViewById(R.id.buttonplus);
        buttonminus = findViewById( R.id.buttonminus);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumberSigned = findViewById(R.id.editTextNumberSigned);
        textViewResult = findViewById(R.id.textViesResult);
    }

    public void plus(View view) {
       double number1 =  Double.parseDouble(editTextNumber.getText().toString());
        double number2 =  Double.parseDouble(editTextNumberSigned.getText().toString());
       textViewResult.setText((number1+number2)+"");
       if (editTextNumber.getText().toString().equals(""))
           Toast.makeText(this, "No number entered", Toast.LENGTH_SHORT).show();
        if (editTextNumberSigned.getText().toString().equals(""))
            Toast.makeText(this, "No number entered", Toast.LENGTH_SHORT).show();
    }

    public void minus(View view) {
        double number1 = Double.parseDouble(editTextNumber.getText().toString());
        double number2 = Double.parseDouble(editTextNumberSigned.getText().toString());
        textViewResult.setText((number1-number2)+"");
        if (editTextNumber.getText().toString().equals(""))
            Toast.makeText(this, "No number entered", Toast.LENGTH_SHORT).show();
        if (editTextNumberSigned.getText().toString().equals(""))
            Toast.makeText(this, "No number entered", Toast.LENGTH_SHORT).show();
    }

}
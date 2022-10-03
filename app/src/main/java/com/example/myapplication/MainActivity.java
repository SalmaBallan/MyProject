package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonlogin, buttonSignUp;
    EditText editTextPassword2;
    EditText editTextEmailAddress2;
    SharedPreferences preferences;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmailAddress2 = findViewById(R.id.editTextEmailAddress2);
        editTextPassword2 = findViewById(R.id.editTextPassword2);
        buttonlogin = findViewById(R.id.buttonlogin);
        //create preferences file
        preferences=getSharedPreferences("UserInfo", 0);
        // read write permission for app

    }

    public void login(View view) {
        String input_mail= editTextEmailAddress2.getText().toString();
        String input_password = editTextPassword2.getText().toString();
        // this line gets the registered email and password, in case no user was registered empty string is returned
        String registerMail = preferences.getString("username","");
        String registerPassword = preferences.getString("password","");
        if (input_mail.equals(registerMail)&& input_password.equals(registerPassword)){
            Intent i_mail= new Intent(this, LoginActivity.class);
            startActivity(i_mail);
        }
        else {
            Toast.makeText(this, "Incorrect credentails!", Toast.LENGTH_SHORT).show();
        }
//    if (editTextEmailAddress2.getText().toString().equals(""))
//        Toast.makeText(this, "Empty Email",Toast.LENGTH_LONG).show();
//    else if (editTextPassword2.getText().toString().equals(""))
//        Toast.makeText(this, "Empty password",Toast.LENGTH_LONG).show();
//      else {
//        Intent i = new Intent(this, HomeActivity.class);
//        startActivity(i);
//        }
    }

    // load option menu from an activity

// this method loads the menu design into this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuexample,menu);
        return true;
    }
    // handle option menu click events
    //R- resources, menu-file

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            //in case user chose help menu
            case R.id.helpMenu:
                Toast.makeText(MainActivity.this, "help clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, ActivityHelp.class);
                startActivity(i);
                break;
            case R.id.settingMenu:
                Toast.makeText(MainActivity.this, "setting clicked", Toast.LENGTH_SHORT).show();
                Intent n = new Intent(this, SettingActivity.class);
                startActivity(n);
                break;
            case R.id.logoutMenu:
                Toast.makeText(MainActivity.this, "logOut clicked", Toast.LENGTH_SHORT).show();
                Intent s = new Intent(this, LoginActivity.class);
                startActivity(s);
                break;
            case R.id.aboutMenu:
                Toast.makeText(MainActivity.this, "logOut clicked", Toast.LENGTH_SHORT).show();
                Intent f = new Intent(this, SettingActivity.class);
                startActivity(f);
                break;
            case R.id.listMenu:
                Toast.makeText(MainActivity.this, "list", Toast.LENGTH_SHORT).show();
                Intent m= new Intent(this, listActivity.class);
                startActivity(m);
                break;
        }
      return true;
    }

    @Override
    // this is called by the OS in case the user clicks back button
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Back button was pressed!");
        dialog.setMessage("Are you sure you want to exit?");
        //in case the user chose no, nothing happens the dialog closes
        dialog.setNegativeButton("NO",null);
        //when the user clicks on the yes button the app closes
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
dialog.setIcon(R.drawable.ic_baseline_close_24);
AlertDialog alertDialog = dialog.create();
alertDialog.show();
    }

    public void register(View view) {
        Intent i_register = new Intent( this, registerActivity.class);
        startActivity(i_register);
    }
}

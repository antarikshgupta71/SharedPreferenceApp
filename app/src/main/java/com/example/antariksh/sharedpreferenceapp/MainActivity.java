package com.example.antariksh.sharedpreferenceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonInsert, buttonView;
    EditText etName,etPassword;
    TextView tvRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName= findViewById(R.id.editTextName);
        etPassword=findViewById(R.id.editTextPassword);

        tvRes=findViewById(R.id.textViewRes);
        buttonInsert=findViewById(R.id.buttonInsert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("username",etName.getText().toString());
                editor.putString("password",etPassword.getText().toString());

                editor.apply();
                etName.setText(null);
                etPassword.setText(null);
            }
        });
        buttonView=findViewById(R.id.buttonView);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                String name=preferences.getString("username",null);
                String pwd=preferences.getString("password",null);
                tvRes.setText("Name: "+name+"\n  Password:" +pwd);

            }
        });

    }

}

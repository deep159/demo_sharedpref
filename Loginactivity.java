package com.example.hi.sharedpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginactivity extends AppCompatActivity implements View.OnClickListener {
    EditText memail,mpass;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        memail= (EditText) findViewById(R.id.lemail);
        mpass= (EditText) findViewById(R.id.lpass);
        b2= (Button) findViewById(R.id.login);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String email=memail.getText().toString().trim();
        String pass=mpass.getText().toString().trim();
        SharedPreferences pref=getSharedPreferences("userdata", Context.MODE_PRIVATE);
        String p_email=pref.getString("user_email",null);
        String p_pass=pref.getString("user_pass",null);
        if(email.equals(p_email)&&p_pass.equals(pass)){
            Toast.makeText(this,"valid user",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Loginactivity.this,homeactivity.class));
            finish();
        }
        else{
            Toast.makeText(this,"invalid user",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Loginactivity.this,Loginactivity.class));
            finish();
        }
    }
}

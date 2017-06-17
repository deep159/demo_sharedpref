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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText memail,mpass;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        memail= (EditText) findViewById(R.id.email);
        mpass= (EditText) findViewById(R.id.pass);
        b1= (Button) findViewById(R.id.button);
        b1.setOnClickListener(this);
        SharedPreferences pref=getSharedPreferences("userdata", Context.MODE_PRIVATE);
        String p_email=pref.getString("user_email",null);
        String p_pass=pref.getString("user_pass",null);
        if(p_email!=null&&p_pass!=null){
            startActivity(new Intent(MainActivity.this,Loginactivity.class));
        }

    }

    @Override
    public void onClick(View v) {
        String email=memail.getText().toString().trim();
        String pass=mpass.getText().toString().trim();
        SharedPreferences pref2=getSharedPreferences("userdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref2.edit();
        editor.putString("user_email",email);
        editor.putString("user_pass",pass);
        editor.commit();
        Toast.makeText(this,"Registered successfully",Toast.LENGTH_SHORT).show();
        memail.setText("");
        mpass.setText("");
        startActivity(new Intent(MainActivity.this,Loginactivity.class));
    }
}

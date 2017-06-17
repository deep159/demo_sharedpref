package com.example.hi.sharedpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeactivity extends AppCompatActivity implements View.OnClickListener {
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        b3= (Button) findViewById(R.id.logout);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(homeactivity.this,MainActivity.class));
        SharedPreferences pref=getSharedPreferences("userdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.clear();
        editor.commit();
    }
}

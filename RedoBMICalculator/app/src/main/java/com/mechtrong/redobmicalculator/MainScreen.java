package com.mechtrong.redobmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void chuyenManHinh(View view){
        Intent iBMIScreen = new Intent(this, MainActivity.class);
        startActivity(iBMIScreen);
    }
}
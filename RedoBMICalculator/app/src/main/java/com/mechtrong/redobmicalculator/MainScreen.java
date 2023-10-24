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

    public void chuyenManHinh_BMI(View view){
        Intent iBMIScreen = new Intent(this, MainActivity_BMI.class);
        startActivity(iBMIScreen);
    }
    public void chuyenManHinh_Lunch(View view){
        Intent iLunchScreen = new Intent(this, MainActivity_Lunch.class);
        startActivity(iLunchScreen);
    }
}
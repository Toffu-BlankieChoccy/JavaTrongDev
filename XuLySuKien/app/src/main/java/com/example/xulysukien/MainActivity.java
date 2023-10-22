package com.example.xulysukien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void XuLyNhanOK(View v){
        String chuoiThongBao = "U just pressed a button";
        Toast.makeText(this, chuoiThongBao, Toast.LENGTH_SHORT).show();
    }
}
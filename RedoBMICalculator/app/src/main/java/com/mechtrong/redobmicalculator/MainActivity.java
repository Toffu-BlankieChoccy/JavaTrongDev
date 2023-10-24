package com.mechtrong.redobmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView result;
    EditText height, weight;
    Button btn;
    int w, h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.edtHeight);
        weight = findViewById(R.id.edtWeight);
        btn = findViewById(R.id.btnCal);
        result = findViewById(R.id.tvResult);

        btn.setOnClickListener(this);
    }

    public int getData(EditText editText){
        return Integer.parseInt(editText.getText().toString());
    }

    public float calculateBMI(int heightInCm, int weightInKg) {
        float heightInM = heightInCm / 100.0f;
        return weightInKg / (heightInM * heightInM);
    }

    public void quayVeManHinh(View v){
        Intent iMainScreen = new Intent(this, MainScreen.class);
        startActivity(iMainScreen);
    }
    @Override
    public void onClick(View view) {
        h = getData(height);
        w = getData(weight);
        int id = view.getId();

        if(id == R.id.btnCal){
            if (h > 0 && w > 0) {
                float bmi = calculateBMI(h, w);
                if (bmi < 20)
                {
                    String state = String.format("YOUR RESULT \n%.1f\nUNDERWEIGHT",bmi);
                    result.setText(state);
                } else if(bmi<=25){
                    String state = String.format("YOUR RESULT \n%.1f\nNORMAL",bmi);
                    result.setText(state);
                } else if(bmi<=30){
                    String state = String.format("YOUR RESULT \n%.1f\nOVERWEIGHT",bmi);
                    result.setText(state);
                } else if(bmi<=40){
                    String state = String.format("YOUR RESULT \n%.1f\nOBESE",bmi);
                    result.setText(state);
                } else {
                    String state = String.format("YOUR RESULT \n%.1f\nMORBIDLY OBESE",bmi);
                    result.setText(state);
                }
        } else{
                Toast.makeText(this, "Invalid height and weight!",Toast.LENGTH_SHORT).show();
                result.setText("");
            }
        }
    }
}
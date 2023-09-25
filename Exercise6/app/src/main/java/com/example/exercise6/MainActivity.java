package com.example.exercise6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.animation.AnimatableView;

//Implement click event
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button addBtn, minusBtn, multiBtn, divBtn;
    EditText num1, num2;
    TextView textView;
    int n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Exercise 6 - Simple Calculator");
        addBtn = findViewById(R.id.addBtn);
        minusBtn = findViewById(R.id.minusBtn);
        multiBtn = findViewById(R.id.multiBtn);
        divBtn = findViewById(R.id.divBtn);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        textView = findViewById(R.id.result);

        addBtn.setOnClickListener(this);minusBtn.setOnClickListener(this);multiBtn.setOnClickListener(this);divBtn.setOnClickListener(this);
    }

    public int getNum(EditText editText)
    {
        if(editText.getText().toString().equals("")) {
            Toast.makeText(this, "Number(s) is required to be filled", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Integer.parseInt(editText.getText().toString());
    }

    @Override
    public void onClick(View view) {
        n1 = getNum(num1);
        n2 = getNum(num2);
        int id = view.getId();
        if (id == R.id.addBtn) {
            textView.setText(n1 + " + " + n2 + " = " + (n1 + n2));
        } else if (id == R.id.minusBtn) {
            textView.setText(n1 + " - " + n2 + " = " + (n1 - n2));
        } else if (id == R.id.multiBtn) {
            textView.setText(n1 + " x " + n2 + " = " + (n1 * n2));
        } else if (id == R.id.divBtn) {
            if (n2 == 0){
                Toast.makeText(this, "Cannot devide by 0", Toast.LENGTH_SHORT).show();
                return;
            }
            textView.setText(n1 + " / " + n2 + " = " + (n1 / n2));
        }

    }
}
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
    float n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Setup an in-app title
        getSupportActionBar().setTitle("Exercise 6 - Simple Calculator");
        //Register ID for each variable
        addBtn = findViewById(R.id.addBtn);
        minusBtn = findViewById(R.id.minusBtn);
        multiBtn = findViewById(R.id.multiBtn);
        divBtn = findViewById(R.id.divBtn);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        textView = findViewById(R.id.result);

        addBtn.setOnClickListener(this); minusBtn.setOnClickListener(this); multiBtn.setOnClickListener(this); divBtn.setOnClickListener(this);
    }

    public float getNum(EditText editText)
    {
        String input = editText.getText().toString().trim(); // Get the input as a string and remove leading/trailing spaces
        if (input.isEmpty()) {
            Toast.makeText(this, "Number(s) are required to be filled", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Float.parseFloat(input);
    }

    @Override
    public void onClick(View view) {
        n1 = getNum(num1);
        n2 = getNum(num2);
        if(num1.getText().toString().equals("") || num2.getText().toString().equals("")) {
            Toast.makeText(this, "Number(s) are required to be filled", Toast.LENGTH_SHORT).show();
            textView.setText("");
            return;
        }
        else {
            int id = view.getId();

            if (id == R.id.addBtn) {
                textView.setText(n1 + " + " + n2 + " = " + (n1 + n2));
            } else if (id == R.id.minusBtn) {
                textView.setText(n1 + " - " + n2 + " = " + (n1 - n2));
            } else if (id == R.id.multiBtn) {
                textView.setText(n1 + " x " + n2 + " = " + (n1 * n2));
            } else if (id == R.id.divBtn) {
                if (n2 == 0) {
                    Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                textView.setText(n1 + " / " + n2 + " = " + (n1 / n2));
            }
        }
    }
}
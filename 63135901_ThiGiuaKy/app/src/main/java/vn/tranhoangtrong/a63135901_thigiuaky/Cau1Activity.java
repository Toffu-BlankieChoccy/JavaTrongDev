package vn.tranhoangtrong.a63135901_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class Cau1Activity extends AppCompatActivity implements View.OnClickListener {
    public void quayVeManHinh(View v){
        Intent iMainScreen = new Intent(this, MainActivity.class);
        startActivity(iMainScreen);
    }
    Button addBtn;
    EditText num1, num2;
    TextView textView;
    float n1, n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1);

        addBtn = findViewById(R.id.addBtn);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        textView = findViewById(R.id.result);

        addBtn.setOnClickListener(this);
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

            if (id == R.id.addBtn)
                textView.setText((n1+n2)+"");
            }
    }
}
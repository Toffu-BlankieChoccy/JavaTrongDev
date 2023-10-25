package vn.tranhoangtrong.a63135901_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void manHinhCau1(View view){
        Intent iCau1 =new Intent (this,Cau1Activity.class);
        startActivity(iCau1);
    }
    public void manHinhCau2(View view){
        Intent iCau2 =new Intent (this,Cau2Activity.class);
        startActivity(iCau2);
    }
    public void manHinhCau3(View view){
        Intent iCau3 =new Intent (this,Cau3Activity.class);
        startActivity(iCau3);
    }
    public void manHinhCau4(View view){
        Intent iCau4 =new Intent (this,Cau4Activity.class);
        startActivity(iCau4);
    }
}
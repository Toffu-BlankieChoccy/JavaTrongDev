package vn.tranhoangtrong.a63135901_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cau2Activity extends AppCompatActivity {
    ArrayList<String> lstNNLT = new ArrayList<String>();
    ListView auLV;
    public void quayVeManHinh(View v){
        Intent iMainScreen = new Intent(this, MainActivity.class);
        startActivity(iMainScreen);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);
        getWidget();
        lstNNLT.add("C++");
        lstNNLT.add("Java");
        lstNNLT.add("Ruby");
        lstNNLT.add("Python");
        lstNNLT.add("Android Kotlin");
        lstNNLT.add("Rust");
        lstNNLT.add("Javascript");
        lstNNLT.add("Scratch");
        lstNNLT.add("Super Famicom");
        ArrayAdapter<String> adapterNNLT = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, lstNNLT);

        auLV.setAdapter(adapterNNLT);

        auLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mucChon = lstNNLT.get(position).toString();
                String chuoiThongBao = "Select one" + mucChon;
                Toast.makeText(Cau2Activity.this, chuoiThongBao, Toast.LENGTH_SHORT ).show();
            }
        });

    }

    public void getWidget() {
        auLV = findViewById(R.id.lv);
    }
}
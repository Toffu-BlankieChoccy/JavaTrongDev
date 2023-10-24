package com.mechtrong.redobmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity_Lunch extends AppCompatActivity {
    public void quayVeManHinh(View v){
        Intent iMainScreen = new Intent(this, MainScreen.class);
        startActivity(iMainScreen);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listmeal);

        ListView lvMeal = (ListView)findViewById(R.id.lvFood);

        ArrayList<Meal> dsMeal = new ArrayList<>();
        Meal m1 = new Meal("Cơm gà",30000,R.drawable.cg,"Cơm, gà chiên, sốt.");
        Meal m2 = new Meal("Cơm chiên dương châu",30000,R.drawable.ccdc,"Cơm, gà chiên, sốt.");
        Meal m3 = new Meal("Cơm tấm sườn bì chả",30000,R.drawable.ctbc,"Cơm, gà chiên, sốt.");
        Meal m4 = new Meal("Cơm nắm",30000,R.drawable.onigiri,"Cơm, gà chiên, sốt.");
        Meal m5 = new Meal("Nước lọc",30000,R.drawable.water,"Cơm, gà chiên, sốt.");
        dsMeal.add(m1);
        dsMeal.add(m2);
        dsMeal.add(m3);
        dsMeal.add(m4);
        dsMeal.add(m5);

        MealAdapter mealAdapter = new MealAdapter(dsMeal,this);
        lvMeal.setAdapter(mealAdapter);

        lvMeal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //
                Meal mealOption = dsMeal.get(position);
                //
                Toast.makeText(MainActivity_Lunch.this, mealOption.getTenMonAn(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
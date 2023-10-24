package com.mechtrong.redobmicalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MealAdapter extends BaseAdapter {
    private ArrayList<Meal> lstMeal;
    private LayoutInflater inflater;
    private Context context;

    public MealAdapter(ArrayList<Meal> lstMeal, Context _context) {
        this.lstMeal = lstMeal;
        this.context = _context;
        this.inflater = LayoutInflater.from(_context);
    }


    @Override
    public int getCount() {
        return lstMeal.size();
    }

    @Override
    public Object getItem(int position) {
        return lstMeal.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null)
            view = inflater.inflate((R.layout.layout_meal),null);
        Meal currentMeal = lstMeal.get(position);

        TextView foodName = (TextView)view.findViewById(R.id.tvFoodName);
        TextView foodPrice = (TextView)view.findViewById(R.id.tvFoodPrice);
        TextView foodDes = (TextView)view.findViewById(R.id.tvFoodDes);
        ImageView foodImg = (ImageView)view.findViewById(R.id.imgFood);

        foodName.setText(currentMeal.getTenMonAn());
        foodPrice.setText(String.valueOf(currentMeal.getGiaMonAn()));
        foodDes.setText(currentMeal.getMoTaMonAn());
        foodImg.setImageResource(currentMeal.getAnhMonAn());

        return view;
    }
}

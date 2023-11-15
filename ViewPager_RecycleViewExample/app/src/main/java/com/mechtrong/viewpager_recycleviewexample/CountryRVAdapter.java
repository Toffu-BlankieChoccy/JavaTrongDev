package com.mechtrong.viewpager_recycleviewexample;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryRVAdapter extends RecyclerView.Adapter {
    List<Country> lstDataSource;
    public CountryRVAdapter(List<Country> lstDataSource) {
        this.lstDataSource = lstDataSource;
    }

    public final class CountryItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView flagView;
        TextView countryNameView;
        TextView populationView;
        public int position;
        public CountryItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            flagView = (ImageView)itemView.findViewById(R.id.imageViewFlag);
            countryNameView =(TextView)itemView.findViewById(R.id.textViewCountryName);
            populationView = (TextView)itemView.findViewById(R.id.textViewPopulation);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            Country country = lstDataSource.get(clickedPosition);
            Toast.makeText(view.getContext(), "Clicked: " + country.getCountryName(), Toast.LENGTH_SHORT).show();
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item_layout, parent, false);
        CountryItemViewHolder vh = new CountryItemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CountryItemViewHolder viewHolder = (CountryItemViewHolder) holder;
        viewHolder.position = position;

        Country country = lstDataSource.get(position);

        ((CountryItemViewHolder) holder).countryNameView.setText(country.getCountryName());
        ((CountryItemViewHolder) holder).flagView.setImageResource( getMipmapResId(holder.itemView, country.getCountryFlag()));
        ((CountryItemViewHolder) holder).populationView.setText(String.valueOf(country.getPopulation()) );

    }

    private int getMipmapResId(View itemView, String mipmapName) {
        String packageName = itemView.getContext().getPackageName();
        return itemView.getResources().getIdentifier(mipmapName, "mipmap", packageName);
    }

    @Override
    public int getItemCount() {
        return lstDataSource.size();
    }
}

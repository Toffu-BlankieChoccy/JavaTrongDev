package com.mechtrong.viewpagerex;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class HelloFragmentStateAdapter extends FragmentStateAdapter {
    List<String> lstHello;
    public HelloFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity, List<String> lstH) {
        super(fragmentActivity);
        lstHello = lstH;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        String s= lstHello.get(position);
        return new HelloFragment(s);
    }

    @Override
    public int getItemCount() {
        return lstHello.size();
    }
}

package com.mechtrong.apponlinechattingproject_63135901.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mechtrong.apponlinechattingproject_63135901.R;
import com.mechtrong.apponlinechattingproject_63135901.databinding.ActivitySignInBinding;
import com.mechtrong.apponlinechattingproject_63135901.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListener();
    }

    private void setListener(){
       binding.textSignIn.setOnClickListener(v -> onBackPressed());
    }
}
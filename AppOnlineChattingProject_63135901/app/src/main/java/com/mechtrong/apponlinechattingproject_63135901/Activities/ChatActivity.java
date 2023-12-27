package com.mechtrong.apponlinechattingproject_63135901.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mechtrong.apponlinechattingproject_63135901.Models.User;
import com.mechtrong.apponlinechattingproject_63135901.R;
import com.mechtrong.apponlinechattingproject_63135901.Utilities.Constants;
import com.mechtrong.apponlinechattingproject_63135901.databinding.ActivityChatBinding;

public class ChatActivity extends AppCompatActivity {

    private ActivityChatBinding binding;
    private User receiverUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
        loadReceiverDetails();
    }

    private void loadReceiverDetails(){
        receiverUser =(User) getIntent().getSerializableExtra(Constants.KEY_USER);
        binding.textName.setText(receiverUser.name);
    }

    private void setListeners(){
        binding.imageBack.setOnClickListener(v -> onBackPressed());
    }
}
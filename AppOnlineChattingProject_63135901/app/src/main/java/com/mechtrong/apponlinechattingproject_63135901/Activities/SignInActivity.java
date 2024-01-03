package com.mechtrong.apponlinechattingproject_63135901.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.Firebase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mechtrong.apponlinechattingproject_63135901.Utilities.Constants;
import com.mechtrong.apponlinechattingproject_63135901.Utilities.PrefrencesManager;
import com.mechtrong.apponlinechattingproject_63135901.databinding.ActivitySignInBinding;

import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;
    private PrefrencesManager prefrencesManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefrencesManager = new PrefrencesManager(getApplicationContext());
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListener();
    }

    private void setListener(){
        binding.textCreateNewAccount.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));
        binding.buttonSignIn.setOnClickListener(v -> {
            if (isValid()){
                signIn();
            }
        });

    }

    private void showToast(String message)
    {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void signIn(){
        loading(true);

        //entry point for accessing Cloud Firestore.
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        // Constructs a query to search for a user in the "users" collection with the provided email and password.
        database.collection(Constants.KEY_COLLECTION_USERS)
                .whereEqualTo(Constants.KEY_EMAIL, binding.inputEmail.getText().toString())
                .whereEqualTo(Constants.KEY_PASSWORD, binding.inputPassword.getText().toString())
                .get()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful() && task.getResult() != null && task.getResult().getDocuments().size()>0)
                    {
                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
                        prefrencesManager.putBoolean(Constants.KEY_IS_SIGNED_IN, true);
                        prefrencesManager.putString(Constants.KEY_USER_ID, documentSnapshot.getId());
                        prefrencesManager.putString(Constants.KEY_NAME, documentSnapshot.getString(Constants.KEY_NAME));
                        prefrencesManager.putString(Constants.KEY_IMAGE, documentSnapshot.getString(Constants.KEY_IMAGE));

                        //Start MainActivity and clear all the previous activities
                        Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }else{
                        loading(false);
                        showToast("Đăng nhập thất bại");
                        binding.buttonSignIn.setVisibility(View.VISIBLE);
                    }
                });

    }

    //Loading animation
    private void loading(Boolean isLoading){
        if(isLoading)
        {
            binding.buttonSignIn.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.INVISIBLE);
        }else {
            binding.buttonSignIn.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        }
    }

    private Boolean isValid(){
        if(binding.inputEmail.getText().toString().trim().isEmpty()) {
            showToast("Hãy nhập email");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches()){
            showToast("Email không đúng");
            return false;
        }else if(binding.inputPassword.getText().toString().trim().isEmpty()){
            showToast("Hãy nhập mật khẩu");
            return false;
        }else return true;
    }
}
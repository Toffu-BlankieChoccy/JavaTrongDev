package com.mechtrong.apponlinechattingproject_63135901.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.mechtrong.apponlinechattingproject_63135901.Utilities.Constants;
import com.mechtrong.apponlinechattingproject_63135901.Utilities.PrefrencesManager;
import com.mechtrong.apponlinechattingproject_63135901.databinding.ActivitySignUpBinding;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    private PrefrencesManager prefrencesManager;
    private String encodeImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefrencesManager = new PrefrencesManager(getApplicationContext());
        setListener();
    }

    private void setListener(){
       binding.textSignIn.setOnClickListener(v -> onBackPressed());
       binding.buttonSignUp.setOnClickListener(v -> {
           if(isValid()){
               signUp();
           }
       });
       binding.layoutImage.setOnClickListener(v -> {
           Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
           intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
           pickImage.launch(intent);
       });
    }

    private void showToast(String mess)
    {
        Toast.makeText(getApplicationContext(),mess,Toast.LENGTH_LONG).show();
    }

    private void signUp(){
        loading(true);
        //entry point for accessing Cloud Firestore.
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        HashMap<String, Object> user = new HashMap<>();
        user.put(Constants.KEY_NAME,binding.inputName.getText().toString());
        user.put(Constants.KEY_EMAIL,binding.inputEmail.getText().toString());
        user.put(Constants.KEY_PASSWORD,binding.inputPassword.getText().toString());
        user.put(Constants.KEY_IMAGE,encodeImage);
        database.collection(Constants.KEY_COLLECTION_USERS).add(user)
                .addOnSuccessListener(documentReference -> {
                    loading(false);
                    prefrencesManager.putBoolean(Constants.KEY_IS_SIGNED_IN, true);
                    prefrencesManager.putString(Constants.KEY_USER_ID, documentReference.getId());
                    prefrencesManager.putString(Constants.KEY_NAME, binding.inputName.getText().toString());
                    prefrencesManager.putString(Constants.KEY_IMAGE, encodeImage);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                })
                .addOnFailureListener(exception -> {
                    loading(false);
                    showToast(exception.getMessage());
                });
    }

    private String encodeImage(Bitmap bitmap){
        int previewWidth = 150;
        int previewHeight = bitmap.getHeight() * previewWidth/ bitmap.getWidth();
        Bitmap previewBitmap = Bitmap.createScaledBitmap(bitmap, previewWidth, previewHeight, false);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        previewBitmap.compress(Bitmap.CompressFormat.JPEG, 50,byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    private final ActivityResultLauncher<Intent> pickImage = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result ->{
                if (result.getResultCode() == RESULT_OK){
                    if(result.getData() != null){
                        Uri imageUri = result.getData().getData();
                        try{
                            InputStream inputStream = getContentResolver().openInputStream(imageUri);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            binding.imageProfile.setImageBitmap(bitmap);
                            binding.textAddImage.setVisibility(View.GONE);
                            encodeImage = encodeImage(bitmap);
                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
    );


    //Check user's data validation
    private Boolean isValid()
    {
        if(encodeImage == null){
            showToast("Bạn chưa chọn ảnh đại diện");
            return false;
        }else if(binding.inputName.getText().toString().trim().isEmpty()){
            showToast("Hãy nhập tên");
            return false;
        }else if(binding.inputEmail.getText().toString().trim().isEmpty()) {
            showToast("Hãy nhập email");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches()) {
            showToast("Hãy nhập đúng email");
            return false;
        }else if(binding.inputPassword.getText().toString().trim().isEmpty()) {
            showToast("Hãy nhập mật khẩu ");
            return false;
        }else if(binding.inputConfirmPassword.getText().toString().trim().isEmpty()) {
            showToast("Hãy lại mật khẩu");
            return false;
        }else if(!binding.inputPassword.getText().toString().equals(binding.inputConfirmPassword.getText().toString())){
            showToast("Mật khẩu nhập lại chưa đúng");
            return false;
        }else return true;
    }


    //Loading animation
    private void loading(Boolean isLoading){
        if(isLoading)
        {
            binding.buttonSignUp.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.INVISIBLE);
        }else {
            binding.buttonSignUp.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        }
    }
}
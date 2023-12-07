package com.mechtrong.apponlinechattingproject_63135901.Activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Base64;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.mechtrong.apponlinechattingproject_63135901.R;
import com.mechtrong.apponlinechattingproject_63135901.databinding.ActivitySignInBinding;
import com.mechtrong.apponlinechattingproject_63135901.databinding.ActivitySignUpBinding;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    private String encodeImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListener();
    }

    private void setListener(){
       binding.textSignIn.setOnClickListener(v -> onBackPressed());
       binding.buttonSignUp.setOnClickListener(v -> {
           if(isValid()){
               signUp();
           }
       });
    }

    private void showToast(String mess)
    {
        Toast.makeText(getApplicationContext(),mess,Toast.LENGTH_LONG).show();
    }

    private void signUp(){

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

    private Boolean isValid()
    {
        if(encodeImage == null){
            showToast("Bạn chưa chọn ảnh đại diện");
            return false;
        }else if(binding.inputName.getText().toString().trim().isEmpty()){
            showToast("Hãy nhập tên");
            return false;
        }else if(binding.inputEmail.getText().toString().trim().isEmpty()) {
            showToast("Hãy email");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches()) {
            showToast("Hãy nhập đúng email");
            return false;
        }else if(binding.inputPassword.getText().toString().trim().isEmpty()) {
            showToast("Hãy nhập khẩu ");
            return false;
        }else if(binding.inputConfirmPassword.getText().toString().trim().isEmpty()) {
            showToast("Hãy lại mật khẩu");
            return false;
        }else if(!binding.inputPassword.getText().toString().equals(binding.inputConfirmPassword.getText().toString())){
            showToast("Mật khẩu nhập lại chưa đúng");
            return false;
        }else return true;
    }

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
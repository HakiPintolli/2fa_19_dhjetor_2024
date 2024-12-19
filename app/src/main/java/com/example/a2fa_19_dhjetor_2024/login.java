package com.example.a2fa_19_dhjetor_2024;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {
    private EditText inputEmail, inputPassword;
    private Button loginButton;

    @Override
    protected  void onCreate(Bundle setInstanceState){
        super.onCreate(setInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail=findViewById(R.id.inputEmail);
        inputPassword=findViewById(R.id.inputPassword);
        loginButton=findViewById(R.id.login);

        loginButton.setOnClickListener(v -> {
            String email=inputEmail.getText().toString();
            String password=inputPassword.getText().toString();
            if(ValidateCredent(email , password)){
                Toast.makeText(this , "U logua" ,Toast.LENGTH_SHORT).show();
                navigateToMain();
            }
        });
    }
    public boolean ValidateCredent(String email, String password){
        return email.equals("haki.pintolli@gmail.com") && password.equals("hello123");
    }
    public void navigateToMain(){
        Intent intent= new Intent(this , MainActivity.class);
        startActivity(intent);
        finish();
    }
}
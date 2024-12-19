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

public class signup extends AppCompatActivity {

    private EditText emailInput, passwordInput, nameInput, usernameInput;
    private Button signInButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        emailInput = findViewById(R.id.email);
        passwordInput = findViewById(R.id.password);
        nameInput = findViewById(R.id.fullname);
        usernameInput = findViewById(R.id.username);
        signInButton = findViewById(R.id.signup);
        loginButton = findViewById(R.id.login2);


        signInButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            String name = nameInput.getText().toString().trim();
            String username = usernameInput.getText().toString().trim();

            if (authenticateUser(email, password)) {
                Toast.makeText(this, "Access granted!", Toast.LENGTH_SHORT).show();
                redirectToVerification(email, name, username);
            } else {
                Toast.makeText(this, "Invalid email or password!", Toast.LENGTH_SHORT).show();
            }
        });


        loginButton.setOnClickListener(v -> {

            Intent loginIntent = new Intent(signup.this, login.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(loginIntent);
            finish();
        });
    }


    private boolean authenticateUser(String email, String password) {
        return email.equals("haki.pintolli@gmail.com") && password.equals("hello123");
    }


    private void redirectToVerification(String userEmail, String userName, String userUsername) {
        Intent verifyIntent = new Intent(this, verification.class);
        verifyIntent.putExtra("email_address", userEmail);
        verifyIntent.putExtra("name", userName);
        verifyIntent.putExtra("username", userUsername);
        startActivity(verifyIntent);
    }
}
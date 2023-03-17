package com.example.gas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    EditText signupEmail,signupUsername,signupPassword;
    TextView loginRedirecting;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_name);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signupButton);
        loginRedirecting = findViewById(R.id.loginRedirecting);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String username = signupUsername.getText().toString();
                String email = signupEmail.getText().toString();
                String password = signupPassword.getText().toString();

                HelperClass helperClass = new HelperClass(email,username,password);
                reference.child(username).setValue(helperClass);

                Toast.makeText(SignupActivity.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this, Log.class);
                startActivity(intent);
            }
        });

        loginRedirecting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
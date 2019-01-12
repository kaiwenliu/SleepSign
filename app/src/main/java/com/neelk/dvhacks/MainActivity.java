package com.neelk.dvhacks;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        Button signup = findViewById(R.id.sgnup);
        Button login = findViewById(R.id.login);

        TextView forgotPassword = findViewById(R.id.textViewForgotPassword);

        signup.setOnClickListener(signUpOnClick);
        login.setOnClickListener(loginOnClick);
        forgotPassword.setOnClickListener(forgotPasswordOnClickListener);

    }

    private View.OnClickListener signUpOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            startActivity(new Intent(MainActivity.this, SignUP.class));

        }

    };

    private View.OnClickListener forgotPasswordOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            startActivity(new Intent(MainActivity.this, ForgotPassword.class));
        }
    };


    private View.OnClickListener loginOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            final EditText emailField = findViewById(R.id.editTextEmail);
            final EditText passwordField = findViewById(R.id.editTextPassword);
            final String userEmail = emailField.getText().toString().trim();
            final String userPassword = passwordField.getText().toString().trim();

            if (TextUtils.isEmpty(userEmail)) {

                Toast.makeText(MainActivity.this, "You must enter an email", Toast.LENGTH_SHORT).show();
                return;
            } else if (TextUtils.isEmpty(userPassword)) {

                Toast.makeText(MainActivity.this, "You must enter a password", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(userEmail, userPassword)
                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                startActivity(new Intent(MainActivity.this, NavigationBarManager.class));
                            } else {
                                Toast.makeText(MainActivity.this, "Login Failed, Please try Again", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    });


        }
    };
}

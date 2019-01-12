package com.neelk.dvhacks;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUP extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private Button signup;
    private Button back;
    private FirebaseAuth maAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        maAuth = FirebaseAuth.getInstance();


        signup = findViewById(R.id.sgnup);
        back = findViewById(R.id.back);

        signup.setOnClickListener(signUpOnClick);
        back.setOnClickListener(backOnClick);
    }


    private View.OnClickListener signUpOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            final EditText emailEditText = findViewById(R.id.sgnupemail);
            final EditText passwordEditText = findViewById(R.id.sgnuppassword);
            final String emailInfo = emailEditText.getText().toString().trim();

            final String passwordInfo = passwordEditText.getText().toString().trim();

            if (TextUtils.isEmpty(emailInfo)) {

                Toast.makeText(SignUP.this, "You must enter an email", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(passwordInfo)) {

                Toast.makeText(SignUP.this, "You must enter a password", Toast.LENGTH_SHORT).show();
                return;
            }
            if (passwordInfo.length() < 6) {
                Toast.makeText(SignUP.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                return;
            }


            maAuth.createUserWithEmailAndPassword(emailInfo, passwordInfo)
                    .addOnCompleteListener(SignUP.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUP.this, "Registration was Sucessful!", Toast.LENGTH_SHORT).show();


                            } else {
                                Toast.makeText(SignUP.this, "Registration Failed, Please Try Again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    };

    private View.OnClickListener backOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            startActivity(new Intent(SignUP.this, MainActivity.class));

        }
    };

}




package com.neelk.dvhacks;

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
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText resetPasswordEditText;
    private Button back;
    private Button resetPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        mAuth = FirebaseAuth.getInstance();

        final EditText resetPasswordEditText = findViewById(R.id.resetPasswordEditText);
        Button back = findViewById(R.id.backButtton);
        Button resetPasswordButton = findViewById(R.id.resetPasswordButton);

        back.setOnClickListener(backOnClick);
        resetPasswordButton.setOnClickListener(resetOnClickListener);

    }

    private View.OnClickListener resetOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String userEmail = resetPasswordEditText.getText().toString();
            if (TextUtils.isEmpty(userEmail)) {
                Toast.makeText(ForgotPassword.this, "Please enter the email you created an account with.", Toast.LENGTH_SHORT).show();
            } else {

                mAuth.sendPasswordResetEmail(userEmail)
                        .addOnCompleteListener(ForgotPassword.this, new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(ForgotPassword.this, "Password Reset Sucessful! Please check your email", Toast.LENGTH_SHORT).show();


                                } else {
                                    Toast.makeText(ForgotPassword.this, "Password Reset Failed, Please enter the email address your signed up with.", Toast.LENGTH_SHORT).show();
                                }
                            }


                        });
            }
        }
    };

    private View.OnClickListener backOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivity(new Intent(ForgotPassword.this, MainActivity.class));
        }
    };

}


package com.atees.ateesglobelcrm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import io.github.muddz.styleabletoast.StyleableToast;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout EmailorUsernameET;
    private TextInputLayout PasswordET;
    private CardView Login;
    private TextView Register;
    private TextView forgotpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Window window = LoginActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(LoginActivity.this, R.color.white));

        EmailorUsernameET = findViewById(R.id.emailorusername);
        PasswordET = findViewById(R.id.password);
        Login = findViewById(R.id.loginCV);
        Register = findViewById(R.id.registerTV);
        forgotpassword = findViewById(R.id.forgotpassword);


        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


//        Login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (TextUtils.isEmpty(Objects.requireNonNull(EmailorUsernameET.getEditText()).getText().toString().trim())){
//                    EmailorUsernameET.setError("Username required");
//                    Toast.makeText(LoginActivity.this, "Username required", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (TextUtils.isEmpty(Objects.requireNonNull(PasswordET.getEditText()).getText().toString().trim())){
//                    PasswordET.setError("Password required");
//                    Toast.makeText(LoginActivity.this, "Password required", Toast.LENGTH_SHORT).show();
//
//                    return;
//                }
//                Intent intent =new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

    }
        private boolean validateEmail () {

            String emailInput = EmailorUsernameET.getEditText().getText().toString().trim();
            if (emailInput.isEmpty()) {
                EmailorUsernameET.setError("Email is required");
//                Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
                StyleableToast.makeText(this,"Email is required",R.style.Toast).show();
                return false;

            } else {
                EmailorUsernameET.setError(null);
                EmailorUsernameET.setErrorEnabled(false);


                return true;
            }

        }
        private boolean validatePassword () {

            String passwordInput = PasswordET.getEditText().getText().toString().trim();


            if (passwordInput.isEmpty()) {
                PasswordET.setError("Password is required");
                StyleableToast.makeText(this,"Password is required",R.style.Toast).show();

                return false;
            } else {
                PasswordET.setError(null);
                PasswordET.setErrorEnabled(false);

                return true;
            }

        }


        public void loginclick (View view){
            if (!validateEmail() | !validatePassword()) {
                return;

            }
            Intent intent =new Intent(LoginActivity.this,MainActivity.class);

            String email=EmailorUsernameET.getEditText().getText().toString();
            startActivity(intent);
            finish();

        }
    }


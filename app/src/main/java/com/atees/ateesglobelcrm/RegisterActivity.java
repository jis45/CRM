package com.atees.ateesglobelcrm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import io.github.muddz.styleabletoast.StyleableToast;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout EmailorUsernameET, PhoneNumber, Password, confirmPassword;
    private CardView Register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Window window = RegisterActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(RegisterActivity.this, R.color.white));

        EmailorUsernameET = findViewById(R.id.emailorusername);
        PhoneNumber = findViewById(R.id.phonenumber);
        Password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.Cfpassword);


//        Register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (TextUtils.isEmpty(Objects.requireNonNull(EmailorUsernameET.getEditText()).getText().toString().trim())){
//                    Toast.makeText(RegisterActivity.this, "Username required", Toast.LENGTH_SHORT).show();
//                    EmailorUsernameET.setError("Username required");
//                    return;
//                }
//                if (TextUtils.isEmpty(Objects.requireNonNull(PhoneNumber.getEditText()).getText().toString().trim())){
//                    Toast.makeText(RegisterActivity.this, "PhoneNumber required", Toast.LENGTH_SHORT).show();
//                    PhoneNumber.setError("PhoneNumber required");
//                    return;
//                }
//                if (TextUtils.isEmpty(Objects.requireNonNull(Password.getEditText()).getText().toString().trim())){
//                    Toast.makeText(RegisterActivity.this, "Password required", Toast.LENGTH_SHORT).show();
//                    Password.setError("Password required");
//                    return;
//                }
//                if (TextUtils.isEmpty(Objects.requireNonNull(confirmPassword.getEditText()).getText().toString().trim())){
//                    Toast.makeText(RegisterActivity.this, "ConfirmPassword required", Toast.LENGTH_SHORT).show();
//                    confirmPassword.setError("ConfirmPassword required");
//                   return;
//                }
//                Intent intent =new Intent(RegisterActivity.this,MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }

    private boolean validateEmail() {
        String emailInput = EmailorUsernameET.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()) {
            EmailorUsernameET.setError("Email is required");
            StyleableToast.makeText(this, "Email is required", R.style.Toast).show();
            return false;

        } else {
            EmailorUsernameET.setError(null);
            EmailorUsernameET.setErrorEnabled(false);


            return true;
        }

    }

    private boolean validatePhoneNumber() {
        String PhoneNumberInput = PhoneNumber.getEditText().getText().toString().trim();


        if (PhoneNumberInput.isEmpty()) {
            PhoneNumber.setError("PhoneNumber is required");
            StyleableToast.makeText(this, "PhoneNumber is required",  R.style.Toast).show();

            return false;
        }
        if (PhoneNumberInput.length() < 10) {
            PhoneNumber.setError("PhoneNumber must be 10 digits");
            StyleableToast.makeText(this, "PhoneNumber must be 10 digits",  R.style.Toast).show();
            return false;
        } else {
            PhoneNumber.setError(null);
            PhoneNumber.setErrorEnabled(false);

            return true;
        }
    }

    private boolean validatePassword() {

        String PasswordInput = Password.getEditText().getText().toString().trim();
        if (PasswordInput.isEmpty()) {
            Password.setError("Password is required");
            StyleableToast.makeText(this, "Password is required", R.style.Toast).show();
            return false;
        }
        if (PasswordInput.length() < 6) {
            Password.setError("Password must be at least 6 characters");
            StyleableToast.makeText(this, "Password must be at least 6 characters",  R.style.Toast).show();
            return false;

        } else {
            Password.setError(null);
            Password.setErrorEnabled(false);


            return true;
        }

    }

    private boolean validateCFpassword() {

        String CFpassword = confirmPassword.getEditText().getText().toString().trim();
        String PasswordInput = Password.getEditText().getText().toString().trim();
        if (CFpassword.isEmpty()) {
            confirmPassword.setError("ConfirmPassword is required");
            StyleableToast.makeText(this, "ConfirmPassword is required",  R.style.Toast).show();
            return false;
        }
            if  (!PasswordInput.equals(CFpassword)) {
                confirmPassword.setError("Password Would Not be Matched ");
                StyleableToast.makeText(this, "Password Would Not be Matched ",  R.style.Toast).show();
                return false;

            } else {
                confirmPassword.setError(null);
                confirmPassword.setErrorEnabled(false);


                return true;
            }

        }




    public void registerclick(View view) {
        if (!validateEmail()|!validatePhoneNumber()|!validatePassword()|!validateCFpassword()){
            return;
        }
        Intent intent =new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }



}













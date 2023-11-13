package com.atees.ateesglobelcrm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import io.github.muddz.styleabletoast.StyleableToast;

public class ChangePasswordActivity extends AppCompatActivity {
    TextInputLayout newpassword, confirmpassword;
    CardView savepass;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Window window = ChangePasswordActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(ChangePasswordActivity.this, R.color.white));

        newpassword=findViewById(R.id.password);
        confirmpassword=findViewById(R.id.Cfpassword);
        savepass=findViewById(R.id.savepassCV);
        progressBar=findViewById(R.id.progressBAR);



    }
    private boolean validatePassword() {

        String PasswordInput = newpassword.getEditText().getText().toString().trim();
        if (PasswordInput.isEmpty()) {
            newpassword.setError("Password is required");
            StyleableToast.makeText(this,"Password is required",R.style.Toast).show();
            return false;
        }
        if (PasswordInput.length() < 6) {
            newpassword.setError("Password must be at least 6 characters");
            StyleableToast.makeText(this,"Password must be at least 6 characters",R.style.Toast).show();

            return false;

        } else {
            newpassword.setError(null);
            newpassword.setErrorEnabled(false);


            return true;
        }

    }

    private boolean validateCFpassword() {

        String CFpassword = confirmpassword.getEditText().getText().toString().trim();
        String PasswordInput = newpassword.getEditText().getText().toString().trim();
        if (CFpassword.isEmpty()) {
            confirmpassword.setError("ConfirmPassword is required");
            StyleableToast.makeText(this,"ConfirmPassword is required",R.style.Toast).show();
            return false;
        }
        if  (!PasswordInput.equals(CFpassword)) {
            confirmpassword.setError("Password Would Not be Matched ");
            StyleableToast.makeText(this,"Password Would Not be Matched ",R.style.Toast).show();
            return false;

        } else {
            confirmpassword.setError(null);
            confirmpassword.setErrorEnabled(false);
            return true;
        }

    }

    public void savepassclick(View view) {
        if (!validatePassword()|!validateCFpassword()){
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);

            }
        },6000);

    }
}
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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import io.github.muddz.styleabletoast.StyleableToast;

public class ForgotPasswordActivity extends AppCompatActivity {

    TextInputLayout phonenumber;

    CardView sentotp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Window window = ForgotPasswordActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(ForgotPasswordActivity.this, R.color.white));

        phonenumber = findViewById(R.id.phonenumber);
        sentotp = findViewById(R.id.sentotp);

//        sentotp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Intent intent = new Intent(ForgotPasswordActivity.this, OtpActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }

    private boolean validatePhoneNumber() {

        String Phone = phonenumber.getEditText().getText().toString().trim();


            if (Phone.isEmpty()) {
                phonenumber.setError("Please Enter Valid PhoneNUmber");
                StyleableToast.makeText(this, "Please Enter Valid PhoneNumber",R.style.Toast).show();
                return false;
            }
                if (Phone.length() < 10) {
                    phonenumber.setError("PhoneNumber must be 10 digits");
                    StyleableToast.makeText(this, "PhoneNumber must be 10 digits", R.style.Toast).show();
                    return false;



        } else {
            phonenumber.setError(null);
            phonenumber.setErrorEnabled(false);


            return true;
        }

    }

    public void sentotpclick(View view) {
        if (!validatePhoneNumber()){
            return;

        }
        Intent intent = new Intent(ForgotPasswordActivity.this, OtpActivity.class);
                startActivity(intent);
                finish();
    }

}

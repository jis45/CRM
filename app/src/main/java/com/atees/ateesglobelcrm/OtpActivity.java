package com.atees.ateesglobelcrm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

import java.util.Objects;

import io.github.muddz.styleabletoast.StyleableToast;

public class OtpActivity extends AppCompatActivity {

    private PinView otpPin;
    private  CardView  verifyotp;
    private TextView  resentotp;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        Window window = OtpActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(OtpActivity.this, R.color.white));

        otpPin=findViewById(R.id.otp);
        resentotp=findViewById(R.id.resntotp);
        verifyotp=findViewById(R.id.verifysentotp);
        progressBar=findViewById(R.id.progressBAR);


//        verifyotp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (TextUtils.isEmpty(Objects.requireNonNull(otpPin).getText().toString().trim())){
//                    Toast.makeText(OtpActivity.this, "Otp required", Toast.LENGTH_SHORT).show();
//                    otpPin.setError("Otp required");
//                    return;
//                }
//
//                Intent intent =new Intent(OtpActivity.this,ChangePasswordActivity.class);
//                startActivity(intent);
//                finish();
//
//            }
//        });
        resentotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);

                    }
                },6000);
            }
        });



    }

    public void verifyclick(View view) {
        if (!validateotp()){
            return;
        }
        Intent intent =new Intent(OtpActivity.this,ChangePasswordActivity.class);
                startActivity(intent);
                finish();
    }
    private boolean validateotp() {
        String otppin = otpPin.getText().toString().trim();
        if (otppin.isEmpty()) {
            otpPin.setError("Please Enter Valid PhoneNUmber");
            StyleableToast.makeText(this, "Please Enter Valid PhoneNUmber", R.style.Toast).show();
            return false;
        }
        if (otppin.length() < 4) {
            otpPin.setError("PhoneNumber must be 4 digits");
            StyleableToast.makeText(this, "PhoneNumber must be 4 digits", R.style.Toast).show();
            return false;


        } else {
            otpPin.setError(null);
            return true;


        }

    }
}
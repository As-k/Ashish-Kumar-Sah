package com.cioc.report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class OTPActivity extends Activity {
    EditText otp;
    TextInputLayout til_user_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        otp = findViewById(R.id.otp);
        til_user_otp = findViewById(R.id.til_otp);

        otp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String c_otp = s.toString().trim();
                if (c_otp.length() == 4){
                    til_user_otp.setErrorEnabled(false);
                    if (c_otp.equals(SignupActivity.gen_otp)){
                        til_user_otp.setErrorEnabled(false);
                        startActivity(new Intent(OTPActivity.this,MainActivity.class));
                        finish();

                    } else {
                        til_user_otp.setError("Invalid");
                    }
                } else {
                    til_user_otp.setError("Incomplete");
                }
            }
        });

    }
}

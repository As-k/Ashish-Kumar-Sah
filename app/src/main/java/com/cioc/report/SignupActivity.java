package com.cioc.report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class SignupActivity extends Activity {

    private EditText fname, lname, phone,mPasswordView, mConfirmPassword;
    private AutoCompleteTextView mEmail;
    private Button submit;
    public static String gen_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fname = findViewById(R.id.f_name);
        lname = findViewById(R.id.l_name);
        phone = findViewById(R.id.phone);
        mEmail = findViewById(R.id.email);
        mPasswordView= findViewById(R.id.password);
        mConfirmPassword = findViewById(R.id.confirm_password);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSignup();
            }
        });

    }

    public void attemptSignup(){
        String f_name = fname.getText().toString().trim();
        String l_name = lname.getText().toString().trim();
        String mob = phone.getText().toString().trim();
        String email = mEmail.getText().toString();
        String password = mPasswordView.getText().toString();
        String confirm_password = mConfirmPassword.getText().toString();
        if (f_name.isEmpty()){
            fname.setError("Empty");
            fname.requestFocus();
        } else {
            if (l_name.isEmpty()){
                lname.setError("Empty");
                lname.requestFocus();
            } else {
                if (mob.isEmpty()){
                    phone.setError("Empty");
                    phone.requestFocus();
                } else {
                    if (email.isEmpty()){
                        mEmail.setError("Empty");
                        mEmail.requestFocus();
                    } else {
                        if (password.isEmpty()){
                            mPasswordView.setError("Empty");
                            mConfirmPassword.requestFocus();
                        } else {
                            Toast.makeText(this, "Submit", Toast.LENGTH_SHORT).show();
                            long cno = Long.parseLong(mob);
                            gen_otp =  OTP(mob);
                            Toast.makeText(this, "OTP : "+gen_otp, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(this, OTPActivity.class));
                            finish();
                        }
                    }
                }
            }
        }
    }

    public String OTP(String cno)
    {
        int first = cno.charAt(0);
        int last = cno.charAt(5);

        Calendar c = Calendar.getInstance();
        int c_day = c.get(Calendar.DAY_OF_MONTH);
        int c_month = c.get(Calendar.MONTH);

        int c_hr = c.get(Calendar.HOUR);
        int c_sec = c.get(Calendar.SECOND);

        String otp = ""+(last*4*c_day+c_month*c_hr+first*c_sec)+"";

        return otp;
    }

}

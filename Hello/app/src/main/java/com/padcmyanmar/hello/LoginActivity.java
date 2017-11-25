package com.padcmyanmar.hello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by E5 on 11/5/2017.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String CORRECT_EMAIL="14heinhtetaung@gmail.com";
    private static final String CORRECT_PASSWORD="ABCDEFG";//constant attribute
    private Button btnlogin;
    private EditText etEmailOrPassword;
    private EditText etPassword;
    private TextView btnForgetPassword;
    private TextView btnNewSellerRegister;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         btnlogin=findViewById(R.id.btn_login);
         etPassword=findViewById(R.id.et_password);
         btnForgetPassword=findViewById(R.id.btn_forget_password);
         btnNewSellerRegister=findViewById(R.id.btn_newseller_register);
        etEmailOrPassword=findViewById(R.id.et_email_or_phone);
        btnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"\"Forget Password\" is coming soon.",Snackbar.LENGTH_INDEFINITE ).show();
            }
        });


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailOrPhone=etEmailOrPassword.getText().toString();
                String password=etPassword.getText().toString();
                if(TextUtils.isEmpty(emailOrPhone)){
                    etEmailOrPassword.setError("Email or Phone cannot be empty.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    etPassword.setError("Password cannot be empty.");
                    return;
                }
                if(TextUtils.equals(emailOrPhone,CORRECT_EMAIL) && TextUtils.equals(password,CORRECT_PASSWORD)){
                        Intent intent=Hello.newIntent(getApplicationContext());
                        startActivity(intent);
                    //Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                }else{
                    Snackbar.make(v,"Incorrect Email or Password. Please try again.",Snackbar.LENGTH_INDEFINITE).show();
                }

                //Snackbar.make(v,"Logging in",Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });
        btnNewSellerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=Register.newIntent(getApplicationContext());
                startActivity(intent);

            }
        });
    }
}

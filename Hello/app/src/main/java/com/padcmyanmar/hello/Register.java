package com.padcmyanmar.hello;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Register extends AppCompatActivity {
public static Intent newIntent(Context context){
    Intent intent=new Intent(context,Register.class);
    return intent;
}   private TextView btnToLogin;
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPass;
    private EditText etConfirmPassword;
    private EditText etAddress;
    private CheckBox chkAtHome;
    private RadioButton rdMale;
    private RadioButton rdFemale;
    private RadioGroup rgGender;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnToLogin=findViewById(R.id.btn_to_login);
        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        btnToLogin=findViewById(R.id.btn_to_login);
        etName=findViewById(R.id.et_name);
        etPhone=findViewById(R.id.et_phone);
        etEmail=findViewById(R.id.et_email);
        etPass=findViewById(R.id.et_pass);
        etConfirmPassword=findViewById(R.id.et_confirm_password);
        etAddress=findViewById(R.id.et_address);
        chkAtHome=findViewById(R.id.chk_at_home);
        rdMale=findViewById(R.id.rd_male);
        rdFemale=findViewById(R.id.rd_female);
        rgGender=findViewById(R.id.rg_gender);
        btnRegister=findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString();
                String phone=etPhone.getText().toString();
                String email=etEmail.getText().toString();
                String pass=etPass.getText().toString();
                String confirm=etConfirmPassword.getText().toString();
                String address=etAddress.getText().toString();

                if(TextUtils.isEmpty(name)){
                    etName.setError("Name cannot be empty!");
                    return;
                }
                if(TextUtils.isEmpty(phone)){
                    etPhone.setError("Phone cannot be empty!");
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    etEmail.setError("Email cannot be empty!");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    etPass.setError("Password cannot be empty!");
                    return;
                }
                if(TextUtils.isEmpty(confirm)){
                    etConfirmPassword.setError("Confirm password cannot be empty!");
                    return;
                }
                if(TextUtils.isEmpty(address)){
                    etAddress.setError("Address password cannot be empty!");
                    return;
                }
              if(TextUtils.equals(pass,confirm)){

              }else{
                  Snackbar.make(v,"Password and Confirm must be same!",Snackbar.LENGTH_INDEFINITE).show();
                  return;
              }
              if(rdMale.isChecked() || rdFemale.isChecked()){
                  Intent intent=new Intent(Register.this,LoginActivity.class);
                  startActivity(intent);
              }else{
                  Snackbar.make(v,"Please check the gender!",Snackbar.LENGTH_INDEFINITE).show();

              }

            }
        });

    }
}

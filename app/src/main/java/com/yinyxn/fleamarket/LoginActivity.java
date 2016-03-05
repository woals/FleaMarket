package com.yinyxn.fleamarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yinyxn.fleamarket.service.UserService;

public class LoginActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextPassword;
    Button buttonLogin;
    Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {

        editTextName = (EditText) findViewById(R.id.editText_account);
        editTextPassword = (EditText) findViewById(R.id.editText_accountPassword);
        buttonLogin = (Button) findViewById(R.id.button_login);
        buttonRegister = (Button) findViewById(R.id.button_register);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String pass = editTextPassword.getText().toString().trim();
                UserService userService = new UserService(LoginActivity.this);
                boolean flag = userService.login(name,pass);
                if(flag){
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MyActivity.class));
                    App.KEY = name;
                    App.flag = true;
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}

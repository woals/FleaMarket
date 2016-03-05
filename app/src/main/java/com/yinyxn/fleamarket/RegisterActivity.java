package com.yinyxn.fleamarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yinyxn.fleamarket.domain.User;
import com.yinyxn.fleamarket.service.UserService;

import java.util.Date;

public class RegisterActivity extends AppCompatActivity {
    EditText rname;
    EditText rpass;
    EditText rphone;
    EditText rage;
    RadioGroup sex;
    Button button_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rname = (EditText) findViewById(R.id.rName);
        rpass = (EditText) findViewById(R.id.rPass);
        rphone = (EditText) findViewById(R.id.rPhone);
        rage = (EditText) findViewById(R.id.rAge);
        sex = (RadioGroup) findViewById(R.id.radioGroup);
        button_register = (Button) findViewById(R.id.button_register);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = rname.getText().toString().trim();
                String pass = rpass.getText().toString().trim();
                String phone = rphone.getText().toString().trim();
                String age = rage.getText().toString().trim();
                String sexstr = ((RadioButton) RegisterActivity.this.findViewById(sex.getCheckedRadioButtonId())).getText().toString();
                long time = new Date().getTime();
                String t = new Date().toLocaleString();
                Log.d("TAG",t);
                Log.d("TAG", name + "_" + pass + "_" + phone + "_" + age + "_" + sexstr + "_" + time);
                UserService uService = new UserService(RegisterActivity.this);
                User user = new User();
                user.setUsername(name);
                user.setPassword(pass);
                user.setPhone(phone);
                user.setAge(age);
                user.setSex(sexstr);
                user.setTime(time);
                int flag = uService.register(user);
                if (name.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "姓名不能为空", Toast.LENGTH_SHORT).show();
                }else if (pass.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else if (phone.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }else if (flag == 3) {
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    finish();
                } else if (flag == 1) {
                    Toast.makeText(RegisterActivity.this, "注册失败，用户已注册", Toast.LENGTH_LONG).show();
                } else if (flag == 2) {
                    Toast.makeText(RegisterActivity.this, "注册失败，手机号已注册", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "未知错误", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
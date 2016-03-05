package com.yinyxn.fleamarket;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
    }

    public void more(View view) {
        switch (view.getId()){
            case R.id.button_aboutUs:
                aboutUs();
                break;
            case R.id.button_exit:
                exit();
                break;
            case R.id.button_callback:
                callback();
                break;
            case R.id.button_change:
                changeCity();
                break;
            case R.id.button_clear:
                clear();
                break;
            case R.id.button_register:
                register();
                break;
            case R.id.button_manager:
                manager();
                break;


        }
    }

    private void manager() {
        // 管理员
        View v = getLayoutInflater().inflate(R.layout.dialog_demo, null);
        final EditText editTextNet = (EditText) v.findViewById(R.id.editText);
        final EditText editTextPassword = (EditText) v.findViewById(R.id.editText_password);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("跳蚤管理")
                .setView(v)
                .setCancelable(false)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String name = editTextNet.getText().toString().trim();
                        String password = editTextPassword.getText().toString().trim();
                        if (name.equals("12") && password.equals("21")) {
                            startActivity(new Intent(MoreActivity.this,ManagerActivity.class));
                        } else {
                            Toast.makeText(MoreActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("取消", null)
                .create();
        dialog.show();
    }

    private void register() {
        // 注册
        startActivity(new Intent(MoreActivity.this,RegisterActivity.class));

    }

    private void clear() {
        // 清除缓存
        Toast.makeText(MoreActivity.this, "这个功能还在开发中", Toast.LENGTH_SHORT).show();
    }

    private void changeCity() {
        // 切换城市
        Toast.makeText(MoreActivity.this, "这个功能还在开发中", Toast.LENGTH_SHORT).show();
    }

    private void callback() {
        // 用户反馈
        Toast.makeText(MoreActivity.this, "这个功能还在开发中", Toast.LENGTH_SHORT).show();
    }

    private void exit() {
        // 退出程序
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("确定退出吗？")
                .setCancelable(false)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MoreActivity.this, "这个功能还在开发中", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", null)
                .create();
        dialog.show();
    }

    private void aboutUs() {
        // 关于我们
        View v = getLayoutInflater().inflate(R.layout.dialog_demo_aboutus, null);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("关于我们")
                .setView(v)
                .setCancelable(false)
                .setPositiveButton("确定", null)
                .create();
        dialog.show();
    }
}

package com.yinyxn.fleamarket.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.yinyxn.fleamarket.domain.User;


public class UserService {
    private DatabaseHelper dbHelper;
    public UserService(Context context){
        dbHelper=new DatabaseHelper(context);
    }

    //登录用
    public boolean login(String username,String password){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="select * from fleaMarket where username=? and password=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
    //注册用
    public int register(User user){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sqlName="select * from fleaMarket where username=?";
        Cursor cursorName=sdb.rawQuery(sqlName, new String[]{user.getUsername()});
        String sqlPhone="select * from fleaMarket where phone=?";
        Cursor cursorPhone=sdb.rawQuery(sqlPhone, new String[]{user.getPhone()});
        if(cursorName.moveToFirst()==true){
            cursorName.close();
            Log.d("TAG", "用户已注册");
            return 1;
        } else if(cursorPhone.moveToFirst()==true){
            cursorPhone.close();
            Log.d("TAG", "手机号码已注册");
            return 2;
        } else {
            String sql_="insert into fleaMarket(username,password,phone,age,sex,time) values(?,?,?,?,?,?)";
            Object obj[]={user.getUsername(),user.getPassword(),user.getPhone(),user.getAge(),user.getSex(),user.getTime()};
            sdb.execSQL(sql_, obj);
            return 3;
        }
    }
}

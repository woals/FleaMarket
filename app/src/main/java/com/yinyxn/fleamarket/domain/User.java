package com.yinyxn.fleamarket.domain;

import android.provider.BaseColumns;

import java.util.Date;


public class User implements BaseColumns {

    public static final String TABLE = "fleaMarket";
    public static final String _USERNAME = "username";
    public static final String _PASSWORD = "password";
    public static final String _PHONE = "phone";
    public static final String _AGE = "age";
    public static final String _SEX = "sex";
    public static final String _TIME = "time";
    public static final String[] ALL = {_ID, _USERNAME, _PASSWORD,_PHONE,_AGE,_SEX,_TIME};
    public static final String SQL_CREATE_TABLE = String.format(
            "create table %s(_id integer primary key autoincrement,%s text,%s text,%s text,%s text,%s text,%s integer)",//%s占位符，占的是字段名(TABLE,_TIME等)
            TABLE,
            _USERNAME,
            _PASSWORD,
            _PHONE,
            _AGE,
            _SEX,
            _TIME
    );

    public static final String SQL_DROP_TABLE = String.format(
            "drop table if exists %s",//表存在的情况下删除TABL(%s)所指定的表
            TABLE);

    private long id;
    private String username;
    private String password;
    private String phone;
    private String age;
    private String sex;
    private long time;


    public User() {
        super();
    }

    public User(String username, String password, String phone, String age, String sex) {
        super();
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
        time = new Date().getTime();//创建消息的当前时间
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", time=" + time +
                '}';
    }
}

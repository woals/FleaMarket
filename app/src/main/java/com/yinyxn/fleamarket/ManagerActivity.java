package com.yinyxn.fleamarket;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.yinyxn.fleamarket.domain.Product;
import com.yinyxn.fleamarket.domain.User;
import com.yinyxn.fleamarket.service.DatabaseHelper;

public class ManagerActivity extends AppCompatActivity implements ManagerAdapter.Callback, ManagerAdapter2.Callback {

    ListView listView2;
    ListView listView3;
    ManagerAdapter adapter;
    ManagerAdapter2 adapter2;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        listView2 = (ListView) findViewById(R.id.listView2);
        listView3 = (ListView) findViewById(R.id.listView3);

        adapter = new ManagerAdapter(this,cursor);
        adapter2 = new ManagerAdapter2(this,cursor);
        adapter.setCallback(this);
        adapter2.setCallback(this);
        listView2.setAdapter(adapter);
        listView3.setAdapter(adapter2);

    }

    @Override
    public void remove(long id) {
        DatabaseHelper.getDb(this).delete(
                User.TABLE,
                "_id = ?",
                new String[]{String.valueOf(id)});

        cursor.requery();//重新查询
    }

    public void muser(View view) {
        listView2.setVisibility(View.VISIBLE);
        listView3.setVisibility(View.INVISIBLE);
        cursor = DatabaseHelper.getDb(this)
                .query(
                        User.TABLE,
                        User.ALL,
                        "_id > ?",
                        new String[]{"0"},
                        null,
                        null,
                        "_id desc");


        //遍历,控制台打印出所有数据
        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(User._ID));
            String username = cursor.getString(1);
            String password = cursor.getString(2);
            String phone = cursor.getString(3);
            String age = cursor.getString(4);
            String sex = cursor.getString(5);
            String time = cursor.getString(6);

            Log.d("tag", "ID："+id);
            Log.d("tag", "姓名："+username);
            Log.d("tag", "密码："+password);
            Log.d("tag", "电话："+phone);
            Log.d("tag", "年龄："+age);
            Log.d("tag", "性别："+sex);
            Log.d("tag", "时间："+time);
        }
        adapter.swapCursor(cursor);
    }

    public void mproduct(View view) {
        listView3.setVisibility(View.VISIBLE);
        listView2.setVisibility(View.INVISIBLE);
        cursor = DatabaseHelper.getDb(this)
                .query(
                        Product.TABLE,
                        Product.ALL,
                        "_id > ?",
                        new String[]{"0"},
                        null,
                        null,
                        "_id desc");


        //遍历,控制台打印出所有数据
        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(Product._ID));
            String productName = cursor.getString(1);
            String productClassify = cursor.getString(2);
            String productorName = cursor.getString(3);
            String productorPhone = cursor.getString(4);
            String productorDescribe = cursor.getString(5);
            String productPrice1 = cursor.getString(6);
            String productPrice = cursor.getString(7);
            Log.d("tag", "key："+productPrice1);
            Log.d("tag", "价格："+productPrice);
        }
        adapter2.swapCursor(cursor);
    }

    @Override
    public void removeP(long id) {
        DatabaseHelper.getDb(this).delete(
                Product.TABLE,
                "_id = ?",
                new String[]{String.valueOf(id)});

        cursor.requery();//重新查询
    }
}

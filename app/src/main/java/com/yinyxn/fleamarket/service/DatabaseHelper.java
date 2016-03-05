package com.yinyxn.fleamarket.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.yinyxn.fleamarket.domain.Product;
import com.yinyxn.fleamarket.domain.ProductCollection;
import com.yinyxn.fleamarket.domain.User;



public class DatabaseHelper extends SQLiteOpenHelper {

    static String name = "fleaMarket.db";
    static int dbVersion = 1;
    private static final String TAG = "DatabaseHelper";
    private SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }

    private static DatabaseHelper instance = null;

    /**
     * 获得数据库
     *
     * @param
     * @return
     */
    public static synchronized SQLiteDatabase getDb(Context context) {
        if (null == instance) {
            instance = new DatabaseHelper(context);
        }
        return instance.getWritableDatabase();
    }

    /**
     * 创建表
     * 初始化数据
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");

        db.execSQL(User.SQL_CREATE_TABLE);
        db.execSQL(Product.SQL_CREATE_TABLE);
        db.execSQL(ProductCollection.SQL_CREATE_TABLE);
    }

    /**
     * 更新表结构（不是数据）
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade");

        db.execSQL(User.SQL_DROP_TABLE);//删除表
        db.execSQL(Product.SQL_DROP_TABLE);//删除表
        db.execSQL(ProductCollection.SQL_DROP_TABLE);//删除表
        onCreate(db);//重建表
    }
}

package com.yinyxn.fleamarket.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yinyxn.fleamarket.domain.Product;


public class ProductService {
    private DatabaseHelper dbHelper;

    public ProductService(Context context) {
        dbHelper = new DatabaseHelper(context);
    }
    // 修改用
    public boolean modify(Product product,long id) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "update Product set productName = ?,productClassify = ?,productorName = ?,productorPhone = ?,productorDescribe = ?,productprice = ? where  _id = ?";
        Object obj[] = {product.getProductName(), product.getProductClassify(), product.getProductorName(), product.getProductorPhone(), product.getProductorDescribe(),product.getProductprice(),product.getId()};
        sdb.execSQL(sql, obj);
        return true;
    }

    // 发布用
    public boolean release(Product product) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "insert into Product(productName,productClassify,productorName,productorPhone,productorDescribe,productkey,productprice,producttime,productzt) values(?,?,?,?,?,?,?,?,?)";
        Object obj[] = {product.getProductName(), product.getProductClassify(), product.getProductorName(), product.getProductorPhone(), product.getProductorDescribe(),product.getProductkey(),product.getProductprice(),product.getProducttime(),product.getProductzt()};
        sdb.execSQL(sql, obj);
        return true;
    }

    public boolean classify(String productClassify){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="select * from Product where productClassify=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{productClassify});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
}

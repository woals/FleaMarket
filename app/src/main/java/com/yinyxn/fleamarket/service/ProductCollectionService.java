package com.yinyxn.fleamarket.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yinyxn.fleamarket.domain.ProductCollection;


public class ProductCollectionService {
    private DatabaseHelper dbHelper;

    public ProductCollectionService(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // 收藏用
    public boolean collection(ProductCollection productCollection) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "insert into ProductCollection(productName,productorName,productorPhone,productorDescribe,productprice,productkey) values(?,?,?,?,?,?)";
        Object obj[] = {productCollection.getProductName(), productCollection.getProductorName(), productCollection.getProductorPhone(), productCollection.getProductorDescribe(),productCollection.getProductprice(),productCollection.getProductkey()};
        sdb.execSQL(sql, obj);
        return true;
    }
}

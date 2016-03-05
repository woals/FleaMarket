package com.yinyxn.fleamarket.domain;

import android.provider.BaseColumns;

/**
 * Created by yinyxn on 2016/2/20.
 */
public class Product implements BaseColumns {

    public static final String TABLE = "Product";
    public static final String _PRODUCTNAME = "productName";
    public static final String _PRODUCTCLASSIFY = "productClassify";
    public static final String _PRODUCTORNAME = "productorName";
    public static final String _PRODUCTPHONE = "productorPhone";
    public static final String _PRODUCTORDESCRIBE = "productorDescribe";
    public static final String _PRODUCTKEY = "productkey";
    public static final String _PRODUCTPRICE = "productprice";
    public static final String _PRODUCTTIME = "producttime";
    public static final String _PRODUCTZT = "productzt";
    public static final String[] ALL = {_ID, _PRODUCTNAME, _PRODUCTCLASSIFY,_PRODUCTORNAME,_PRODUCTPHONE,_PRODUCTORDESCRIBE,_PRODUCTKEY,_PRODUCTPRICE,_PRODUCTTIME,_PRODUCTZT};
    public static final String SQL_CREATE_TABLE = String.format(
            "create table %s(_id integer primary key autoincrement,%s text,%s text,%s text,%s text,%s text,%s text,%s text,%s integer,%s text)",//%s占位符，占的是字段名(TABLE,_TIME等)
            TABLE,
            _PRODUCTNAME,
            _PRODUCTCLASSIFY,
            _PRODUCTORNAME,
            _PRODUCTPHONE,
            _PRODUCTORDESCRIBE,
            _PRODUCTKEY,
            _PRODUCTPRICE,
            _PRODUCTTIME,
            _PRODUCTZT
    );

    public static final String SQL_DROP_TABLE = String.format(
            "drop table if exists %s",//表存在的情况下删除TABL(%s)所指定的表
            TABLE);

    private long id;
    private String productName;
    private String productClassify;
    private String productorName;
    private String productorPhone;
    private String productorDescribe;
    private String productkey;
    private String productprice;
    private long producttime;
    private String productzt;

    public Product() {
    }

    public Product(String productName, String productClassify, String productorName, String productorPhone, String productorDescribe, String productkey, String productprice, long producttime, String productzt) {
        this.productName = productName;
        this.productClassify = productClassify;
        this.productorName = productorName;
        this.productorPhone = productorPhone;
        this.productorDescribe = productorDescribe;
        this.productkey = productkey;
        this.productprice = productprice;
        this.producttime = producttime;
        this.productzt = productzt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductClassify() {
        return productClassify;
    }

    public void setProductClassify(String productClassify) {
        this.productClassify = productClassify;
    }

    public String getProductorName() {
        return productorName;
    }

    public void setProductorName(String productorName) {
        this.productorName = productorName;
    }

    public String getProductorPhone() {
        return productorPhone;
    }

    public void setProductorPhone(String productorPhone) {
        this.productorPhone = productorPhone;
    }

    public String getProductorDescribe() {
        return productorDescribe;
    }

    public void setProductorDescribe(String productorDescribe) {
        this.productorDescribe = productorDescribe;
    }

    public String getProductkey() {
        return productkey;
    }

    public void setProductkey(String productkey) {
        this.productkey = productkey;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public long getProducttime() {
        return producttime;
    }

    public void setProducttime(long producttime) {
        this.producttime = producttime;
    }

    public String getProductzt() {
        return productzt;
    }

    public void setProductzt(String productzt) {
        this.productzt = productzt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productClassify='" + productClassify + '\'' +
                ", productorName='" + productorName + '\'' +
                ", productorPhone='" + productorPhone + '\'' +
                ", productorDescribe='" + productorDescribe + '\'' +
                ", productkey='" + productkey + '\'' +
                ", productprice='" + productprice + '\'' +
                ", producttime=" + producttime +
                ", productzt='" + productzt + '\'' +
                '}';
    }
}

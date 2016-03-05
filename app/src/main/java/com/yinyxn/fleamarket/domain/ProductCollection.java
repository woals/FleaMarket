package com.yinyxn.fleamarket.domain;

import android.provider.BaseColumns;

/**
 * Created by yinyxn on 2016/2/20.
 */
public class ProductCollection implements BaseColumns {

    public static final String TABLE = "ProductCollection";
    public static final String _PRODUCTNAME = "productName";
    public static final String _PRODUCTORNAME = "productorName";
    public static final String _PRODUCTPHONE = "productorPhone";
    public static final String _PRODUCTORDESCRIBE = "productorDescribe";
    public static final String _PRODUCTKEY = "productkey";
    public static final String _PRODUCTPRICE = "productprice";
    public static final String[] ALL = {_ID, _PRODUCTNAME,_PRODUCTORNAME,_PRODUCTPHONE,_PRODUCTORDESCRIBE,_PRODUCTPRICE,_PRODUCTKEY};
    public static final String SQL_CREATE_TABLE = String.format(
            "create table %s(_id integer primary key autoincrement,%s text,%s text,%s text,%s text,%s text,%s text)",//%s占位符，占的是字段名(TABLE,_TIME等)
            TABLE,
            _PRODUCTNAME,
            _PRODUCTORNAME,
            _PRODUCTPHONE,
            _PRODUCTORDESCRIBE,
            _PRODUCTKEY,
            _PRODUCTPRICE
    );

    public static final String SQL_DROP_TABLE = String.format(
            "drop table if exists %s",//表存在的情况下删除TABL(%s)所指定的表
            TABLE);

    private long id;
    private String productName;
    private String productorName;
    private String productorPhone;
    private String productorDescribe;
    private String productkey;
    private String productprice;

    public ProductCollection() {
    }

    public ProductCollection(String productName, String productorName, String productorPhone, String productorDescribe, String productkey, String productprice) {
        this.productName = productName;
        this.productorName = productorName;
        this.productorPhone = productorPhone;
        this.productorDescribe = productorDescribe;
        this.productkey = productkey;
        this.productprice = productprice;
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


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productorName='" + productorName + '\'' +
                ", productorPhone='" + productorPhone + '\'' +
                ", productorDescribe='" + productorDescribe + '\'' +
                ", productkey='" + productkey + '\'' +
                ", productprice='" + productprice + '\'' +
                '}';
    }
}

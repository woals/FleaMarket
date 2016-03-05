package com.yinyxn.fleamarket;

import android.app.Application;

public class App extends Application{

    public static final String EXTRA_NAME = "name";// 产品名
    public static final String EXTRA_NAME2 = "name2";// 卖家电话
    public static final String EXTRA_NAME3 = "name3";// 产品描述
    public static final String EXTRA_NAME5 = "name5";
    public static final String EXTRA_NAME1 = "name1";// 卖家名
    public static final String EXTRA_NAME4 = "name4";// 产品价格
    public static final String EXTRA_1 = "1";
    public static final String EXTRA_2 = "2";
    public static final String EXTRA_3 = "3";
    public static final String EXTRA_4 = "4";
    public static final String EXTRA_MYRELEASEFragment1 = "productName";
    public static final String EXTRA_MYRELEASEFragment2 = "productClassify";
    public static final String EXTRA_MYRELEASEFragment3 = "productorName";
    public static final String EXTRA_MYRELEASEFragment4 = "productorPhone";
    public static final String EXTRA_MYRELEASEFragment5 = "productDescribe";
    public static final String EXTRA_MYRELEASEFragment6 = "productPrice";
    public static final long EXTRA_MYRELEASEFragment7 = 0;
    public static String KEY = "";


    public static boolean flag;
    public static boolean modify;
    @Override
    public void onCreate() {
        super.onCreate();
        flag = false;
    }

}

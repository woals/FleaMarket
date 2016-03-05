package com.yinyxn.fleamarket.domain;

/**
 * Created by yinyxn on 2016/3/4.
 */
public class P {
    String title;
    String price;

    public P(String price, String title) {
        this.price = price;
        this.title = title;
    }

    public P() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "P{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

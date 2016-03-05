package com.yinyxn.fleamarket.fragment;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yinyxn.fleamarket.App;
import com.yinyxn.fleamarket.R;
import com.yinyxn.fleamarket.domain.ProductCollection;
import com.yinyxn.fleamarket.service.DatabaseHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCollectionFragment extends Fragment implements MyCollectionAdapter.Callback{


    ListView listView;
    ArrayList<String> data;
    ArrayList<String> data1;
    ArrayList<String> data2;
    ArrayList<String> data3;
    ArrayList<String> data4;
    Cursor cursor;
    MyCollectionAdapter adapter;

    public MyCollectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collection, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.listView6);
        adapter = new MyCollectionAdapter(getContext(),cursor);
        adapter.setCallback(this);
        listView.setAdapter(adapter);

        data = new ArrayList<String>();
        data1 = new ArrayList<String>();
        data2 = new ArrayList<String>();
        data3 = new ArrayList<String>();
        data4 = new ArrayList<String>();
        cursor = DatabaseHelper.getDb(getContext())
                .query(
                        ProductCollection.TABLE,
                        ProductCollection.ALL,
                        "productkey = ?",
                        new String[]{App.KEY},
                        null,
                        null,
                        null);

        //遍历,控制台打印出所有数据
        while (cursor.moveToNext()) {
            String productName = cursor.getString(1);
            String productorName = cursor.getString(3);
            String productorPhone = cursor.getString(4);
            String productorDescribe = cursor.getString(5);
            String productorPrice = cursor.getString(6);

            data.add(productName);
            data1.add(productorName);
            data2.add(productorPhone);
            data3.add(productorDescribe);
            data4.add(productorPrice);
        }
        adapter.swapCursor(cursor);
    }

    @Override
    public void remove(long id) {
        DatabaseHelper.getDb(getContext()).delete(
                ProductCollection.TABLE,
                "_id = ?",
                new String[]{String.valueOf(id)});

        cursor.requery();//重新查询
    }
}

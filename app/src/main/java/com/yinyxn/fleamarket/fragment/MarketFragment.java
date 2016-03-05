package com.yinyxn.fleamarket.fragment;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.yinyxn.fleamarket.App;
import com.yinyxn.fleamarket.BuyActivity;
import com.yinyxn.fleamarket.R;
import com.yinyxn.fleamarket.domain.Product;
import com.yinyxn.fleamarket.service.DatabaseHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarketFragment extends Fragment {

    GridView gridView;
    MarketAdapter adapter;
    ArrayList<String> data;
    ArrayList<String> data1;
    ArrayList<String> data2;
    ArrayList<String> data3;
    ArrayList<String> data4;
    Cursor cursor;


    public MarketFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_market, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        gridView = (GridView) view.findViewById(R.id.gridView2);
        data = new ArrayList<>();
        data1 = new ArrayList<>();
        data2 = new ArrayList<>();
        data3 = new ArrayList<>();
        data4 = new ArrayList<>();
        cursor = DatabaseHelper.getDb(getContext())

                .query(
                        Product.TABLE,
                        Product.ALL,
                        "_id > ?",
                        new String[]{"0"},
                        null,
                        null,
                        null);

        //遍历,控制台打印出所有数据
        while (cursor.moveToNext()) {
            String productName = cursor.getString(1);
            String productorName = cursor.getString(3);
            String productorPhone = cursor.getString(4);
            String productorDescribe = cursor.getString(5);
            String productorPrice1 = cursor.getString(6);
            String productPrice = cursor.getString(7);

            data.add(productName);
            data1.add(productorName);
            data2.add(productorPhone);
            data3.add(productorDescribe);
            data4.add(productPrice);
        }
        adapter = new MarketAdapter(getContext(),data);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), BuyActivity.class);
                intent.putExtra(App.EXTRA_NAME5, data.get(position));
                intent.putExtra(App.EXTRA_NAME1, data1.get(position));
                intent.putExtra(App.EXTRA_NAME2, data2.get(position));
                intent.putExtra(App.EXTRA_NAME3, data3.get(position));
                intent.putExtra(App.EXTRA_NAME4, data4.get(position));
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG", "onStart");
        if (App.modify){
            initView(getView());
        }
    }
}
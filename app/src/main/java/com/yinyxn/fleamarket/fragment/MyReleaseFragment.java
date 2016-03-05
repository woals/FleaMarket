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
import com.yinyxn.fleamarket.ModifyActivity;
import com.yinyxn.fleamarket.R;
import com.yinyxn.fleamarket.domain.Product;
import com.yinyxn.fleamarket.service.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyReleaseFragment extends Fragment {

    Cursor cursor;
    GridView gridView;
    MarketAdapter adapter;
    ArrayList<String> data;
    ArrayList<String> data1;
    ArrayList<String> data2;
    ArrayList<String> data3;
    ArrayList<String> data4;
    ArrayList<String> data6;
    List data7;

    public MyReleaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_my_release, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        data = new ArrayList<>();
        data7 = new ArrayList<>();
        data1 = new ArrayList<>();
        data2 = new ArrayList<>();
        data3 = new ArrayList<>();
        data4 = new ArrayList<>();
        data6 = new ArrayList<>();
        gridView = (GridView) view.findViewById(R.id.gridView3);
        cursor = DatabaseHelper.getDb(getContext())
                .query(
                        Product.TABLE,
                        Product.ALL,
                        "productkey = ?",
                        new String[]{App.KEY},
                        null,
                        null,
                        null);

        //遍历,控制台打印出所有数据
        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(Product._ID));
            String productName = cursor.getString(1);
            String productClassify = cursor.getString(2);
            String productorName = cursor.getString(3);
            String productorPhone = cursor.getString(4);
            String productorDescribe = cursor.getString(5);
            String productorKey = cursor.getString(6);
            String productorPrice = cursor.getString(7);

            data7.add(id);
            data.add(productName);
            data1.add(productClassify);
            data2.add(productorName);
            data3.add(productorPhone);
            data4.add(productorDescribe);
            data6.add(productorPrice);
        }

        adapter = new MarketAdapter(getContext(),data);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), ModifyActivity.class);
                intent.putExtra(String.valueOf(App.EXTRA_MYRELEASEFragment7), (Long) data7.get(position));
                intent.putExtra(App.EXTRA_MYRELEASEFragment1, data.get(position));
                intent.putExtra(App.EXTRA_MYRELEASEFragment2, data1.get(position));
                intent.putExtra(App.EXTRA_MYRELEASEFragment3, data2.get(position));
                intent.putExtra(App.EXTRA_MYRELEASEFragment4, data3.get(position));
                intent.putExtra(App.EXTRA_MYRELEASEFragment5, data4.get(position));
                intent.putExtra(App.EXTRA_MYRELEASEFragment6, data6.get(position));
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

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG", "onStop");
    }
}

package com.yinyxn.fleamarket.fragment;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.yinyxn.fleamarket.App;
import com.yinyxn.fleamarket.R;
import com.yinyxn.fleamarket.domain.P;
import com.yinyxn.fleamarket.domain.Product;
import com.yinyxn.fleamarket.service.DatabaseHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends Fragment {

    GridView gridView;
    ClassifyFragment fragment;
    ClassifyAdapter adapter;
    Classify2Adapter adapter2;
    ArrayList<String> data;
    ArrayList<String> data1;
    ArrayList<String> data2;
    ArrayList<String> data3;
    ArrayList<String> data4;
    Cursor cursor;


    public ClassifyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_classify, container, false);
        initView(view);
        return view;
    }

    public void initView(View view) {
        gridView = (GridView) view.findViewById(R.id.gridView);
        data = new ArrayList<>();
        data.add("家具");
        data.add("学习");
        data.add("数码");
        data.add("健身");
        data.add("穿戴");
        data.add("其他");
        adapter = new ClassifyAdapter(getContext(), data);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new GridViewListener());
    }

    public class GridViewListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            P p = new P();
            String classify = data.get(position);
            data = new ArrayList<String>();
            data1 = new ArrayList<String>();
            data2 = new ArrayList<String>();
            data3 = new ArrayList<String>();
            data4 = new ArrayList<String>();
            cursor = DatabaseHelper.getDb(getContext())
                    .query(
                            Product.TABLE,
                            Product.ALL,
                            "productClassify = ?",
                            new String[]{classify},
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
                String productorPrice = cursor.getString(7);

                data.add(productName);
                p.setTitle(productName);
                data1.add(productorName);
                data2.add(productorPhone);
                data3.add(productorDescribe);
                data4.add(productorPrice);
            }
            adapter2 = new Classify2Adapter(getContext(), data);

            Classify2Fragment classify2Fragment = new Classify2Fragment();
            Bundle Bundle = new Bundle();
            // 数码类
            Bundle.putStringArrayList(App.EXTRA_NAME, data);// 手机 电脑
            Bundle.putStringArrayList(App.EXTRA_NAME1, data1);//
            Bundle.putStringArrayList(App.EXTRA_NAME2, data2);
            Bundle.putStringArrayList(App.EXTRA_NAME3, data3);
            Bundle.putStringArrayList(App.EXTRA_NAME4, data4);
            classify2Fragment.setArguments(Bundle);

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.content, classify2Fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (App.modify){
            initView(getView());
        }
    }
}
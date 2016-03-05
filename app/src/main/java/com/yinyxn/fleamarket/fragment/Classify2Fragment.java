package com.yinyxn.fleamarket.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yinyxn.fleamarket.App;
import com.yinyxn.fleamarket.BuyActivity;
import com.yinyxn.fleamarket.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Classify2Fragment extends Fragment {


    ArrayList<String> data = new ArrayList<>();
    ListView listView;
    Classify2Adapter adapter;

    public Classify2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_classify2, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.listView4);
        //获取列表传来的参数
        Bundle bundle = getArguments();
        ArrayList<String> data = bundle.getStringArrayList(App.EXTRA_NAME);
        adapter = new Classify2Adapter(getContext(),data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ListViewListener());
    }
    private class ListViewListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            initView(getView());
            Intent intent = new Intent(getContext(), BuyActivity.class);
            Bundle bundle = getArguments();
            ArrayList<String> data1 = bundle.getStringArrayList(App.EXTRA_NAME1);
            ArrayList<String> data2 = bundle.getStringArrayList(App.EXTRA_NAME2);
            ArrayList<String> data3 = bundle.getStringArrayList(App.EXTRA_NAME3);
            ArrayList<String> data4 = bundle.getStringArrayList(App.EXTRA_NAME4);
            intent.putExtra(App.EXTRA_NAME1, data1.get(position));
            intent.putExtra(App.EXTRA_NAME2, data2.get(position));
            intent.putExtra(App.EXTRA_NAME3, data3.get(position));
            intent.putExtra(App.EXTRA_NAME4, data4.get(position));
            startActivity(intent);
        }
    }
}

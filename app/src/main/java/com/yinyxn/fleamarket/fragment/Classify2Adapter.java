package com.yinyxn.fleamarket.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yinyxn.fleamarket.R;

import java.util.ArrayList;

/**
 * Created by yinyxn on 2016/2/26.
 */
public class Classify2Adapter extends BaseAdapter {

    ArrayList<String> data = new ArrayList<>();
    private LayoutInflater layoutInflater;
    Context context;
    public Classify2Adapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.mode3,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            //有holder 从Tag中取
            holder = (ViewHolder) convertView.getTag();
        }

        //绑定数据
        holder.bindData(data.get(position));


        return convertView;
    }
    static class ViewHolder {
        TextView title;

        public ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.textView17);
        }

        public void bindData(String s) {
            title.setText(s);
        }
    }
}

package com.yinyxn.fleamarket.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yinyxn.fleamarket.R;

import java.util.ArrayList;


public class ClassifyAdapter extends BaseAdapter {

    ArrayList<String> data = new ArrayList<>();
    private LayoutInflater layoutInflater;
    Context context;
    public ClassifyAdapter(Context context, ArrayList<String> data) {
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
            convertView = layoutInflater.inflate(R.layout.grid_list_classify,parent,false);
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
            title = (TextView) view.findViewById(R.id.textView_title);
        }

        public void bindData(String s) {
            title.setText(s);
        }
    }
}

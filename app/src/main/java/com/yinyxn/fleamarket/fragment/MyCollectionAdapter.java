package com.yinyxn.fleamarket.fragment;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;

import com.yinyxn.fleamarket.R;
import com.yinyxn.fleamarket.domain.ProductCollection;

public class MyCollectionAdapter extends SimpleCursorAdapter {

    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public MyCollectionAdapter(Context context, Cursor c) {
        super(
                context,
                R.layout.mode_mycollection,
                c,
                ProductCollection.ALL, new int[]{R.id.textView_productid,R.id.textView_textView_productname, R.id.textView_textView_productor, R.id.textView_textView_productorphone,R.id.textView_textView_productordescribe,R.id.textView_textView_productclass},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
    }

    @Override
    public void bindView(
            View view,
            Context context,
            Cursor cursor) {
        super.bindView(view, context, cursor);//默认绑定一次


        //获得当前位置ID
        final long id = cursor.getLong(cursor.getColumnIndex(ProductCollection._ID));//得到User._ID的索引
        Button button = (Button) view.findViewById(R.id.button_deleteproductte);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != callback) {

                    callback.remove(id);
                }
            }
        });
    }

    //回调
    interface Callback {
        void remove(long id);
    }
}


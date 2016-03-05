package com.yinyxn.fleamarket;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;

import com.yinyxn.fleamarket.domain.Product;


/**
 * Created by yinyxn on 2015/12/5.
 */
public class ManagerAdapter2 extends SimpleCursorAdapter {

    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public ManagerAdapter2(Context context, Cursor c) {
        super(
                context,
                R.layout.mode2,
                c,
                Product.ALL, new int[]{R.id.textView_productid, R.id.textView_textView_productname, R.id.textView_textView_productclass,R.id.textView_textView_productor,R.id.textView_textView_productorphone,R.id.textView_textView_productordescribe},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
    }

    @Override
    public void bindView(
            View view,
            Context context,
            Cursor cursor) {
        super.bindView(view, context, cursor);//默认绑定一次

        //获得当前位置ID
        final long id = cursor.getLong(cursor.getColumnIndex(Product._ID));

        Button button = (Button) view.findViewById(R.id.button_deleteproductte);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != callback) {

                    callback.removeP(id);
                }
            }
        });
    }

    //回调
    interface Callback {
        void removeP(long id);
    }
}


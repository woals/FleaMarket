package com.yinyxn.fleamarket;

import android.content.Context;
import android.database.Cursor;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.yinyxn.fleamarket.domain.User;

public class ManagerAdapter extends SimpleCursorAdapter {

    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public ManagerAdapter(Context context, Cursor c) {
        super(
                context,
                R.layout.mode,
                c,
                User.ALL, new int[]{R.id.textView_productid, R.id.textView_username, R.id.textView_password,R.id.textView_textView_productordescribe,R.id.textView_textView_productor,R.id.textView_textView_productorphone},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
    }

    @Override
    public void bindView(
            View view,
            Context context,
            Cursor cursor) {
        super.bindView(view, context, cursor);//默认绑定一次

        int index = cursor.getColumnIndex(User._TIME);//得到索引
        long time = cursor.getLong(index);

        //获得当前位置ID
        final long id = cursor.getLong(cursor.getColumnIndex(User._ID));//得到User._ID的索引

        TextView textViewTime = (TextView) view.findViewById(R.id.textView_time);
        textViewTime.setText(DateFormat.format("yyyy/MM/dd H:m:s", time));
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


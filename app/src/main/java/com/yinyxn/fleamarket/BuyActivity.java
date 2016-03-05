package com.yinyxn.fleamarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yinyxn.fleamarket.domain.ProductCollection;
import com.yinyxn.fleamarket.service.ProductCollectionService;

public class BuyActivity extends AppCompatActivity {

    TextView textViewdescribe;
    TextView textViewproductor;
    TextView textViewphone;
    TextView textViewprice;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

       initView();
    }

    private void initView() {
        textViewdescribe = (TextView) findViewById(R.id.textView30);
        textViewproductor = (TextView) findViewById(R.id.textView24);
        textViewphone = (TextView) findViewById(R.id.textView26);
        textViewprice = (TextView) findViewById(R.id.textView29);
        button = (Button) findViewById(R.id.button_collection);
        //获得创建该活动的意图
        String name = getIntent()
                .getStringExtra(App.EXTRA_NAME1);
        String name2 = getIntent()
                .getStringExtra(App.EXTRA_NAME2);
        String name3 = getIntent()
                .getStringExtra(App.EXTRA_NAME3);
        String name4 = getIntent()
                .getStringExtra(App.EXTRA_NAME4);


        textViewproductor.setText(name);
        textViewdescribe.setText(name3);
        textViewphone.setText(name2);
        textViewprice.setText(name4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name5 = getIntent()
                        .getStringExtra(App.EXTRA_NAME5);
                String name = textViewproductor.getText().toString();
                String name1 = textViewphone.getText().toString();
                String name2 = textViewdescribe.getText().toString();
                String name3 = textViewprice.getText().toString();
                Log.d("tag", name);
                Log.d("tag", name1);
                Log.d("tag",name2);
                Log.d("tag",name3);
                Log.d("tag",name5);

                ProductCollection productCollection = new ProductCollection();
                productCollection.setProductName(name5);
                productCollection.setProductorName(name);
                productCollection.setProductorPhone(name1);
                productCollection.setProductorDescribe(name2);
                productCollection.setProductprice(name3);

                if (App.flag){
                    String key = App.KEY;
                    productCollection.setProductkey(key);
                    ProductCollectionService productCollectionService = new ProductCollectionService(BuyActivity.this);
                    boolean flag = productCollectionService.collection(productCollection);
                    if(flag){
                        Toast.makeText(BuyActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();

                    }

                }else {
                    Toast.makeText(BuyActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyActivity.this,LoginActivity.class));
                }
            }
        });
    }
}

package com.yinyxn.fleamarket;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yinyxn.fleamarket.fragment.ClassifyFragment;
import com.yinyxn.fleamarket.fragment.MarketFragment;
import com.yinyxn.fleamarket.fragment.MyFragment;
import com.yinyxn.fleamarket.fragment.ReleaseFragment;

public class TabActivity extends AppCompatActivity {

    FragmentManager fm;
    ReleaseFragment releaseFragment;
    ClassifyFragment classifyFragment;
    MarketFragment marketFragment;
    MyFragment myFragment;
    Button button_classify;
    Button button_market;
    Button button_release;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        if(savedInstanceState == null){
            releaseFragment = new ReleaseFragment();
            classifyFragment = new ClassifyFragment();
            marketFragment = new MarketFragment();
            myFragment = new MyFragment();
            button_classify = (Button) findViewById(R.id.button_classify);
            button_market = (Button) findViewById(R.id.button_market);
            button_release = (Button) findViewById(R.id.button_release);
        }
        initView();
    }

    private void initView() {

        fm = getSupportFragmentManager();
        button_market.setTextColor(Color.GREEN);
        button_classify.setTextColor(Color.BLACK);
        button_release.setTextColor(Color.BLACK);
        fm.beginTransaction().replace(R.id.content,marketFragment).commit();
    }

    public void changeTab(View view) {
        switch (view.getId()){
            case R.id.button_classify:
                button_classify.setTextColor(Color.GREEN);
                button_market.setTextColor(Color.BLACK);
                button_release.setTextColor(Color.BLACK);
                fm.beginTransaction().replace(R.id.content,classifyFragment).commit();
                break;
            case R.id.button_market:
                button_classify.setTextColor(Color.BLACK);
                button_market.setTextColor(Color.GREEN);
                button_release.setTextColor(Color.BLACK);
                fm.beginTransaction().replace(R.id.content, marketFragment).commit();
                break;
            case R.id.button_my:
//                fm.beginTransaction().replace(R.id.content,myFragment).commit();
                if(App.flag){
                    startActivity(new Intent(TabActivity.this,MyActivity.class));
                }else {
                    startActivity(new Intent(TabActivity.this,LoginActivity.class));
                }
                break;
            case R.id.button_release:
                button_classify.setTextColor(Color.BLACK);
                button_market.setTextColor(Color.BLACK);
                button_release.setTextColor(Color.GREEN);
                if(App.flag){
                    fm.beginTransaction().replace(R.id.content,releaseFragment).commit();
                }else {
                    fm.beginTransaction().replace(R.id.content,releaseFragment).commit();
                }
                break;
            case R.id.button_more:
                startActivity(new Intent(TabActivity.this,MoreActivity.class));
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(App.modify){
            initView();
        }
    }
}

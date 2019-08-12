package com.example.ab.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ab.R;
import com.example.ab.base.App;
import com.example.ab.base.Common;
import com.example.ab.data.dao.FruitDao;
import com.example.ab.data.db.Fruit;
import com.example.ab.presenter.WelcomePresenter;
import com.example.ab.ui.viewinterface.IWelcomeView;
import com.example.ab.utils.SharedPreferenceUtils;

public class WelcomeActivity extends AppCompatActivity implements IWelcomeView {
    private WelcomePresenter welcomePresenter;
    // 1. 水果界面修改为查询
    // 2. LikeFragment中在onStart方法中调用 了解一下Fragment重新打开生命周期的过程
    protected void onCreate(Bundle savedInstanceState) {
        // TODO
        // 第一次登陆的时候水果数据的初始化
        // 第一次的判断用SharedPreferences
        super.onCreate(savedInstanceState);
//        boolean isFirst = SharedPreferenceUtils.getBoolean(Common.Constant.IS_FIRST_CLIENT);
//        if(isFirst){
//            SharedPreferenceUtils.putBoolean(Common.Constant.IS_FIRST_CLIENT,false);
//        }
        setContentView(R.layout.activity_welcome);
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        Button btnRegister = (Button) findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
        initData();
    }
    private void initData() {
        welcomePresenter = new WelcomePresenter(this);
    }
    //登录
    private void login(){
        Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
        startActivity(intent);
    }
    //注册
    private void register(){
        Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
    public void onStart() {
        super.onStart();
        welcomePresenter.initfruit();
    }
    // TODO 第一次打开存储水果数据
}


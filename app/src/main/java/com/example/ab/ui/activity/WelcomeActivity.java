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
import com.example.ab.utils.SharedPreferenceUtils;

public class WelcomeActivity extends AppCompatActivity {

    // 1. 水果界面修改为查询
    // 2. LikeFragment中在onStart方法中调用 了解一下Fragment重新打开生命周期的过程


    protected void onCreate(Bundle savedInstanceState) {

        // TODO
        // 第一次登陆的时候水果数据的初始化
        // 第一次的判断用SharedPreferences
        super.onCreate(savedInstanceState);
        boolean isFirst = SharedPreferenceUtils.getBoolean(Common.Constant.IS_FIRST_CLIENT);
        if(isFirst){
            initFruits();
            SharedPreferenceUtils.putBoolean(Common.Constant.IS_FIRST_CLIENT,false);
        }

        setContentView(R.layout.activity_welcome);
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        Button btnRegister = (Button) findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //
        /*Fruit apple = new Fruit();
        apple.setFruitName("苹果");
        apple.setResourceId(R.drawable.apple_pic);
        App.getInstance().getDaoSession().getFruitDao().save(apple);*/
    }



    // TODO 第一次打开存储水果数据
    private void initFruits() {
        FruitDao fruitDao= App.getInstance().getDaoSession().getFruitDao();
        fruitDao.insert(new Fruit(1,"Apple",R.drawable.apple_pic,1));
        fruitDao.insert(new Fruit(2,"Banana",R.drawable.banana_pic,1));
        fruitDao.insert(new Fruit(3,"Orange" ,R.drawable.orange_pic,1));
        fruitDao.insert(new Fruit(4,"Watermelon",R.drawable.watermelon_pic,1 ));
        fruitDao.insert(new Fruit( 5,"Pear",R.drawable.pear_pic,1));
        fruitDao.insert(new Fruit(6,"Grape" ,R.drawable.grape_pic,1));
        fruitDao.insert(new Fruit(7,"Pineapple",R.drawable.pineapple_pic ,1));
        fruitDao.insert(new Fruit(8,"Strawberry",R.drawable.strawberry_pic,1));
        fruitDao.insert(new Fruit( 9,"Cherry",R.drawable.cherry_pic,1));
        fruitDao.insert(new Fruit(10,"Mango",R.drawable.mango_pic,1));
    }
}


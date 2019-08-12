package com.example.ab.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ab.R;
import com.example.ab.base.App;
import com.example.ab.data.db.LikeFruit;
import com.example.ab.data.helper.LikeHelper;

public class FruitDetailActivity extends AppCompatActivity {
    public static final String FRUIT_ID = "FRUIT_ID";
    public static final String dat="dat";

    private ImageView fruitImage;
    //private LikeFruitDao likeFruitDao;
    private LikeHelper fruitHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_detail);
        fruitImage = (ImageView) findViewById(R.id.fruit_image);
        // TODO 做数据库查询 查询指定Id的水果
        accept();
        Button btnlike = (Button) findViewById(R.id.btn_like);
        btnlike.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // TODO  1. 生成一个收藏记录
                // 2. 界面返回
                insert();
            }
        }
        );
    }
    private void accept(){
        fruitHelper = new LikeHelper(App.getInstance().getDaoSession().getLikeFruitDao());
        Intent intent = getIntent();
        final int sourceid = intent.getIntExtra(FRUIT_ID, 0);
        fruitImage.setImageResource(sourceid);
        final Long id = intent.getLongExtra(dat, 0);
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        final String userid=pref.getString("account","id");
    }
    private void insert(){
        Intent intent = getIntent();
        final Long id = intent.getLongExtra(dat, 0);
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        final String userid=pref.getString("account","id");
        fruitHelper.insert(new LikeFruit(id,Long.valueOf(userid),id));
        Toast.makeText(FruitDetailActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}

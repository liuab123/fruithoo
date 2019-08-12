package com.example.ab.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ab.R;
import com.example.ab.base.App;
import com.example.ab.data.helper.UserHelper;
import com.example.ab.data.dao.UserDao;
import com.example.ab.data.db.User;
import com.example.ab.presenter.LoginPresenter;
import com.example.ab.ui.viewinterface.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private LoginPresenter loginPresenter;
    private EditText id2text;
    private EditText pa2text;
    private String id;
    private String pa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initData();
        click();
    }
    public void click(){
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        Button btnCancel = (Button) findViewById(R.id.btn_cancel);
        id2text = (EditText) findViewById(R.id.et_account);
        pa2text = (EditText) findViewById(R.id.et_password);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 账号密码是否为空
                if(checkInput()) {
                    loginPresenter.logincheck(Long.valueOf(id), pa);
                }
            }
        });
    }

    private void initData() {
        loginPresenter = new LoginPresenter(this);
    }
//    private void login(){
//        String id = id2text.getText().toString();
//        String pa = pa2text.getText().toString();
//        if(id !=null&pa !=null) {
//            UserHelper helper = new UserHelper(App.getInstance().getDaoSession().getUserDao());
//            User user = helper.login(Long.valueOf(id), pa);
//            String tt = id;
//            if (user != null) {
//                // TODO 跳转
//                // TODO 利用SharedPreferences把用户Id存进去
//                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
//                editor.putString("account",tt);

//                editor.apply();
//                Intent intent = new Intent(LoginActivity.this, BotActivity.class);
//                startActivity(intent);
//            } else {
//                // TODO 显示账号密码错误
//                Toast.makeText(LoginActivity.this, "账号密码错误", Toast.LENGTH_SHORT).show();
//            }
//        }else {
//            Toast.makeText(LoginActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();}
//    }
//    private boolean isNotEmpty(String s) {
//        if (s != null && !s.equals("") || s.length() > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean checkInput() {
        pa = pa2text.getText().toString();
        id = id2text.getText().toString();
        if (id.equals("")) {
            Toast.makeText(LoginActivity.this, "账号不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (pa.equals("")) {
            Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();;
            return false;
        }
        return true;
    }
    @Override
    public void onLoginSucceed() {
        String tt = id;
        // TODO 跳转
        // TODO 利用SharedPreferences把用户Id存进去
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("account",tt);
        editor.apply();
        Intent intent = new Intent(LoginActivity.this, BotActivity.class);
        startActivity(intent);
        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFaild() {
        Toast.makeText(LoginActivity.this, "账号密码有错误", Toast.LENGTH_SHORT).show();
    }
}
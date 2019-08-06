package com.example.ab.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ab.R;
import com.example.ab.base.App;
import com.example.ab.data.dao.UserDao;
import com.example.ab.data.db.User;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private UserDao userDao;

    private boolean isNotEmpty(String s) {
        if (s != null && !s.equals("") || s.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty(String s) {
        if (isNotEmpty(s)) {
            return false;
        } else {
            return true;
        }
    }
    private EditText id1text;
    private EditText pa1text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userDao = App.getInstance().getDaoSession().getUserDao();

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        Button btnCancel = (Button) findViewById(R.id.btn_cancel);
        id1text = (EditText) findViewById(R.id.ed_password);
        pa1text = (EditText) findViewById(R.id.ed_account);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = id1text.getText().toString();
                String name = pa1text.getText().toString();
                if (isNotEmpty(id) && isNotEmpty(name)) {
                    QueryBuilder qb = userDao.queryBuilder();
                    ArrayList<User> list = (ArrayList<User>) qb.where(UserDao.Properties.Id.eq(id)).list();
                    if (list.size() > 0) {
                        Toast.makeText(RegisterActivity.this, "已有用户", Toast.LENGTH_SHORT).show();
                    } else {
                        userDao.insert(new User(Long.valueOf(id), name));
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                } else {
                    if (isEmpty(id) && isNotEmpty(name)) {
                        Toast.makeText(RegisterActivity.this, "id为空", Toast.LENGTH_SHORT).show();
                    }
                    if (isEmpty(name) && isNotEmpty(id)) {
                        Toast.makeText(RegisterActivity.this, "密码为空", Toast.LENGTH_SHORT).show();
                    }
                    if (isEmpty(id) && isEmpty(name)) {
                        Toast.makeText(RegisterActivity.this, "请填写信息", Toast.LENGTH_SHORT).show();
                    }

                }
                id1text.setText("");
                pa1text.setText("");
            }
        });
    }
}

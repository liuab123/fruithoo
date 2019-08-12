package com.example.ab.model;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.ab.base.App;
import com.example.ab.data.db.User;
import com.example.ab.data.helper.UserHelper;
import com.example.ab.ui.activity.BotActivity;
import com.example.ab.ui.activity.LoginActivity;

import static android.content.Context.MODE_PRIVATE;

public class LoginModel implements ILoginModel {
    public boolean onLogin(Long id,String password) {
        UserHelper helper = new UserHelper(App.getInstance().getDaoSession().getUserDao());
        User user = helper.login(id, password);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }
}

package com.example.ab.model;

import com.example.ab.base.App;
import com.example.ab.data.db.User;
import com.example.ab.data.helper.UserHelper;

public class RegisterModel implements IRegisterModel {
    public boolean onRegister(Long id,String password) {
        UserHelper helper = new UserHelper(App.getInstance().getDaoSession().getUserDao());
        User user = helper.register(id, password);
        if (user == null) {
            helper.insert(new User(id,password));
            return true;
        } else {
            return false;
        }
    }
}

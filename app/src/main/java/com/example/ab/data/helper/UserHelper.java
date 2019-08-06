package com.example.ab.data.helper;

import com.example.ab.data.dao.DaoSession;
import com.example.ab.data.dao.UserDao;
import com.example.ab.data.db.User;

/**
 * 用户的辅助工具类
 */
public class UserHelper {

    private UserDao mUserDao;

    public UserHelper(UserDao userDao) {
        this.mUserDao = userDao;
    }


    public User login(long account,String pwd){
        return mUserDao.queryBuilder()
                .where(UserDao.Properties.Id.eq(account),UserDao.Properties.Password.eq(pwd))
                .unique();
    }
}

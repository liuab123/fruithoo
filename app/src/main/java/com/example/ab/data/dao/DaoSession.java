package com.example.ab.data.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.ab.data.db.Fruit;
import com.example.ab.data.db.LikeFruit;
import com.example.ab.data.db.User;

import com.example.ab.data.dao.FruitDao;
import com.example.ab.data.dao.LikeFruitDao;
import com.example.ab.data.dao.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig fruitDaoConfig;
    private final DaoConfig likeFruitDaoConfig;
    private final DaoConfig userDaoConfig;

    private final FruitDao fruitDao;
    private final LikeFruitDao likeFruitDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        fruitDaoConfig = daoConfigMap.get(FruitDao.class).clone();
        fruitDaoConfig.initIdentityScope(type);

        likeFruitDaoConfig = daoConfigMap.get(LikeFruitDao.class).clone();
        likeFruitDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        fruitDao = new FruitDao(fruitDaoConfig, this);
        likeFruitDao = new LikeFruitDao(likeFruitDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(Fruit.class, fruitDao);
        registerDao(LikeFruit.class, likeFruitDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        fruitDaoConfig.clearIdentityScope();
        likeFruitDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public FruitDao getFruitDao() {
        return fruitDao;
    }

    public LikeFruitDao getLikeFruitDao() {
        return likeFruitDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
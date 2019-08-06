package com.example.ab.data.db;

import androidx.annotation.DrawableRes;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.ab.data.dao.DaoSession;

import org.greenrobot.greendao.annotation.NotNull;
import com.example.ab.data.dao.UserDao;
import com.example.ab.data.dao.LikeFruitDao;
import com.example.ab.data.dao.FruitDao;

@Entity
public class LikeFruit {

    @Id(autoincrement = true)
    private long id;
    @DrawableRes
    //private int sourceId;
    // 用户外键
    private long userId;
    @ToOne(joinProperty = "userId")
    private User user;

    // 水果的外键
    // fruitId
    private long fruitId;
    @ToOne(joinProperty = "fruitId")
    private Fruit fruit;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 567314412)
    private transient LikeFruitDao myDao;
    @Generated(hash = 371996030)
    public LikeFruit(long id, long userId, long fruitId) {
        this.id = id;
        this.userId = userId;
        this.fruitId = fruitId;
    }
    @Generated(hash = 1941447135)
    public LikeFruit() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getFruitId() {
        return this.fruitId;
    }
    public void setFruitId(long fruitId) {
        this.fruitId = fruitId;
    }
    @Generated(hash = 251390918)
    private transient Long user__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 115391908)
    public User getUser() {
        long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 462495677)
    public void setUser(@NotNull User user) {
        if (user == null) {
            throw new DaoException(
                    "To-one property 'userId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.user = user;
            userId = user.getId();
            user__resolvedKey = userId;
        }
    }
    @Generated(hash = 2098301725)
    private transient Long fruit__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1314500788)
    public Fruit getFruit() {
        long __key = this.fruitId;
        if (fruit__resolvedKey == null || !fruit__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FruitDao targetDao = daoSession.getFruitDao();
            Fruit fruitNew = targetDao.load(__key);
            synchronized (this) {
                fruit = fruitNew;
                fruit__resolvedKey = __key;
            }
        }
        return fruit;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 86245075)
    public void setFruit(@NotNull Fruit fruit) {
        if (fruit == null) {
            throw new DaoException(
                    "To-one property 'fruitId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.fruit = fruit;
            fruitId = fruit.getId();
            fruit__resolvedKey = fruitId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 868861267)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLikeFruitDao() : null;
    }


}

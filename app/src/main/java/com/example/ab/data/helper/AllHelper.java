package com.example.ab.data.helper;

import com.example.ab.data.dao.FruitDao;
import com.example.ab.data.db.Fruit;

import java.util.List;

public class AllHelper {
    private FruitDao mFruitDao;

    public AllHelper(FruitDao FruitDao) {
        this.mFruitDao = FruitDao;
    }
    public List<Fruit> getAllFruitByUserId(int appid){
        return mFruitDao.queryBuilder()
                .where(FruitDao.Properties.AppId.eq(appid))
                .list();
    }
}

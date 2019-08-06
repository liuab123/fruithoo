package com.example.ab.data.helper;

import com.example.ab.data.dao.FruitDao;
import com.example.ab.data.db.Fruit;

import java.util.List;

public class FruitHelper {
    private FruitDao mFruitDao;

    public FruitHelper(FruitDao likeFruitDao) {
        this.mFruitDao = likeFruitDao;
    }

    public Fruit select(long id){
        return mFruitDao.queryBuilder()
                .where(FruitDao.Properties.Id.eq(id))
                .unique();
    }


}

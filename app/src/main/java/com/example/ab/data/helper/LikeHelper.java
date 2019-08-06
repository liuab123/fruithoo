package com.example.ab.data.helper;

import com.example.ab.data.dao.LikeFruitDao;
import com.example.ab.data.db.LikeFruit;

import java.util.List;

public class LikeHelper {
    private LikeFruitDao mLikeFruitDao;

    public LikeHelper(LikeFruitDao likeFruitDao) {
        this.mLikeFruitDao = likeFruitDao;
    }


    public LikeFruit select(long id){
        return mLikeFruitDao.queryBuilder()
                .where(LikeFruitDao.Properties.Id.eq(id))
                .unique();
    }

    public List<LikeFruit> getAllLikeByUserId(Long userId){
        return mLikeFruitDao.queryBuilder()
                .where(LikeFruitDao.Properties.UserId.eq(userId))
                .list();
    }

    public void insert(LikeFruit likeFruit){
        mLikeFruitDao.insertOrReplace(likeFruit);
    }


}

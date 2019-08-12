package com.example.ab.model;

import com.example.ab.R;
import com.example.ab.base.App;
import com.example.ab.data.dao.FruitDao;
import com.example.ab.data.db.Fruit;

public class WelcomeModel implements IWelcomeModel {
    public void initFruits() {
        FruitDao fruitDao= App.getInstance().getDaoSession().getFruitDao();
        fruitDao.insert(new Fruit(1,"Apple", R.drawable.apple_pic,1));
        fruitDao.insert(new Fruit(2,"Banana",R.drawable.banana_pic,1));
        fruitDao.insert(new Fruit(3,"Orange" ,R.drawable.orange_pic,1));
        fruitDao.insert(new Fruit(4,"Watermelon",R.drawable.watermelon_pic,1 ));
        fruitDao.insert(new Fruit( 5,"Pear",R.drawable.pear_pic,1));
        fruitDao.insert(new Fruit(6,"Grape" ,R.drawable.grape_pic,1));
        fruitDao.insert(new Fruit(7,"Pineapple",R.drawable.pineapple_pic ,1));
        fruitDao.insert(new Fruit(8,"Strawberry",R.drawable.strawberry_pic,1));
        fruitDao.insert(new Fruit( 9,"Cherry",R.drawable.cherry_pic,1));
        fruitDao.insert(new Fruit(10,"Mango",R.drawable.mango_pic,1));
    }
}

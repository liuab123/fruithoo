package com.example.ab.base;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.ab.data.dao.DaoMaster;
import com.example.ab.data.dao.DaoSession;

public class App extends Application {

    private static App instance;
    private DaoSession daoSession;

    public static App getInstance() {
        if (instance == null)
            instance = new App();
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDbHelp();
    }

    private void initDbHelp(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "recluse-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        this.daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
}

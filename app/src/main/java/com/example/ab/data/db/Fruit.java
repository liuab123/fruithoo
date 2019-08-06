package com.example.ab.data.db;

import androidx.annotation.DrawableRes;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Fruit {

    @Id
    private long id;

    private String name;

    private @DrawableRes int sourceId;

    private int appId;

    @Generated(hash = 2119476716)
    public Fruit(long id, String name, int sourceId, int appId) {
        this.id = id;
        this.name = name;
        this.sourceId = sourceId;
        this.appId = appId;
    }

    @Generated(hash = 2030614587)
    public Fruit() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getAppId() {
        return this.appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    
}

package com.example.ab.ui.fragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.example.ab.R;
import com.example.ab.adapter.LikeFruitAdapter;
import com.example.ab.base.App;
import com.example.ab.data.db.Fruit;
import com.example.ab.data.db.LikeFruit;
import com.example.ab.data.helper.LikeHelper;

import java.util.LinkedList;
import java.util.List;

public class LikeFragment extends Fragment {

    private boolean isGetData = false;
    //private List<likefruit> likefruitList = new ArrayList<likefruit>();
    private List<LikeFruit> fruits = new LinkedList<>();
    private LikeFruitAdapter mAdapter;
    private LikeHelper likeHelper;
    private long userId = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        likeHelper = new LikeHelper(App.getInstance().getDaoSession().getLikeFruitDao());
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
        userId = Long.valueOf(sharedPreferences.getString("account", "1"));
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_likefragment, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new LikeFruitAdapter(fruits);
        recyclerView.setAdapter(mAdapter);
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        fruits = likeHelper.getAllLikeByUserId(userId);
        mAdapter.replaceFruits(fruits);
    }
}

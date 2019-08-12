package com.example.ab.ui.fragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ab.R;
import com.example.ab.adapter.FruitAdapter;
import com.example.ab.base.App;
import com.example.ab.data.dao.FruitDao;
import com.example.ab.data.db.Fruit;
import com.example.ab.data.helper.AllHelper;
import com.example.ab.data.helper.FruitHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllFragment extends Fragment {

    // TODO 修改为数据库查询
    private List<Fruit> fruitList = new LinkedList<>();
    private View view;
    private int appid;
    private FruitAdapter mAdapter;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_allfragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new FruitAdapter(fruitList, getContext());
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    public void onStart() {
        super.onStart();
        AllHelper helper = new AllHelper(App.getInstance().getDaoSession().getFruitDao());
        appid = 1;
        fruitList = helper.getAllFruitByUserId(appid);
        mAdapter.replaceFruits(fruitList);
    }
}
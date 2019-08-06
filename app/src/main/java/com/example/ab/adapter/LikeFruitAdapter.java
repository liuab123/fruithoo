package com.example.ab.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ab.R;
import com.example.ab.base.App;
import com.example.ab.data.db.Fruit;
import com.example.ab.data.db.LikeFruit;
import com.example.ab.data.helper.FruitHelper;

import java.util.List;

public class LikeFruitAdapter extends RecyclerView.Adapter<LikeFruitAdapter.ViewHolder>{

    private List<LikeFruit> mLikeFruitList;

    FruitHelper helper = new FruitHelper(App.getInstance().getDaoSession().getFruitDao());


    public LikeFruitAdapter(List<LikeFruit> likefruitList) {
        mLikeFruitList = likefruitList;
    }

    public void replaceFruits(List<LikeFruit> fruits){
        mLikeFruitList.clear();
        mLikeFruitList.addAll(fruits);
        // 进行数据的刷新
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.likefruit_item, parent, false);
        return new ViewHolder(view);
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        TextView userName;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.likefruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
            userName = (TextView) view.findViewById(R.id.user_name);
        }
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final LikeFruit fruit = mLikeFruitList.get(position);
        //fruit.getFruit().getSourceId();
        Fruit da = helper.select(fruit.getFruitId());
        holder.userName.setText(String.valueOf(fruit.getUserId()));
        holder.fruitImage.setImageResource(da.getSourceId());
        holder.fruitName.setText(da.getName());


    }
    public int getItemCount() {
        return mLikeFruitList.size();
    }
}
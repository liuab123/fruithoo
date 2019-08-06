package com.example.ab.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ab.R;
import com.example.ab.data.db.Fruit;
import com.example.ab.ui.activity.FruitDetailActivity;

import java.util.List;

import static com.example.ab.ui.activity.FruitDetailActivity.FRUIT_ID;
import static com.example.ab.ui.activity.FruitDetailActivity.dat;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{

    private List<Fruit> mFruitList;
    private Context mContext;


    public FruitAdapter(List<Fruit> fruitList, Context context) {
        mFruitList = fruitList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getSourceId());
        holder.fruitName.setText(fruit.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(mContext, FruitDetailActivity.class);
                intent.putExtra(FRUIT_ID,fruit.getSourceId());
                intent.putExtra(dat,fruit.getId());
                mContext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }
}
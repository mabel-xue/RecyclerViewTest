package com.firstline.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by mabelxue on 2017/4/11.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    /**
     * FruitAdapter 的构造函数，传入 RecyclerView 要展示的数据源，并赋值给全局变量 mFruitList
     * @param fruitList 要展示的数据源
     */
    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView; // 用于保存子项最外层布局的实例
        ImageView fruitImage;
        TextView fruitName;

        /**
         * ViewHolder 的构造函数
         * @param view 是 RecyclerView 子项的最外层布局
         */
        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    // 用于创建 ViewHolder 实例
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked view: " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked image: " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    // 用于对 RecyclerView 子项的数据进行赋值，会在每个子项滚到屏幕内的时候执行
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

}

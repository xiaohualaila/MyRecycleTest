package com.example.administrator.myrecycletest.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2018/2/25.
 */

public abstract class CommonRecycleAdapter <T> extends RecyclerView.Adapter<CommonViewHolder>{

    protected LayoutInflater layoutInflater;

    protected List<T> dataList;

    protected int layoutId;

    protected MultiTypeSupport<T> multiTypeSupport;

    public CommonRecycleAdapter(Context context, List<T> dataList, int layoutId) {
        this.layoutInflater = LayoutInflater.from(context);
        this.dataList = dataList;
        this.layoutId = layoutId;
    }

    @Override
    public int getItemViewType(int position) {
        if (multiTypeSupport != null) {
            return multiTypeSupport.getLayoutId(dataList.get(position), position);
        }
        return super.getItemViewType(position);
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (multiTypeSupport != null) {
            layoutId = viewType;
        }
        View itemView = layoutInflater.inflate(layoutId, parent, false);
        return new CommonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        bindData(holder, dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    abstract void bindData(CommonViewHolder holder, T data);
}

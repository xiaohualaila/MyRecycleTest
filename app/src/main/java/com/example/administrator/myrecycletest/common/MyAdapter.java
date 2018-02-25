package com.example.administrator.myrecycletest.common;

import android.content.Context;

import com.example.administrator.myrecycletest.Data;
import com.example.administrator.myrecycletest.R;

import java.util.List;

/**
 * Created by Administrator on 2018/2/25.
 */

public class MyAdapter extends CommonRecycleAdapter<Data> implements MultiTypeSupport<Data>{
    private CommonViewHolder.onItemCommonClickListener commonClickListener;

    public MyAdapter(Context context, List<Data> dataList) {
        super(context, dataList, R.layout.item_left);
    }

    public MyAdapter(Context context, List<Data> dataList, CommonViewHolder.onItemCommonClickListener commonClickListener) {
        super(context, dataList, R.layout.item_left);
        this.commonClickListener = commonClickListener;
        this.multiTypeSupport = this;
    }

    @Override
    void bindData(CommonViewHolder holder, Data data) {
        holder.setText(R.id.tv_title, data.getTitle())
                .setText(R.id.tv_content, data.getContent())
                .setCommonClickListener(commonClickListener);
    }

    @Override
    public int getLayoutId(Data item, int position) {
        if (item.getLocation().equals("left")) {
            return R.layout.item_left;
        }
        return R.layout.item_right;
    }
}

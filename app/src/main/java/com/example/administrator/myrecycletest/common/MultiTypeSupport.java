package com.example.administrator.myrecycletest.common;

/**
 * Created by Administrator on 2018/2/25.
 */

public interface MultiTypeSupport<T> {
    int getLayoutId(T item, int position);
}

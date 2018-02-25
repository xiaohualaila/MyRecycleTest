package com.example.administrator.myrecycletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.administrator.myrecycletest.common.CommonViewHolder;
import com.example.administrator.myrecycletest.common.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CommonViewHolder.onItemCommonClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<Data> dataList = new ArrayList<>();
        boolean bool = false;
        for (int i = 0; i < 40; i++) {
            Data data = new Data("叶应是叶", "我也不知道说什么好，我也不知道说什么好，我也不知道说什么好，我也不知道说什么好");
            if (!bool) {
                data.setLocation("left");
            } else {
                data.setLocation("right");
            }
            bool = !bool;
            dataList.add(data);
        }
      //  MyRecyclerAdapter adapter = new MyRecyclerAdapter(this, dataList);
        MyAdapter adapter1 = new MyAdapter(this, dataList, this);
        recyclerView.setAdapter(adapter1);
    }

    @Override
    public void onItemClickListener(int position) {
        Toast.makeText(this, "position:" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClickListener(int position) {
        Toast.makeText(this, "position:" + position, Toast.LENGTH_SHORT).show();
    }
}

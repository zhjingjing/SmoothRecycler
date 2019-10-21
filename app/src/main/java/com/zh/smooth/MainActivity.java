package com.zh.smooth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_first)
    RecyclerView recyclerView1;
    @BindView(R.id.recycler_second)
    RecyclerView recyclerView2;
    @BindView(R.id.recycler_third)
    RecyclerView recyclerView3;

    PhotoAdapter photoAdapter;
    List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    private void initView() {
        list=new ArrayList<>();
        photoAdapter=new PhotoAdapter(this,list);

        ScollLinearLayoutManager manager1=new ScollLinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);

        ScollLinearLayoutManager manager2=new ScollLinearLayoutManager(this);
        manager2.setOrientation(LinearLayoutManager.HORIZONTAL);

        ScollLinearLayoutManager manager3=new ScollLinearLayoutManager(this);
        manager3.setOrientation(LinearLayoutManager.HORIZONTAL);

        if (recyclerView1==null){
            Log.e("xxx","xxxxxxx");
        }

        recyclerView1.setLayoutManager(manager1);
        recyclerView2.setLayoutManager(manager2);
        recyclerView3.setLayoutManager(manager3);

        recyclerView1.setAdapter(photoAdapter);
        recyclerView2.setAdapter(photoAdapter);
        recyclerView3.setAdapter(photoAdapter);

    }

    private void initData() {
        list.add("https://img.tikas.in/tika/30050/image/icon.jpg");
        list.add("https://img.tikas.in/tika/30050/image/icon.jpg");
        list.add("https://img.tikas.in/tika/30050/image/icon.jpg");
        list.add("https://img.tikas.in/tika/30050/image/icon.jpg");list.add("https://img.tikas.in/tika/30050/image/icon.jpg");


        photoAdapter.notifyDataSetChanged();
        recyclerView1.smoothScrollToPosition(Integer.MAX_VALUE/2);
        recyclerView2.scrollToPosition(Integer.MAX_VALUE/2);
        recyclerView2.smoothScrollToPosition(0);
        recyclerView3.smoothScrollToPosition(Integer.MAX_VALUE/2);
    }

}

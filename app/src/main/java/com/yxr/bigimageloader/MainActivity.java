package com.yxr.bigimageloader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yxr.bigimageloader.gesture.LargeImageView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<StarMan> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recycleview);
        final BaseQuickAdapter<StarMan> adapter = new BaseQuickAdapter<StarMan>(this, R.layout.item_news, data) {

            @Override
            protected void convert(BaseViewHolder baseViewHolder, StarMan s) {
                baseViewHolder.setText(R.id.tvName, s.getName());

            }
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        data.add(new StarMan("刘涛", "liutao.jpg"));
        data.add(new StarMan("刘涛1", "lt.jpg"));
        data.add(new StarMan("王子文", "wzw.jpg"));
        data.add(new StarMan("刘涛", "IMG_2963.JPG"));
        adapter.addAfterClear(data);

        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(MainActivity.this, BigImageActivity.class);
                intent.putExtra(BigImageActivity.ASSETS_PATH, adapter.getItem(i).getUrl());
                startActivity(intent);
            }
        });

    }

}

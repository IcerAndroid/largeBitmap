package com.yxr.bigimageloader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yxr.bigimageloader.gesture.LargeImageView;

import java.io.IOException;

/**
 * Created by icer on 16/5/10.
 */
public class BigImageActivity extends AppCompatActivity {

    public static final String ASSETS_PATH="assets_path";
    private LargeImageView largeImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String path = getIntent().getStringExtra(ASSETS_PATH);
        setContentView(R.layout.activity_bigimage);
        largeImageView= (LargeImageView) this.findViewById(R.id.largeimage);
        try {
            largeImageView.setInputStream(getAssets().open(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        largeImageView.onRecycle();

    }
}

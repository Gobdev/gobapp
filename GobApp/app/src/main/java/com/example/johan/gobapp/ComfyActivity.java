package com.example.johan.gobapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ComfyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfy);
        final ComfyActivity comfy_activity = this;
        findViewById(R.id.comfyMainLayout).setOnTouchListener(new OnSwipeTouchListener(ComfyActivity.this) {
            public void onSwipeRight() {
                comfy_activity.finish();
            }
        });
    }
}

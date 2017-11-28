package com.example.johan.gobapp;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txt = findViewById(R.id.textView);
        final TabLayout tabWidget = findViewById(R.id.tabWidget);
        final ImageView imageView = findViewById(R.id.imageView);
        final Button comfy_button = findViewById(R.id.comfy_button);
        tabWidget.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        txt.setText(getResources().getString(R.string.description_left));
                        comfy_button.setVisibility(View.INVISIBLE);
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.goblet));
                        break;
                    case 1:
                        txt.setText(getResources().getString(R.string.description_center));
                        comfy_button.setVisibility(View.INVISIBLE);
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.king_gob));
                        break;
                    case 2:
                        txt.setText(getResources().getString(R.string.description_right));
                        comfy_button.setVisibility(View.VISIBLE);
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.comfy_gob));
                        break;
                }
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab){}
            @Override
            public void onTabUnselected(TabLayout.Tab tab){}
        });
        findViewById(R.id.mainLayout).setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeRight() {
                int i = tabWidget.getSelectedTabPosition();
                if (i > 0)
                    tabWidget.getTabAt(i - 1).select();
            }
            public void onSwipeLeft() {
                int i = tabWidget.getSelectedTabPosition();
                if (i < tabWidget.getTabCount() - 1)
                    tabWidget.getTabAt(i + 1).select();
            }
        });
    }

    public void showComf(View view) {
        Intent intent = new Intent(this, ComfyActivity.class);
        startActivity(intent);
    }

}

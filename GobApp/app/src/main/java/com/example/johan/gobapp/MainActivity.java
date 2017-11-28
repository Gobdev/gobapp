package com.example.johan.gobapp;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txt = findViewById(R.id.textView);
        final TabLayout tabWidget = findViewById(R.id.tabWidget);
        tabWidget.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        txt.setText(getResources().getString(R.string.description_left));
                        break;
                    case 1:
                        txt.setText(getResources().getString(R.string.description_center));
                        break;
                    case 2:
                        txt.setText(getResources().getString(R.string.description_right));
                        break;
                }
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab){}
            @Override
            public void onTabUnselected(TabLayout.Tab tab){}
        });
        findViewById(R.id.mainLayout).setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {}
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
            public void onSwipeBottom() {}
        });
    }
}

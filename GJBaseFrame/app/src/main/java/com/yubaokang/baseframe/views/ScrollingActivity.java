package com.yubaokang.baseframe.views;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yubaokang.baseframe.R;

public class ScrollingActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    float appBarHeight;
    Toolbar toolbar;
    ImageView img_bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final AppBarLayout app_bar = (AppBarLayout) findViewById(R.id.app_bar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        app_bar.addOnOffsetChangedListener(this);
        img_bg = (ImageView) findViewById(R.id.imageView);
        TextView tv_content = (TextView) findViewById(R.id.tv_content);
        tv_content.setText(R.string.app_name);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (appBarHeight == 0) {
            appBarHeight = appBarLayout.getHeight() - toolbar.getHeight();
        }
        img_bg.setAlpha(1 - Math.abs(verticalOffset / appBarHeight));
    }
}

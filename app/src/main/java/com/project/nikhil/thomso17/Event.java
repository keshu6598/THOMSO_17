package com.project.nikhil.thomso17;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

public class Event extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        CustomAdapter adapter = new CustomAdapter(getSupportFragmentManager());
       setupmenu();

        final Intent intent = getIntent();
        View rootLayout = findViewById(R.id.event_activity);


        //circular_reveal_utils circular_reveal_utils=new circular_reveal_utils(rootLayout,intent);


        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
    FlowingDrawer mflowing;
    private void setupmenu() {
        mflowing=(FlowingDrawer)findViewById(R.id.flowing_drawer_layout);
        mflowing.setTouchMode(ElasticDrawer.TOUCH_MODE_NONE);
        mflowing.setWillNotDraw(true);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Drawable drawable= getResources().getDrawable(R.drawable.menu);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Drawable newdrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap,48, 48, true));

        toolbar.setNavigationIcon(newdrawable);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mflowing.openMenu();
            }
        });
        //

        android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        floating_menu menu=(floating_menu)fm.findFragmentById(R.id.flowing_menu);

        if(menu==null){
            menu=new floating_menu();
            fm.beginTransaction().add(R.id.flowing_menu,menu).commit();
        }
    }

}



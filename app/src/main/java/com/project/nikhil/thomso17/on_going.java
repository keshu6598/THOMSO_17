package com.project.nikhil.thomso17;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class on_going extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedpreferences=this.getSharedPreferences(getString(R.string.pref_file),0);
        Gson gson=new Gson();
        String json=sharedpreferences.getString(getResources().getString(R.string.on_going),null);
        Type type=new TypeToken<ArrayList<event_object>>(){}.getType();
        ArrayList<event_object> list1=gson.fromJson(json,type);

       if(list1.size()>0) {
           setContentView(R.layout.activity_on_going);


           final Intent intent = getIntent();
           View rootLayout = findViewById(R.id.flowing_drawer_layout);

           setupmenu();
           circular_reveal_utils circular_reveal_utils=new circular_reveal_utils(rootLayout,intent);


           RecyclerView recyclerView = (RecyclerView) findViewById(R.id.layout_event_list);
           recyclerView.setHasFixedSize(true);
           final LinearLayoutManager mLayoutManager;
           mLayoutManager = new LinearLayoutManager(this);
           mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
           recyclerView.setLayoutManager(mLayoutManager);
           RecyclerView.Adapter mAdapter;
           mAdapter = new adapter_event_list(list1);
           recyclerView.setAdapter(mAdapter);
       }else {
           setContentView(R.layout.no_event);
       }
       }

    FlowingDrawer mflowing;
    private void setupmenu() {
        mflowing=(FlowingDrawer)findViewById(R.id.flowing_drawer_layout);
        mflowing.setTouchMode(ElasticDrawer.TOUCH_MODE_FULLSCREEN);

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

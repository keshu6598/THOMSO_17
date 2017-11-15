package com.project.nikhil.thomso17;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

public class carnival_events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnival_events);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setupmenu();

        TextView melodies=(TextView)findViewById(R.id.carnival_melodies);
        TextView mass=(TextView)findViewById(R.id.carnival_mass);
        TextView solo=(TextView)findViewById(R.id.carnival_solo);
        TextView amus=(TextView)findViewById(R.id.carnival_amusement);

        Typeface face1 = Typeface.createFromAsset(getAssets(),
                "fonts/prashant.ttf");
        Typeface face2 = Typeface.createFromAsset(getAssets(),
                "fonts/gaurav.ttf");

        mass.setTypeface(face1);
        melodies.setTypeface(face1);
        solo.setTypeface(face1);
        amus.setTypeface(face1);

        TextView t1=(TextView)findViewById(R.id.t_1);
        t1.setTypeface(face2);
        TextView t2=(TextView)findViewById(R.id.t_2);
        t2.setTypeface(face2);
        TextView t3=(TextView)findViewById(R.id.t_3);
        TextView t4=(TextView)findViewById(R.id.t_4);
        TextView t5=(TextView)findViewById(R.id.t_5);
        TextView t6=(TextView)findViewById(R.id.t_6);
        TextView t7=(TextView)findViewById(R.id.t_7);
        TextView t8=(TextView)findViewById(R.id.t_8);
        TextView t9=(TextView)findViewById(R.id.t_9);
        TextView t10=(TextView)findViewById(R.id.t_10);
        TextView t11=(TextView)findViewById(R.id.t_11);
        TextView t12=(TextView)findViewById(R.id.t_12);
        TextView t13=(TextView)findViewById(R.id.t_13);
        TextView t14=(TextView)findViewById(R.id.t_14);
        TextView t15=(TextView)findViewById(R.id.t_15);
        TextView t16=(TextView)findViewById(R.id.t_16);

        t3.setTypeface(face2);
        t4.setTypeface(face2);
        t5.setTypeface(face2);
        t6.setTypeface(face2);
        t7.setTypeface(face2);
        t8.setTypeface(face2);
        t9.setTypeface(face2);
        t10.setTypeface(face2);
        t11.setTypeface(face2);
        t12.setTypeface(face2);
        t13.setTypeface(face2);
        t14.setTypeface(face2);
        t15.setTypeface(face2);
        t16.setTypeface(face2);



        final Intent intent = getIntent();
        View rootLayout = findViewById(R.id.flowing_drawer_layout);


        circular_reveal_utils circular_reveal_utils=new circular_reveal_utils(rootLayout,intent);

    }
    public void openCallLog(View v1)
    {
        Intent i = new Intent(Intent.ACTION_DIAL);
        String p = "tel:+919557945420";
        i.setData(Uri.parse(p));
        startActivity(i);
    }
    public void openGoogleMaps(View v1)
    {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=29.8692931,77.89617780000003&mode=w" );
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
    FlowingDrawer mflowing;
    private void setupmenu() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mflowing=(FlowingDrawer)findViewById(R.id.flowing_drawer_layout);
        mflowing.setTouchMode(ElasticDrawer.TOUCH_MODE_FULLSCREEN);
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

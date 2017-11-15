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
import android.widget.Button;
import android.widget.TextView;

import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

public class workshops extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops);
      setupmenu();
        final Intent intent = getIntent();
        View rootLayout = findViewById(R.id.flowing_drawer_layout);

        Typeface face1 = Typeface.createFromAsset(getAssets(),
                "fonts/prashant.ttf");
        Typeface face2 = Typeface.createFromAsset(getAssets(),
                "fonts/gaurav.ttf");


        Button t1=(Button)findViewById(R.id.t_1);
        t1.setTypeface(face2);
        Button t2=(Button)findViewById(R.id.t_2);
        t2.setTypeface(face2);
        Button t3=(Button)findViewById(R.id.t_3);
        Button t4=(Button)findViewById(R.id.t_4);
        Button t5=(Button)findViewById(R.id.t_5);
        Button t6=(Button)findViewById(R.id.t_6);
        Button t7=(Button)findViewById(R.id.t_7);
        Button t8=(Button)findViewById(R.id.t_8);
        Button t9=(Button)findViewById(R.id.t_9);
        Button t10=(Button)findViewById(R.id.t_10);
        t3.setTypeface(face2);
        t4.setTypeface(face2);
        t5.setTypeface(face2);
        t6.setTypeface(face2);
        t7.setTypeface(face2);
        t8.setTypeface(face2);
        t9.setTypeface(face2);
        t10.setTypeface(face2);

        TextView c0=(TextView)findViewById(R.id.c_0);
        c0.setTypeface(face1);

        TextView c1=(TextView)findViewById(R.id.c_1);
        c1.setTypeface(face1);
        TextView c2=(TextView)findViewById(R.id.c_2);
        c2.setTypeface(face1);
        TextView c3=(TextView)findViewById(R.id.c_3);
        TextView c4=(TextView)findViewById(R.id.c_4);
        TextView c5=(TextView)findViewById(R.id.c_5);
        c3.setTypeface(face2);
        c4.setTypeface(face2);
        c5.setTypeface(face2);

        circular_reveal_utils circular_reveal_utils=new circular_reveal_utils(rootLayout,intent);


    }
    public void paynow(View v1)
    {
        Uri uriUrl = Uri.parse("https://www.townscript.com/e/workshop-011102");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void rulebookethical(View v1)
    {
        Uri uriUrl = Uri.parse("http://thomso.in/pdf/workshops/hack.pdf");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void rulebookrobot(View v1)
    {
        Uri uriUrl = Uri.parse("http://thomso.in/pdf/workshops/robotics.pdf");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void rulebookengine(View v1)
    {
        Uri uriUrl = Uri.parse("http://thomso.in/pdf/workshops/automobile.pdf");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void rulebookapp(View v1)
    {
        Uri uriUrl = Uri.parse("http://thomso.in/pdf/workshops/aad.pdf");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void rulebookmarket(View v1)
    {
        Uri uriUrl = Uri.parse("http://thomso.in/pdf/workshops/digital_marketing.pdf");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
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

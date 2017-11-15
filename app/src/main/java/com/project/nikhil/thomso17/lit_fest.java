package com.project.nikhil.thomso17;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

public class lit_fest extends AppCompatActivity {
    Button button[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lit_fest);
        final Intent intent = getIntent();
        View rootLayout = findViewById(R.id.flowing_drawer_layout);


        circular_reveal_utils circular_reveal_utils=new circular_reveal_utils(rootLayout,intent);

        Typeface face1 = Typeface.createFromAsset(getAssets(),
                "fonts/prashant.ttf");

        setupmenu();
        Button button[] = new Button[10];
        button[0] = (Button) findViewById(R.id.btx1);
        button[1] = (Button) findViewById(R.id.btx2);
        button[2] = (Button) findViewById(R.id.btx3);
        button[3] = (Button) findViewById(R.id.btx4);
        button[4] = (Button) findViewById(R.id.btx5);
        button[5] = (Button) findViewById(R.id.btx6);
        button[6] = (Button) findViewById(R.id.btx7);
        button[7] = (Button) findViewById(R.id.btx8);
        button[8] = (Button) findViewById(R.id.btx9);
        button[9] = (Button) findViewById(R.id.btx10);
        for (int i = 0; i < 10; i++) {
            button[i].setText(getResources().getStringArray(R.array.Lit_fest_event_Title)[i]);
            button[i].setTypeface(face1);
        }

    }

    public void onClickButton(View view) {
        switch (view.getId()) {

            case R.id.btx1:
                Intent i = new Intent(lit_fest.this, event_overview.class);
                event_object object=new event_object("",getResources().getStringArray(R.array.Lit_fest_event_Title)[0],"Lecture Hall Complex","","","29.8649204","77.8938002","Aman","7464812987",
                        getResources().getStringArray(R.array.lit_fest_content)[0],"","","");
                i.putExtra("describe",object);
                startActivity(i);
                break;
            case R.id.btx2:
                Intent i2 =  new Intent(lit_fest.this, event_overview.class);
                event_object object2=new event_object("",getResources().getStringArray(R.array.Lit_fest_event_Title)[1],"Lecture Hall Complex","","","29.8649204","77.8938002","Prasannadeep Das","7014052990",
                        getResources().getStringArray(R.array.lit_fest_content)[1],"","","");
                i2.putExtra("describe",object2);
                startActivity(i2);
                break;
            case R.id.btx3:
                Intent i3= new Intent(lit_fest.this, event_overview.class);
                event_object object3=new event_object("",getResources().getStringArray(R.array.Lit_fest_event_Title)[2],"Lecture Hall Complex","","","29.8649204","77.8938002","Pragati","8650797430",
                        getResources().getStringArray(R.array.lit_fest_content)[2],"","","");
                i3.putExtra("describe",object3);
                startActivity(i3);
                break;
            case R.id.btx4:
                Intent i4 = new Intent(lit_fest.this, event_overview.class);
                event_object object4=new event_object("",getResources().getStringArray(R.array.Lit_fest_event_Title)[3],"Lecture Hall Complex","","","29.8649204","77.8938002","Kritika","8126044156",
                        getResources().getStringArray(R.array.lit_fest_content)[3],"","","");
                i4.putExtra("describe",object4);
                startActivity(i4);
                break;
            case R.id.btx5:
                Intent i5 =  new Intent(lit_fest.this, event_overview.class);
                event_object object5=new event_object("",getResources().getStringArray(R.array.Lit_fest_event_Title)[4],"Lecture Hall Complex","","","29.8649204","77.8938002","Prakhar Mishra","9458400993",
                        getResources().getStringArray(R.array.lit_fest_content)[4],"","","");
                i5.putExtra("describe",object5);
                startActivity(i5);
                break;
            case R.id.btx6:
                Intent i6 = new Intent(lit_fest.this, event_overview.class);
                event_object object6=new event_object("",getResources().getStringArray(R.array.Lit_fest_event_Title)[5],"Lecture Hall Complex","","","29.8649204","77.8938002","Agastya Raj","8266057084",
                        getResources().getStringArray(R.array.lit_fest_content)[5],"","","");
                i6.putExtra("describe",object6);
                startActivity(i6);
                break;
            case R.id.btx7:
                Intent i7 = new Intent(lit_fest.this, event_overview.class);
                event_object object7=new event_object("",getResources().getStringArray(R.array.Lit_fest_event_Title)[6],"Lecture Hall Complex","","","29.8649204","77.8938002","Agastya Raj","8266057084",
                        getResources().getStringArray(R.array.lit_fest_content)[6],"","","");
                i7.putExtra("describe",object7);
                startActivity(i7);
                break;
            case R.id.btx8:
                Intent i8 = new Intent(lit_fest.this, event_overview.class);
                event_object object8=new event_object("",getResources().getStringArray(R.array.Lit_fest_event_Title)[7],"Lecture Hall Complex","","","29.8649204","77.8938002","Siddharth","8006466319",
                        getResources().getStringArray(R.array.lit_fest_content)[7],"","","");
                i8.putExtra("describe",object8);
                startActivity(i8);
                break;
            case R.id.btx9:
                Intent i9 =  new Intent(lit_fest.this, event_overview.class);
                event_object object9=new event_object("",getResources().getStringArray(R.array.Lit_fest_event_Title)[8],"Lecture Hall Complex","","","29.8649204","77.8938002","Agastya Raj","8266057084",
                        getResources().getStringArray(R.array.lit_fest_content)[8],"","","");
                i9.putExtra("describe",object9);
                startActivity(i9);
                break;
            case R.id.btx10:
                Intent i10 =  new Intent(lit_fest.this, event_overview.class);
                event_object object10=new event_object("",getResources().getStringArray(R.array.Lit_fest_event_Title)[9],"Lecture Hall Complex","","","29.8649204","77.8938002","Agastya Raj","8266057084",
                        getResources().getStringArray(R.array.lit_fest_content)[9],"","","");
                i10.putExtra("describe",object10);
                startActivity(i10);
                break;

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

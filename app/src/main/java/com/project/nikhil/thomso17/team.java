package com.project.nikhil.thomso17;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class team extends AppCompatActivity{

    String Response= "\n\n[\n   {\n      \"post\": \"Convener\",\n      \"members\": [\n         {\n            \"name\": \"Ashish Kaushik\",\n            \"contact\": \"+91-7073684256\",\n            \"class\": \"col-sm-offset-4 col-sm-4\",\n            \"email\": \"ashish@thomso.in\",\n            \"image\": \"ashish.jpg\"\n         }\n      ]\n   },\n   {\n      \"post\": \"Co-Convener\",\n      \"members\": [\n         {\n            \"name\": \"Ankit Mourya\",\n            \"contact\": \"+91-9557944407\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"ankitm@thomso.in\",\n            \"image\": \"ankitm.jpg\"\n         },\n         {\n            \"name\": \"Prakhar Kumar\",\n            \"contact\": \"+91-7737120024\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"prakhar@thomso.in\",\n            \"image\": \"prakhar.jpg\"\n         },\n         {\n            \"name\": \"Rohan Vadi\",\n            \"contact\": \"+91-9045900495\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"rohan@thomso.in\",\n            \"image\": \"rohan.jpg\"\n         }\n      ]\n   },\n   {\n      \"post\": \"Promotions\",\n      \"members\": [\n         {\n            \"name\": \"Ashutosh Choudhary\",\n            \"contact\": \"+91-7830656448\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"ashutosh@thomso.in\",\n            \"image\": \"ashutosh.jpg\"\n         },\n         {\n            \"name\": \"Jayesh Verma\",\n            \"contact\": \"+91-9782599110\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"jayesh@thomso.in\",\n            \"image\": \"jayesh.jpg\"\n         },\n         {\n            \"name\": \"Suyash Singh\",\n            \"contact\": \"+91-8417954805\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"suyash@thomso.in\",\n            \"image\": \"suyash.jpg\"\n         },\n         {\n            \"name\": \"Yashvardhan Agarwal\",\n            \"contact\": \"+91-9829811031\",\n            \"class\": \"col-sm-offset-4 col-sm-4\",\n            \"email\": \"yashvardhan@thomso.in\",\n            \"image\": \"yashwardhan.jpg\"\n         }\n      ]\n   },\n   {\n      \"post\": \"Sponsorship\",\n      \"members\": [\n         {\n            \"name\": \"Adarsh Goyal\",\n            \"contact\": \"+91-9509618336\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"adarsh@thomso.in\",\n            \"image\": \"adrash.jpg\"\n         },\n         {\n            \"name\": \"Ankur Shree\",\n            \"contact\": \"+91-9760826037\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"ankur@thomso.in\",\n            \"image\": \"ankur.jpg\"\n         },\n         {\n            \"name\": \"Tanmay Maheshwari\",\n            \"contact\": \"+91-7073384285\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"tanmay@thomso.in\",\n            \"image\": \"tanmay.jpg\"\n         },\n         {\n            \"name\": \"Karandeep Singh\",\n            \"contact\": \"+91-9780977866\",\n            \"class\": \"col-sm-offset-2 col-sm-4\",\n            \"email\": \"karandeep@thomso.in\",\n            \"image\": \"karan.jpg\"\n         },\n         {\n            \"name\": \"Samarth Gubrele\",\n            \"contact\": \"+91-8349146260\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"samarth@thomso.in\",\n            \"image\": \"samarhth.jpg\"\n         }\n      ]\n   },\n   {\n      \"post\": \"Events\",\n      \"members\": [\n         {\n            \"name\": \"Akshay Chattar\",\n            \"contact\": \"+91-9557945420\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"akshay@thomso.in\",\n            \"image\": \"akshay.jpg\"\n         },\n         {\n            \"name\": \"Ankit Singh\",\n            \"contact\": \"+91-7060947121\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"ankit@thomso.in\",\n            \"image\": \"ankit.jpg\"\n         },\n         {\n            \"name\": \"Agastya Raj\",\n            \"contact\": \"+91-8266057084\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"agastya@thomso.in\",\n            \"image\": \"agastya.jpg\"\n         },\n         {\n            \"name\": \"Ishita Singhal\",\n            \"contact\": \"+91-9760824054\",\n            \"class\": \"col-sm-offset-4 col-sm-4\",\n            \"email\": \"ishita@thomso.in\",\n            \"image\": \"ishita.jpg\"\n         }\n      ]\n   },\n   {\n      \"post\": \"Marketing\",\n      \"members\": [\n         {\n            \"name\": \"Mayank Ojha\",\n            \"contact\": \"+91-8793713914\",\n            \"class\": \"col-sm-offset-2 col-sm-4\",\n            \"email\": \"mayank@thomso.in\",\n            \"image\": \"mayank.jpg\"\n         },\n         {\n            \"name\": \"Yashwant Singh\",\n            \"contact\": \"+91-8447298820\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"yashwant@thomso.in\",\n            \"image\": \"yashwant.jpg\"\n         }\n      ]\n   },\n   {\n      \"post\": \"Design\",\n      \"members\": [\n         {\n            \"name\": \"Bibhudatta Sa\",\n            \"contact\": \"+91-8266057076\",\n            \"class\": \"col-sm-offset-2 col-sm-4\",\n            \"email\": \"bibhu@thomso.in\",\n            \"image\": \"bibhu.jpg\"\n         },\n         {\n            \"name\": \"Rajat Jain\",\n            \"contact\": \"+91-9424076413\",\n            \"class\": \"col-sm-4\",\n            \"email\": \"rajat@thomso.in\",\n            \"image\": \"rajat.jpg\"\n         }\n      ]\n   },\n   {\n      \"post\": \"Web Development\",\n      \"members\": [\n         {\n            \"name\": \"Piyush Vijay\",\n            \"contact\": \"+91-7417160751\",\n            \"class\": \"col-sm-offset-4 col-sm-4\",\n            \"email\": \"piyush@thomso.in\",\n            \"image\": \"piyush.jpg\"\n         }\n      ]\n   }\n]\n\n";


    ArrayList<team_member> list = new ArrayList<team_member>();

    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        setupmenu();
        final Intent inte = getIntent();
        View rootLayout = findViewById(R.id.flowing_drawer_layout);


        circular_reveal_utils circular_reveal_utils=new circular_reveal_utils(rootLayout,inte);

        try {
            JSONArray jarr = new JSONArray(Response);
            for (int i = 0; i < jarr.length(); i++) {
                JSONObject type = jarr.getJSONObject(i);
                String post = type.getString("post");
                JSONArray member = type.getJSONArray("members");

                for (int j = 0; j < member.length(); j++) {

                    JSONObject nikhil = member.getJSONObject(j);
                    String name = nikhil.getString("name");
                    String phone = nikhil.getString("contact");
                    String email = nikhil.getString("email");
                    String image = nikhil.getString("image");
                    list.add(new team_member(name, post,email, phone,image));
                }

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        set(list);


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



    private void set(ArrayList<team_member> earth) {

            recyclerView = (RecyclerView) findViewById(R.id.team_recycler);
            recyclerView.setHasFixedSize(true);
            final LinearLayoutManager mLayoutManager;
            mLayoutManager = new LinearLayoutManager(this);
            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new adapter_team_list(earth);
            recyclerView.setAdapter(mAdapter);
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




}

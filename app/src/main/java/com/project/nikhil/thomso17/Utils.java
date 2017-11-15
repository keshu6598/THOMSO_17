package com.project.nikhil.thomso17;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by nikhil on 11/10/17.
 */

public class Utils implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences sharedpreferences;

    public Activity activity;
    SharedPreferences.Editor editor;


    public Utils(Activity activity){

        this.activity=activity;
        sharedpreferences=activity.getApplicationContext().getSharedPreferences(activity.getResources().getString(R.string.pref_file),0);
        editor = sharedpreferences.edit();

    }

    public void for_navigation(NavigationView navigationView) {

        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);


        //NavigationView navigationView = (NavigationView)activity.findViewById(R.id.nav_view);

        View header=navigationView.getHeaderView(0);

        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(activity,Profile.class);
                    activity.startActivity(intent);
            }
        });
        Gson gson=new Gson();
        String json=sharedpreferences.getString(activity.getResources().getString(R.string.profile),null);
        Type type=new TypeToken<user>(){}.getType();
        user profile=gson.fromJson(json,type);

        TextView name=(TextView)header.findViewById(R.id.name_user);
        TextView id=(TextView)header.findViewById(R.id.id_user);
        TextView email=(TextView)header.findViewById(R.id.email_user);
        final CircleImageView pic=(CircleImageView) header.findViewById(R.id.image_user);

        name.setTextColor(Color.parseColor("#c59b5f"));

        name.setText(profile.getName().toString());
        id.setText(profile.getId().toString());
        email.setText(profile.getEmail().toString());


        Picasso picasso = Picasso.with(activity);


        picasso.load(activity.getResources().getString(R.string.base_url)+"upload/"+profile.getImage().toString()).error(R.drawable.user).into(pic);
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Events_nav) {
            Intent intent=new Intent(activity,Event.class);
            activity.startActivity(intent);
        } else if (id == R.id.Workshop_nav) {
            Intent intent=new Intent(activity,workshops.class);
            activity.startActivity(intent);
        } else if (id == R.id.carnival_nav) {
            Intent intent=new Intent(activity,carnival_events.class);
            activity.startActivity(intent);

        } else if (id == R.id.map_nav) {
            Intent intent=new Intent(activity,MapsActivity.class);
            activity.startActivity(intent);

        } else if (id == R.id.Team_nav) {
            Intent intent=new Intent(activity,team.class);
            activity.startActivity(intent);

        } else if (id == R.id.Developer_nav) {
            Intent intent=new Intent(activity,Event.class);
            activity.startActivity(intent);

        }

        return true;
    }


}

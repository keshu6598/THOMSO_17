package com.project.nikhil.thomso17;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.lang.reflect.Type;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sharedpreferences=getApplicationContext().getSharedPreferences(getResources().getString(R.string.pref_file),0);
        editor = sharedpreferences.edit();
        Gson gson=new Gson();
        String json=sharedpreferences.getString(getResources().getString(R.string.profile),null);
        Type type=new TypeToken<user>(){}.getType();
        user profile=gson.fromJson(json,type);
        ImageView view=(ImageView)findViewById(R.id.header_cover_image);
        Picasso.with(this).load(R.drawable.profile_header).into(view);

        TextView name=(TextView)findViewById(R.id.user_profile_name);
        TextView id=(TextView)findViewById(R.id.user_profile_id);
        TextView add=(TextView)findViewById(R.id.user_profile_address);
        TextView clg=(TextView)findViewById(R.id.user_profile_college);
        TextView mail=(TextView)findViewById(R.id.user_profile_email);
        TextView mob=(TextView)findViewById(R.id.user_profile_mob);
        TextView event=(TextView)findViewById(R.id.user_profile_event);
        TextView gender=(TextView)findViewById(R.id.user_profile_gender);
        CircleImageView pic=(CircleImageView) findViewById(R.id.user_profile_photo);

        name.setText(profile.getName());
        id.setText("Thomso ID: "+profile.getId());
        add.setText("Address: "+profile.getAddress());
        clg.setText("College: "+profile.getCollege());
        mob.setText("Contact: "+profile.getContact());
        mail.setText(profile.getEmail());
        gender.setText("Gender: "+profile.getGender());

        event.setText("Primary Event: "+profile.getEvent());
        Typeface face1 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/gaurav.ttf");
        Typeface face2 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/prashant.ttf");

        event.setTypeface(face1);
        name.setTypeface(face2);
        id.setTypeface(face1);
        add.setTypeface(face1);
        clg.setTypeface(face1);
        mail.setTypeface(face1);
        mob.setTypeface(face1);
        gender.setTypeface(face1);

        Picasso picasso = Picasso.with(this);


        picasso.load(getResources().getString(R.string.base_url)+"upload/"+profile.getImage().toString()).error(R.drawable.user).into(pic);


    }
}

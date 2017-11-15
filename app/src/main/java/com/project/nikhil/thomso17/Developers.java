package com.project.nikhil.thomso17;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;


public class Developers extends AppCompatActivity {
    CardView card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);



        TextView tv1 = (TextView) findViewById(R.id.namenikhil);
        Typeface face1 = Typeface.createFromAsset(getAssets(),
                "fonts/prashant.ttf");
        tv1.setTypeface(face1);
        TextView tv2 = (TextView) findViewById(R.id.numbernikhil);
        Typeface face2 = Typeface.createFromAsset(getAssets(),
                "fonts/gaurav.ttf");
        tv2.setTypeface(face2);
        TextView tv3 = (TextView) findViewById(R.id.emailnikhil);
        Typeface face3 = Typeface.createFromAsset(getAssets(),
                "fonts/gaurav.ttf");
        tv3.setTypeface(face3);
        TextView tv4 = (TextView) findViewById(R.id.namenkanishk);
        Typeface face4 = Typeface.createFromAsset(getAssets(),
                "fonts/prashant.ttf");
        tv4.setTypeface(face4);
        TextView tv5 = (TextView) findViewById(R.id.numberkanishk);
        Typeface face5 = Typeface.createFromAsset(getAssets(),
                "fonts/gaurav.ttf");
        tv5.setTypeface(face5);
        TextView tv6 = (TextView) findViewById(R.id.emailkanishk);
        Typeface face6 = Typeface.createFromAsset(getAssets(),
                "fonts/gaurav.ttf");
        tv6.setTypeface(face6);
    }
    public void facebooknikhil(View v1)
    {
        Uri uriUrl = Uri.parse("https://www.facebook.com/nikhil.agrawal.77582");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void githubnikhil(View v1)
    {
        Uri uriUrl = Uri.parse("https://github.com/nikhil5642");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void linkedinnikhil(View v1)
    {
        Uri uriUrl = Uri.parse("https://www.linkedin.com/in/nikhil-agrawal-27a560126/");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void facebookkanishk(View v1)
    {
        Uri uriUrl = Uri.parse("https://www.facebook.com/kanishk.khandelwal.sharele");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void githubkanishk(View v1)
    {
        Uri uriUrl = Uri.parse("https://github.com/keshu6598");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void linkedinkanishk(View v1)
    {
        Uri uriUrl = Uri.parse("https://www.linkedin.com/in/kanishk-khandelwal-1a1ab8137/");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void facebooktushar(View v1)
    {
        Uri uriUrl = Uri.parse("https://www.facebook.com/tushar2112");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}

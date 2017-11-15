package com.project.nikhil.thomso17;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import me.grantland.widget.AutofitTextView;

public class event_overview extends AppCompatActivity {

    event_object object;
    TextView des,time,venue,coord,coord_no;
    AutofitTextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_overview);

        Intent intent=getIntent();
        object= (event_object) intent.getSerializableExtra("describe");
        name=(AutofitTextView) findViewById(R.id.event_overview_name);
        des=(TextView)findViewById(R.id.event_overview_descr);
        time=(TextView)findViewById(R.id.event_overview_time);
        venue=(TextView)findViewById(R.id.event_overview_location);
        coord=(TextView)findViewById(R.id.event_overview_coord);
        coord_no=(TextView)findViewById(R.id.event_overview_coord_no);



        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/prashant.ttf");
        name.setTypeface(face);
        Typeface face1 = Typeface.createFromAsset(getAssets(),
                "fonts/gaurav.ttf");
        des.setTypeface(face1);
        Typeface face2 = Typeface.createFromAsset(getAssets(),
                "fonts/gaurav.ttf");
        time.setTypeface(face2);
        Typeface face3 = Typeface.createFromAsset(getAssets(),
                "fonts/gaurav.ttf");
        venue.setTypeface(face3);
        Typeface face4 = Typeface.createFromAsset(getAssets(),
                "fonts/gaurav.ttf");
        coord.setTypeface(face4);
        Typeface face5 = Typeface.createFromAsset(getAssets(),
                "fonts/gaurav.ttf");
        coord_no.setTypeface(face5);




      name.setText(object.getName());
        des.setText(object.getDescription());
        time.setText("Timing:  "+object.getStart_time()+"-"+object.getEnd_time());
        venue.setText("Location:   "+object.getVenue());
        coord.setText("Coordinator:   "+object.getCoord());
        coord_no.setText("Contact:   "+object.getCoord_no());

    }

    public void openCallLog(View v1)
    {
        Intent i = new Intent(Intent.ACTION_DIAL);
        String p = "tel:"+object.getCoord_no();
        i.setData(Uri.parse(p));
        startActivity(i);
    }
    public void openGoogleMaps(View v1)
    {
        Uri gmmIntentUri = Uri.parse("google.navigation:q="+object.getLat().toString()+","+object.getLng().toString()+"&mode=w" );
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}

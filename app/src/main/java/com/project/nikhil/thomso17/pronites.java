package com.project.nikhil.thomso17;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class pronites extends AppCompatActivity {
    private static String register_url;
ArrayList<pronite> list=new ArrayList<pronite>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pronites);
        register_url = getResources().getString(R.string.base_url) + "api/main/get_pronites";
        final Intent intent = getIntent();
        View rootLayout = findViewById(R.id.flowing_drawer_layout);


        circular_reveal_utils circular_reveal_utils=new circular_reveal_utils(rootLayout,intent);

        pronites.Async task=new pronites.Async();
        task.execute();
        setupmenu();

    }



    public URL create(String str) {
        URL url = null;
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            return null;
        }
        return url;
    }
    public class Async extends AsyncTask<URL, Void, String> {
        String pro;
        String jsonResponse = "";
        ProgressDialog progressDialog = new ProgressDialog(pronites.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Processing...");
            progressDialog.show();
        }


        @Override
        protected String doInBackground(URL... params) {
            URL url = create(register_url);
            try {
                jsonResponse = make_profile_HttpRequest(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonResponse;

        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            pronite first=extact_pronite(jsonResponse,"first");
            pronite second=extact_pronite(jsonResponse,"second");
            pronite third=extact_pronite(jsonResponse,"third");
            pronite fourth=extact_pronite(jsonResponse,"fourth");

            list.add(first);
            list.add(second);
            list.add(third);
            list.add(fourth);

           if(first!=null) {
               RecyclerView recyclerView = (RecyclerView) findViewById(R.id.layout_pronite);
               recyclerView.setHasFixedSize(true);
               final LinearLayoutManager mLayoutManager;
               mLayoutManager = new LinearLayoutManager(pronites.this);
               mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
               recyclerView.setLayoutManager(mLayoutManager);
               RecyclerView.Adapter mAdapter;
               mAdapter = new adapter_pronite(list);
               recyclerView.setAdapter(mAdapter);
               progressDialog.dismiss();

           }else {
               progressDialog.dismiss();
               Toast.makeText(getApplicationContext(),"Connection Problem",Toast.LENGTH_LONG).show();
               finish();

           }
        }



    }

    private pronite extact_pronite(String jsonResponse,String d) {
        pronite temp=null;

        try {
            JSONObject jobj=new JSONObject(jsonResponse);
            JSONObject dates=jobj.getJSONObject("data");
            JSONObject event=dates.getJSONObject(d);

            String day=event.getString("day");
            String date=event.getString("date");
            String name=event.getString("name");
            Log.e("error",jsonResponse);

            String artist=event.getString("artist");
            String description=event.getString("description");
            String venue=event.getString("venue");
            String image=event.getString("image");
            String time=event.getString("time");

            temp=new pronite(day,date,name,artist,description,venue,image,time);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return temp;
    }

    private String readfromstream(InputStream inputStream) throws IOException {
            StringBuilder output = new StringBuilder();
            if (inputStream != null) {
                InputStreamReader inputstreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputstreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            }
            return output.toString();
        }


        public String make_profile_HttpRequest(URL url) throws IOException {
            String jsonResponse = "";
            HttpURLConnection httpURLConnection = null;
            InputStream inputStream = null;
            try {

                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.connect();

                inputStream = httpURLConnection.getInputStream();
                jsonResponse = readfromstream(inputStream);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                } else {
                }
                if (inputStream != null) {
                    inputStream.close();
                }

            }
            return jsonResponse;
        }

        FlowingDrawer mflowing;

        private void setupmenu() {
            mflowing = (FlowingDrawer) findViewById(R.id.flowing_drawer_layout);
            mflowing.setTouchMode(ElasticDrawer.TOUCH_MODE_FULLSCREEN);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            Drawable drawable = getResources().getDrawable(R.drawable.menu);
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Drawable newdrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 48, 48, true));

            toolbar.setNavigationIcon(newdrawable);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mflowing.openMenu();
                }
            });
            //

            android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
            floating_menu menu = (floating_menu) fm.findFragmentById(R.id.flowing_menu);

            if (menu == null) {
                menu = new floating_menu();
                fm.beginTransaction().add(R.id.flowing_menu, menu).commit();
            }


        }


}

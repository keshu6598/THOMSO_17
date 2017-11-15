package com.project.nikhil.thomso17;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import static android.view.ViewAnimationUtils.createCircularReveal;


public class registered_events extends AppCompatActivity {
    //  Animation anim;
    CoordinatorLayout constraintLayout;
    private static String register_url;

    String token;
    View rootLayout;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_events);
        sharedpreferences = getApplicationContext().getSharedPreferences(getString(R.string.pref_file), 0);
        token = sharedpreferences.getString(getResources().getString(R.string.user_token), null);
        register_url = getResources().getString(R.string.base_url) + "api/main/get_user_events";
        setupmenu();

        final Intent intent = getIntent();
        View rootLayout = findViewById(R.id.flowing_drawer_layout);

        circular_reveal_utils circular_reveal_utils = new circular_reveal_utils(rootLayout, intent);

        registered_events.Async task = new registered_events.Async();
        task.execute();

    }

    public class Async extends AsyncTask<URL, Void, String> {
        String pro;
        String jsonResponse = "";
        ProgressDialog progressDialog = new ProgressDialog(registered_events.this);

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
        protected void onPostExecute(String account) {

            Gson gson = new Gson();
            String json1 = sharedpreferences.getString(getResources().getString(R.string.day_1), null);
            String json2 = sharedpreferences.getString(getResources().getString(R.string.day_2), null);
            String json3 = sharedpreferences.getString(getResources().getString(R.string.day_3), null);
            Type type = new TypeToken<ArrayList<event_object>>() {
            }.getType();
            ArrayList<event_object> list = gson.fromJson(json1, type);
            ArrayList<event_object> list2 = gson.fromJson(json2, type);
            ArrayList<event_object> list3 = gson.fromJson(json3, type);
            list.addAll(list2);
            list.addAll(list3);

            String sel = " ";
            try {
                JSONObject jsonObject = new JSONObject(jsonResponse);
                JSONArray jsonArray = jsonObject.getJSONArray("result");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    sel += obj.getString("event") + " ";
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            ArrayList<event_object> final_list = new ArrayList<event_object>();
            for (int j = 0; j < list.size(); j++) {

                if (sel.contains(list.get(j).getId())) {
                    final_list.add(list.get(j));
                }

            }

            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.team_recycler);
            recyclerView.setHasFixedSize(true);
            final LinearLayoutManager mLayoutManager;
            mLayoutManager = new LinearLayoutManager(registered_events.this);
            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(mLayoutManager);
            RecyclerView.Adapter mAdapter;
            mAdapter = new adapter_event_list(final_list);
            recyclerView.setAdapter(mAdapter);

            progressDialog.dismiss();

        }

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
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Authorisation", token);


            httpURLConnection.setReadTimeout(1000000);
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

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        floating_menu menu = (floating_menu) fm.findFragmentById(R.id.flowing_menu);

        if (menu == null) {
            menu = new floating_menu();
            fm.beginTransaction().add(R.id.flowing_menu, menu).commit();
        }


    }
}

/*
    @Override
    public void onWindowFocusChanged (boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
            constraintLayout.startAnimation(anim);
    }   }
*/
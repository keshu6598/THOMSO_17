package com.project.nikhil.thomso17;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.LOCATION_HARDWARE;
import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {


    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;
    private static String login_url,profile_url;
    private EditText mEmailView;
    TextView skip,register;
    private EditText mPasswordView;
    String urlparameter="";
    Context context;
    String token;

    SharedPreferences sharedpreferences;
    user usr;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        login_url=getResources().getString(R.string.base_url)+"api/login_user";
        profile_url=getResources().getString(R.string.base_url)+"api/main/get_user_info";

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);

        sharedpreferences=getApplicationContext().getSharedPreferences(getString(R.string.pref_file),0);
        editor = sharedpreferences.edit();

         skip=(TextView)findViewById(R.id.skip);

        skip.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                finish();
                startActivity(intent);

            }
        });

        if(checkpref()){
            String name = sharedpreferences.getString(getResources().getString(R.string.user_name),null);
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            finish();
            startActivity(intent);
        };

        AppCompatButton mEmailSignInButton = (AppCompatButton) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            urlparameter="email="+ mEmailView.getText().toString()+'&'+
                        "password="+ mPasswordView.getText().toString();

            if(isEmailValid(mEmailView.getText().toString())) {
                Submit();
            }else if (!isEmailValid(mEmailView.getText().toString())){
                Toast.makeText(LoginActivity.this,"Please enter a valid E-mail ",Toast.LENGTH_SHORT).show();
            }
            }
        });

    }

    private Boolean checkpref() {
        Boolean auth = sharedpreferences.getBoolean(getResources().getString(R.string.user_auth),false);
        return auth;
    }


    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


    public void Submit(){
  LoginActivity.loginAsync accountAsync=new LoginActivity.loginAsync();
        accountAsync.execute();
    }

    public class loginAsync extends AsyncTask<URL,Void,String> {
        String pro;
        String jsonResponse="";
        ProgressDialog progressDialog=new ProgressDialog(LoginActivity.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Processing...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(URL... params) {
            URL url = create(login_url);
            try {
                jsonResponse = makeHttpRequest(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return jsonResponse;
        }


        @Override
        protected void onPostExecute(String account) {

            String tok=extract_auth(jsonResponse);
            if(tok!=null){
                token=tok;
                LoginActivity.infoAsync infoAsync=new LoginActivity.infoAsync();
                infoAsync.execute();
                progressDialog.dismiss();

            }else {
            editor.clear();
            editor.commit();
            progressDialog.dismiss();

                Toast.makeText(LoginActivity.this,"Please Enter the correct credentials/Check your Internet Connection",Toast.LENGTH_LONG).show();

            }
        }

    }

    public URL create(String str){
        URL url=null;
        try {
            url=new URL(str);
        } catch (MalformedURLException e) {
            return null;
        }
        return url;
    }
    public String makeHttpRequest(URL url) throws IOException {
        String jsonResponse="";
        HttpURLConnection httpURLConnection=null;
        InputStream inputStream=null;
        try {

            httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");



            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(1000000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.connect();

            DataOutputStream wr=new DataOutputStream(httpURLConnection.getOutputStream());
            wr.write(urlparameter.getBytes());
            wr.flush();
            wr.close();

            inputStream=httpURLConnection.getInputStream();
            jsonResponse=readfromstream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }else{
            }
            if(inputStream!=null){
                inputStream.close();
            }

        }
        return jsonResponse;
    }

    private String readfromstream(InputStream inputStream) throws IOException {
        StringBuilder output=new StringBuilder();
        if(inputStream!=null){
            InputStreamReader inputstreamReader=new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader=new BufferedReader(inputstreamReader);
            String line=reader.readLine();
            while (line!=null){
                output.append(line);
                line=reader.readLine();
            }
        }
        return output.toString();
    }

    public String extract_auth(String json) {
        String tok=null;
        try {
            JSONObject object = new JSONObject(json);
            String auth=object.getString("is_authenticated");
            if(auth.contains("t")){
                tok=object.getString("token");
            }

        } catch (JSONException e1) {
            e1.printStackTrace();
        }
  return tok;
    }







    public class infoAsync extends AsyncTask<URL,Void,String> {
        String pro;
        String jsonResponse="";

        @Override
        protected String doInBackground(URL... params) {
            URL url = create(profile_url);
            try {
                jsonResponse = make_profile_HttpRequest(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonResponse;
        }


        @Override
        protected void onPostExecute(String account) {

            user nikhil=extract_profile(jsonResponse);
            if(nikhil!=null){
                Gson gson=new Gson();
                String json=gson.toJson(nikhil);

                editor.putBoolean(getResources().getString(R.string.user_auth),true);
                editor.putString(getResources().getString(R.string.profile),json);
                editor.commit();
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                finish();
                startActivity(intent);
            }else {
                editor.clear();
                editor.commit();
                Toast.makeText(LoginActivity.this,"Please Enter the correct credentials/Check your Internet Connection",Toast.LENGTH_LONG).show();

            }
        }

    }
    public user extract_profile(String json) {
        user us=null;

        try {
            JSONObject object = new JSONObject(json);
            JSONObject result=object.getJSONObject("result");
            String address=result.getString("address");
            String college=result.getString("college");
            String contact=result.getString("contact");
            String email=result.getString("email");
            String gender=result.getString("gender");
            String name=result.getString("name");
            String image_status=result.getString("image_status");
            String id=result.getString("id");
            String event=result.getString("event");
            us=new user(token,address,college,contact,email,gender,name,image_status,event,"TH"+id);

        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        usr=us;
        return us;
    }

    public String make_profile_HttpRequest(URL url) throws IOException {
        String jsonResponse="";
        HttpURLConnection httpURLConnection=null;
        InputStream inputStream=null;
        try {

            httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Authorisation",token);


            httpURLConnection.setReadTimeout(1000000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.connect();

            inputStream=httpURLConnection.getInputStream();
            jsonResponse=readfromstream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }else{
            }
            if(inputStream!=null){
                inputStream.close();
            }

        }
        return jsonResponse;
    }

}


package com.project.nikhil.thomso17;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class Day2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_day, container, false);
        SharedPreferences sharedpreferences=this.getActivity().getSharedPreferences(getString(R.string.pref_file),0);
        Gson gson=new Gson();
        String json=sharedpreferences.getString(getResources().getString(R.string.day_2),null);
        Type type=new TypeToken<ArrayList<event_object>>(){}.getType();
        ArrayList<event_object> list1=gson.fromJson(json,type);



        RecyclerView recyclerView=(RecyclerView)v.findViewById(R.id.layout_event_list);
        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager mLayoutManager;
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter mAdapter;
        mAdapter=new adapter_event_list(list1);
        recyclerView.setAdapter(mAdapter);



        return v;}

}

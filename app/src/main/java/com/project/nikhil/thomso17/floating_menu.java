package com.project.nikhil.thomso17;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mxn.soul.flowingdrawer_core.FlowingDrawer;


public class floating_menu extends Fragment implements NavigationView.OnNavigationItemSelectedListener{

    SharedPreferences sharedpreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_floating_menu, container, false);

        sharedpreferences=getContext().getSharedPreferences(getString(R.string.pref_file),0);

        NavigationView navigationView=(NavigationView)view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Utils utils=new Utils(getActivity());
      if(sharedpreferences.getBoolean(getResources().getString(R.string.user_auth),false)) {
          utils.for_navigation(navigationView);
      }
    return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)  {
    int id = item.getItemId();

        if (id == R.id.Events_nav) {
        Intent intent=new Intent(getActivity(),Event.class);
        startActivity(intent);
    } else if (id == R.id.Workshop_nav) {
        Intent intent=new Intent(getActivity(),workshops.class);
        startActivity(intent);
    } else if (id == R.id.carnival_nav) {
        Intent intent=new Intent(getActivity(),carnival_events.class);
        startActivity(intent);

    } else if (id == R.id.map_nav) {
        Intent intent=new Intent(getActivity(),MapsActivity.class);
        startActivity(intent);

    } else if (id == R.id.Team_nav) {
        Intent intent=new Intent(getActivity(),team.class);
        startActivity(intent);

    } else if (id == R.id.Developer_nav) {
        Intent intent=new Intent(getActivity(),Developers.class);
        startActivity(intent);

    }else if (id == R.id.spons_nav) {
            String url=getResources().getString(R.string.base_url)+"sponsors";
            CustomTabsIntent.Builder builder=new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent=builder.build();
            customTabsIntent.launchUrl(getActivity(), Uri.parse(url));
            builder.setToolbarColor(R.color.grey);

        } else if (id == R.id.litfest_nav) {
            Intent intent=new Intent(getActivity(),lit_fest.class);
            startActivity(intent);

        }else if (id == R.id.payment_nav) {
            String url=getResources().getString(R.string.base_url)+"payment";
            CustomTabsIntent.Builder builder=new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent=builder.build();
            customTabsIntent.launchUrl(getActivity(), Uri.parse(url));
            builder.setToolbarColor(R.color.grey);

        }


        FlowingDrawer drawer = (FlowingDrawer) getActivity().findViewById(R.id.flowing_drawer_layout);
        drawer.closeMenu();
  if(!getActivity().getClass().equals(MainActivity.class)){
      getActivity().finish();
  }

  {
      return true;
  }

}
}

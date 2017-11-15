package com.project.nikhil.thomso17;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static double lon = 0.0;
    private List<MarkerValue> eventList = new ArrayList<>();
    private List<MarkerValue> eateriesList = new ArrayList<>();
    private List<MarkerValue> accomodationList = new ArrayList<>();
    private List<MarkerValue> atmlist = new ArrayList<>();
    private List<MarkerValue> hospitallist = new ArrayList<>();

    private GoogleMap mMap;
    MarkerOptions hospital;
    private final static int MY_PERMISSION_FINE_LOCATION =101;

    static final CameraPosition IITR = CameraPosition.builder()
            .target(new LatLng(29.8649, 77.8966)).zoom(16).bearing(0).tilt(30).build();

    @Override
    public Resources getResources() {
        return super.getResources();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);

        //MarkerValue hospital = new MarkerValue(29.8619,77.8932,1);

        //hospital =new MarkerOptions().position(new LatLng(29.8619,77.8932)).title("IIT Roorkee Hospital");
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    /*private Location getLastKnownLocation() {
        LocationManager mLocationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
        List<String> providers = mLocationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = mLocationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                bestLocation = l;
            }
        }
        return bestLocation;
    }*/
    @Override
    public void onMapReady(GoogleMap googleMap) {
        HashMap<String, List<List<Double>>> listHashMap = new HashMap<>();
        String str = "Toilet";
        List<Double> list = new ArrayList<>();
        list.add(26.8647356);
        list.add(332865.839658);
        hospital = new MarkerOptions().position(new LatLng(29.8619, 77.8932)).title("IIT Roorkee Hospital");
        mMap = googleMap;
        mMap.isTrafficEnabled();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        }
        else
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},MY_PERMISSION_FINE_LOCATION);
            }
        }



        //mMap.addMarker(hospital);
        flyTO(IITR);
        eventList.add(new MarkerValue(new LatLng(29.868055,77.891121), "Convocation Hall"));
        eventList.add(new MarkerValue(new LatLng(29.865414273786584,77.88941591978073), "Main Gate"));
        eventList.add(new MarkerValue(new LatLng(29.8649204,77.89380019999999), "Lecture Hall Complex(LHC)"));
        eventList.add(new MarkerValue(new LatLng(29.8646738,77.89483530000007), "DOMS"));
        eventList.add(new MarkerValue(new LatLng(29.8652785,77.89478239999994), "Central Library"));
        eventList.add(new MarkerValue(new LatLng(29.87017,77.89587600000004), "Alaknanda Unit"));
        eventList.add(new MarkerValue(new LatLng(29.870201077123927,77.89620995521545), "Multi Activity Center (MAC)"));
        eventList.add(new MarkerValue(new LatLng(29.863737210131376,77.89465427398682), "Student Club and UG Floor"));
        eventList.add(new MarkerValue(new LatLng(29.86329289999999,77.89466909999999), "Hobbies Club"));
        eventList.add(new MarkerValue(new LatLng(29.8670887,77.89750570000001), "Open Air Theatre (OAT)"));
        eventList.add(new MarkerValue(new LatLng(29.8692931,77.89617780000003), "ABN Ground"));
        eventList.add(new MarkerValue(new LatLng(29.8682626,77.89768430000004), "Saraswati Mandir"));
        eventList.add(new MarkerValue(new LatLng(29.8673198,77.8956753), "LBS Ground"));
        eventList.add(new MarkerValue(new LatLng(29.86322,77.89480479999997), "Ravindra Lounge"));
        eventList.add(new MarkerValue(new LatLng(29.8630789,77.89883320000001), "OP Jain Auditorium"));
        eventList.add(new MarkerValue(new LatLng(29.8645778,77.89564769999993), "SBI Lawn"));
        eventList.add(new MarkerValue(new LatLng(29.8623706,77.89581399999997), "Bose Auditorium"));
        eventList.add(new MarkerValue(new LatLng(29.86476299027784,77.89594039320946), "Senate Hall"));
        eventList.add(new MarkerValue(new LatLng(29.86684720000001,77.89356909999992), "Chemical Auditorium"));
        eventList.add(new MarkerValue(new LatLng(29.86349,77.89481899999998), "Sds Park"));
        eventList.add(new MarkerValue(new LatLng(29.8663966,77.89740119999999), "Swimming Pool"));
        eventList.add(new MarkerValue(new LatLng(29.866386539114586,77.89640575647354), "Basketball Court"));
        eventList.add(new MarkerValue(new LatLng(29.8665328,77.8992647), "Badminton Hall"));
        eventList.add(new MarkerValue(new LatLng(29.8678612,77.89847880000002), "Football Ground"));

        accomodationList.add(new MarkerValue(new LatLng(29.8650813,77.90013590000001), "Sarojini Bhawan"));
        accomodationList.add(new MarkerValue(new LatLng(29.8673336,77.90107560000001), "Kasturba Bhawan"));
        accomodationList.add(new MarkerValue(new LatLng(29.8708241,77.89456199999995), "Rajendra Bhawan"));
        accomodationList.add(new MarkerValue(new LatLng(29.869813,77.894858), "Rajiv Bhawan"));
        accomodationList.add(new MarkerValue(new LatLng(29.87117600000001,77.89649800000007), "Cautley Bhawan"));
        accomodationList.add(new MarkerValue(new LatLng(29.8711058,77.89541199999996), "Radhakrishanan Bhawan"));
        accomodationList.add(new MarkerValue(new LatLng(29.8714815,77.89441820000002), "Ganga Bhawan"));
        accomodationList.add(new MarkerValue(new LatLng(29.8634607,77.90102419999994), "Jawahar Bhawan"));
        accomodationList.add(new MarkerValue(new LatLng(29.8616842,77.8944252), "Govind Bhawan"));
        accomodationList.add(new MarkerValue(new LatLng(29.86450769999999,77.8928277), "Ravindra Bhawan"));
        accomodationList.add(new MarkerValue(new LatLng(29.8655192,77.89157039999998), "Azad Bhawan"));
        accomodationList.add(new MarkerValue(new LatLng(29.86143672606512,77.89865881204605), "KIH"));
        accomodationList.add(new MarkerValue(new LatLng(29.864353,77.89933569999994), "NC Nigam"));

        eateriesList.add(new MarkerValue(new LatLng(29.8617004,77.89838559999998), "KIH Cafe"));
        eateriesList.add(new MarkerValue(new LatLng(29.86398489999999,77.89404539999998), "Georgia Cafe"));
        eateriesList.add(new MarkerValue(new LatLng(29.8611666,77.89807270000006), "Alpahar"));
        eateriesList.add(new MarkerValue(new LatLng(29.86630745568591,77.89841875433922), "Nescafe"));
        eateriesList.add(new MarkerValue(new LatLng(29.8701514,77.8967662), "Sattviko Idea Cafe"));
        eateriesList.add(new MarkerValue(new LatLng(29.870285972194917,77.89645805954933), "CCD"));
        eateriesList.add(new MarkerValue(new LatLng(29.870011516636215,77.89653114974499), "Amul"));
        eateriesList.add(new MarkerValue(new LatLng(29.8692931,77.89617780000003), "Food Court 1"));
        eateriesList.add(new MarkerValue(new LatLng(29.86329289999999,77.89466909999999), "Food Court 2"));


        atmlist.add(new MarkerValue(new LatLng(29.8619883,77.88627700000006), "SBI ATM"));
        atmlist.add(new MarkerValue(new LatLng(29.86585159999999,77.90182649999997), "SBI ATM"));
        atmlist.add(new MarkerValue(new LatLng(29.870214451009783,77.89661027491093), "SBI ATM"));
        atmlist.add(new MarkerValue(new LatLng(29.8701191,77.89648490000002), "PNB ATM"));
        atmlist.add(new MarkerValue(new LatLng(29.863773263807374,77.89435386657715), "PNB ATM"));

        hospitallist.add(new MarkerValue(new LatLng(29.86192989999999,77.8931844),"Hospital"));
        hospitallist.add(new MarkerValue(new LatLng(29.8686047,77.8902084), "Century Gate"));
        hospitallist.add(new MarkerValue(new LatLng(29.8649905,77.89647889999992), "Main Building"));
        hospitallist.add(new MarkerValue(new LatLng(29.86406518180116,77.895363047719), "ECE Circle"));
        hospitallist.add(new MarkerValue(new LatLng(29.867925164525754,77.89374969899654), "NIH Circle"));
        hospitallist.add(new MarkerValue(new LatLng(29.86382559999999,77.89395689999992), "Post Office"));
        hospitallist.add(new MarkerValue(new LatLng(29.86448589999999,77.89590620000001), "SBI Bank"));
        hospitallist.add(new MarkerValue(new LatLng(29.86375570000001,77.89420199999995), "PNB Bank"));
        hospitallist.add(new MarkerValue(new LatLng(29.8611257,77.89292479999995), "Railway Reservation Counter"));
        hospitallist.add(new MarkerValue(new LatLng(29.8648599,77.89657869999996), "Seanate Hall"));

        displayAll();
        //mMap.setOnMarkerClickListener(this);

        //GoogleMap mMap2 = googleMap;
        //mMap2.isTrafficEnabled();

        //mMap2.addMarker(new MarkerOptions()
        //      .position(new LatLng(29.8765, 78))
        //    .anchor(0.8f, 0.8f)
        //  .title("Thomso chutiya hai")
        //.snippet("snippet")
        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_shop_black_24dp))
        //);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MY_PERMISSION_FINE_LOCATION:
                if (grantResults[0]== PackageManager.PERMISSION_GRANTED)
                {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        mMap.setMyLocationEnabled(true);
                        mMap.getUiSettings().setMyLocationButtonEnabled(true);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"This app requires location to be granted",Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
                break;
        }

    }
    public void onClick(View v) {
        mMap.clear();
        List<MarkerValue> placeList = new ArrayList<>();
        int iconDrawable = 0;
        switch (v.getId()) {
            case R.id.fab_arc_menu_1:
                placeList = eventList;
                iconDrawable = R.drawable.ic_event_black_24dp;
                break;
            case R.id.fab_arc_menu_2:
                placeList = eateriesList;
                iconDrawable = R.drawable.ic_restaurant_black_24dp;
                break;
            case R.id.fab_arc_menu_3:
                placeList = accomodationList;
                iconDrawable = R.drawable.ic_account_balance_black_24dp;
                break;
            case R.id.fab_arc_menu_4:
                placeList = atmlist;
                iconDrawable = R.drawable.ic_local_atm_black_24dp;
                break;
            case R.id.fab_arc_menu_5:
                placeList = hospitallist;
                iconDrawable = R.drawable.ic_local_hospital_black_24dp;
                break;
        }
        for (MarkerValue place : placeList) {
            Marker marker = mMap.addMarker(new MarkerOptions().position(place.getLatLng()).title(place.getTitle()).icon(BitmapDescriptorFactory.fromResource(iconDrawable)).anchor(0.8f, 0.8f));
            marker.setTag(place);
        }
    }
    private void flyTO(CameraPosition target)
    {
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
    public void displayAll() {
        mMap.clear();
        final float half = (float) 0.5;
        for (MarkerValue place : eventList) {
            Marker marker = mMap.addMarker(new MarkerOptions().position(place.getLatLng()).title(place.getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_event_black_24dp)).anchor(half, half));
            marker.setTag(place);
        }
        for (MarkerValue place : eateriesList) {
            Marker marker = mMap.addMarker(new MarkerOptions().position(place.getLatLng()).title(place.getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant_black_24dp)).anchor(half, half));
            marker.setTag(place);
        }
        for (MarkerValue place : accomodationList) {
            Marker marker = mMap.addMarker(new MarkerOptions().position(place.getLatLng()).title(place.getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_account_balance_black_24dp)).anchor(half, half));
            marker.setTag(place);
        }
        for (MarkerValue place : atmlist) {
            Marker marker = mMap.addMarker(new MarkerOptions().position(place.getLatLng()).title(place.getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_atm_black_24dp)).anchor(half, half));
            marker.setTag(place);

        }
        for (MarkerValue place :hospitallist) {
            Marker marker = mMap.addMarker(new MarkerOptions().position(place.getLatLng()).title(place.getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_hospital_black_24dp)).anchor(half, half));
        //    marker.setTag(place.getTitle());
            marker.showInfoWindow();
        }
    }

}

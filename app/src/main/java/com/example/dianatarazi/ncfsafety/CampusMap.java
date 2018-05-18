package com.example.dianatarazi.ncfsafety;

import android.graphics.drawable.Icon;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.*;

import com.google.android.gms.R.drawable.*;



public class CampusMap extends AppCompatActivity implements OnMapReadyCallback {
    private Button button;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    //Latitudes and longitudes
    private static final LatLng BP1 = new LatLng(27.386094525966072, -82.56459610596276);
    private static final LatLng BP2 = new LatLng(27.386073924329015, -82.56350911374604);
    private static final LatLng BP3 = new LatLng(27.38459971399777, -82.56429267083118);
    private static final LatLng BP4 = new LatLng(27.385157902549825, -82.56243720636097);
    private static final LatLng BP5 = new LatLng(27.385963162533947, -82.56089025991147);
    private static final LatLng BP7 = new LatLng(27.38579954081948, -82.56216058238154);
    private static final LatLng BP8 = new LatLng(27.384629838717192, -82.56211271773729);
    private static final LatLng BP9 = new LatLng(27.3854597867881, -82.56059588637038);
    private static final LatLng BP10 = new LatLng(27.38516952852446, -82.56023350890895);
    private static final LatLng BP11 = new LatLng(27.385118029564094, -82.55978092639934);
    private static final LatLng BP12 = new LatLng(27.385764574020286, -82.5595864074342);
    private static final LatLng BP14 = new LatLng(27.385323094827584, -82.55867809477692);
    private static final LatLng BP21 = new LatLng(27.384977506843345, -82.55664899674812);
    private static final LatLng BP23 = new LatLng(27.385526844183065, -82.55569351889024);
    private static final LatLng BP24 = new LatLng(27.384927239897813, -82.55501063747543);
    private static final LatLng BP25 = new LatLng(27.384258913101483, -82.55499891767226);
    private static final LatLng BP26 = new LatLng(27.383413005280264, -82.55472581267817);
    private static final LatLng BP30 = new LatLng(27.38366520579648, -82.5563087170941);
    private static final LatLng BP32 = new LatLng(27.38417427212706, -82.55566570526457);
    private static final LatLng BP33 = new LatLng(27.3836337595846, -82.55566430220304);

    //Markers
    private Marker mBP1;
    private Marker mBP2;
    private Marker mBP3;
    private Marker mBP4;
    private Marker mBP5;
    private Marker mBP6;
    private Marker mBP7;
    private Marker mBP8;
    private Marker mBP9;
    private Marker mBP10;
    private Marker mBP11;
    private Marker mBP12;
    private Marker mBP13;
    private Marker mBP14;
    private Marker mBP15;
    private Marker mBP16;
    private Marker mBP17;
    private Marker mBP18;
    private Marker mBP19;
    private Marker mBP20;
    private Marker mBP21;
    private Marker mBP22;
    private Marker mBP23;
    private Marker mBP24;
    private Marker mBP25;
    private Marker mBP26;
    private Marker mBP27;
    private Marker mBP28;
    private Marker mBP29;
    private Marker mBP30;
    private Marker mBP31;
    private Marker mBP32;
    private Marker mBP33;
    private Marker mBP34;
    private Marker mBP35;
    private Marker mBP36;


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Side menu implementation
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = (Button) findViewById(R.id.callButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9412108808"));
                if (ActivityCompat.checkSelfPermission(CampusMap.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        int id = item.getItemId();

        if (id == R.id.nav_chl) {
            LatLng chlLocation = new LatLng(27.385073, -82.564008);
            Marker mCHL = mMap.addMarker(new MarkerOptions().position(chlLocation));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chlLocation, 8));
        }

        return super.onOptionsItemSelected(item);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        googleMap.setBuildingsEnabled(false);

        LatLng ncf = new LatLng(27.3848206, -82.5587668);
        //mMap.addMarker(new MarkerOptions().position(ncf).title("Marker in NCF"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(ncf));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ncf, 18));

        BitmapDescriptor marker = BitmapDescriptorFactory.fromResource(R.mipmap.red_marker);

        mBP1 = mMap.addMarker(new MarkerOptions().position(BP1).title("Out or Order").icon(marker));
        mBP2 = mMap.addMarker(new MarkerOptions().position(BP2).icon(marker));
        mBP3 = mMap.addMarker(new MarkerOptions().position(BP3).icon(marker));
        mBP4 = mMap.addMarker(new MarkerOptions().position(BP4).icon(marker));
        mBP5 = mMap.addMarker(new MarkerOptions().position(BP5).icon(marker));
        mBP7 = mMap.addMarker(new MarkerOptions().position(BP7).icon(marker));
        mBP8 = mMap.addMarker(new MarkerOptions().position(BP8).icon(marker));
        mBP9 = mMap.addMarker(new MarkerOptions().position(BP9).icon(marker));
        mBP10 = mMap.addMarker(new MarkerOptions().position(BP10).icon(marker));
        mBP11 = mMap.addMarker(new MarkerOptions().position(BP11).icon(marker));
        mBP12 = mMap.addMarker(new MarkerOptions().position(BP12).icon(marker));
        mBP14 = mMap.addMarker(new MarkerOptions().position(BP14).icon(marker));
        mBP21 = mMap.addMarker(new MarkerOptions().position(BP21).icon(marker));
        mBP23 = mMap.addMarker(new MarkerOptions().position(BP23).icon(marker));
        mBP24 = mMap.addMarker(new MarkerOptions().position(BP24).icon(marker));
        mBP25 = mMap.addMarker(new MarkerOptions().position(BP25).icon(marker));
        mBP26 = mMap.addMarker(new MarkerOptions().position(BP26).icon(marker));
        mBP30 = mMap.addMarker(new MarkerOptions().position(BP30).icon(marker));
        mBP32 = mMap.addMarker(new MarkerOptions().position(BP32).icon(marker));
        mBP33 = mMap.addMarker(new MarkerOptions().position(BP33).icon(marker));

    }
}

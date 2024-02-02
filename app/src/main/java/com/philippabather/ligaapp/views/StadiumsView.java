package com.philippabather.ligaapp.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mapbox.geojson.Point;
import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.mapbox.maps.plugin.gestures.OnMapClickListener;
import com.philippabather.ligaapp.R;
import com.philippabather.ligaapp.contract.StadiumsContract;
import com.philippabather.ligaapp.domain.Stadium;
import com.philippabather.ligaapp.map.MapUtils;
import com.philippabather.ligaapp.presenter.StadiumPresenter;

import java.util.ArrayList;
import java.util.List;

public class StadiumsView extends AppCompatActivity implements StadiumsContract.View, Style.OnStyleLoaded, OnMapClickListener {

    private MapView mapView;
    private PointAnnotationManager pointAnnotationManager; // MapBox libraries - for annotating the map

    private StadiumPresenter presenter;

    private List<Stadium> stadiumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadiums);
        findViews();
        setUpMap();

        stadiumList = new ArrayList<>();

        presenter = new StadiumPresenter(this);
    }

    private void findViews() {
        mapView = findViewById(R.id.mapView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadStadiums();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent();

        if (item.getItemId() == R.id.menu_item_home) {
            intent = new Intent(this, MainView.class);
        } else if (item.getItemId() == R.id.menu_item_teams) {
            intent = new Intent(this, TeamsView.class);
        } else {
            return super.onOptionsItemSelected(item);
        }

        startActivity(intent);
        return true;
    }

    private void setUpMap() {
        mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS, this);
        pointAnnotationManager = MapUtils.initializePointAnnotationManager(mapView);
        Bitmap marker = BitmapFactory.decodeResource(getResources(), R.mipmap.blue_marker_view);
//
//        MapUtils.addMarker(pointAnnotationManager, marker, 40.4530, -3.6883);
    }

    @Override
    public void onStyleLoaded(@NonNull Style style) {
        MapUtils.setCameraPositionAndZoom(mapView);
    }

    @Override
    public boolean onMapClick(@NonNull Point point) {
        return false;
    }

    @Override
    public void listStadiums(List<Stadium> stadiumList) {
        this.stadiumList.clear();
        this.stadiumList.addAll(stadiumList);

        for (Stadium stadium:
             stadiumList) {
            Bitmap marker = BitmapFactory.decodeResource(getResources(), R.mipmap.blue_marker_view);
            MapUtils.addMarker(pointAnnotationManager, marker, stadium.getLatitude(), stadium.getLongitude());
        }
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}

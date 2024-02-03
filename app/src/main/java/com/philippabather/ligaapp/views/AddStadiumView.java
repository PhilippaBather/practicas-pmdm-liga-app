package com.philippabather.ligaapp.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mapbox.geojson.Point;
import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.mapbox.maps.plugin.gestures.OnMapClickListener;
import com.philippabather.ligaapp.R;
import com.philippabather.ligaapp.contract.AddStadiumContract;
import com.philippabather.ligaapp.domain.NewStadiumDTO;
import com.philippabather.ligaapp.map.MapUtils;
import com.philippabather.ligaapp.presenter.AddStadiumPresenter;

import java.time.LocalDate;

public class AddStadiumView extends AppCompatActivity implements AddStadiumContract.View, Style.OnStyleLoaded, OnMapClickListener {

    private MapView mapView;

    private Button btnBack;
    private Button btnAdd;
    private EditText etAdaptedAccess;
    private EditText etConstructionDate;
    private EditText etStadiumName;
    private EditText etStadiumId;
    private float latitude;
    private float longitude;
    private PointAnnotationManager pointAnnotationManager; // MapBox libraries - for annotating the map
    private AddStadiumPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stadium);
        findViews();
        setClickListeners();
        setUpMap();
        presenter = new AddStadiumPresenter(this);
    }

    private void findViews() {
        btnAdd = findViewById(R.id.btn_add);
        btnBack = findViewById(R.id.btn_back);
        etAdaptedAccess = findViewById(R.id.et_add_stadium_adapted_access);
        etConstructionDate = findViewById(R.id.et_add_stadium_construction);
        etStadiumName = findViewById(R.id.et_add_stadium_name);
        etStadiumId = findViewById(R.id.et_add_stadium_id);
        mapView = findViewById(R.id.mapView);
    }

    private void setClickListeners(){
        btnAdd.setOnClickListener(v -> addStadium());
        btnBack.setOnClickListener(v -> goToHome());;
    }

    private void setUpMap() {
        mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS, this);
        pointAnnotationManager = MapUtils.initializePointAnnotationManager(mapView);
    }

    private void addStadium() {
        // TODO
        // 1. logic to get values
        boolean adaptedAccess = etAdaptedAccess.getText().toString().toLowerCase().equals("true"); // default: false
        LocalDate constructionDate = LocalDate.parse(etConstructionDate.getText().toString());
        String name = etStadiumName.getText().toString();
        long teamId = Long.parseLong(etStadiumId.getText().toString());

        NewStadiumDTO newStadium = new NewStadiumDTO(name, constructionDate, adaptedAccess, latitude, longitude, teamId);

        // 2. presenter call to make API request
        presenter.addStadiumByTeamId(newStadium);

        // 3. navigate to home
        goToHome();
    }

    private void goToHome() {
        Intent intent = new Intent(this, MainView.class);
        startActivity(intent);
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
        } else if (item.getItemId() == R.id.menu_item_stadiums) {
            intent = new Intent(this, StadiumsView.class);
        } else {
            return super.onOptionsItemSelected(item);
        }

        startActivity(intent);
        return true;
    }

    @Override
    public boolean onMapClick(@NonNull Point point) {
        pointAnnotationManager.deleteAll();
        latitude = (float) point.latitude();
        longitude = (float) point.longitude();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.blue_marker_view);
        MapUtils.addMarker(pointAnnotationManager, bitmap, latitude, longitude);
        return false;
    }

    @Override
    public void onStyleLoaded(@NonNull Style style) {
        MapUtils.setCameraPositionAndZoom(mapView);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    // 4. dialog for adding
}

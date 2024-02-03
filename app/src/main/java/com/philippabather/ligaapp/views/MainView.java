package com.philippabather.ligaapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.philippabather.ligaapp.R;

public class MainView extends AppCompatActivity {

    private CardView cvStadiums;
    private CardView cvTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListeners();
    }

    private void findViews() {
        cvStadiums = findViewById(R.id.cv_stadiums);
        cvTeams = findViewById(R.id.cv_teams);
    }

    private void setListeners() {
        cvStadiums.setOnClickListener(v -> goToStadiumsActivity());
        cvTeams.setOnClickListener(v -> goToTeamsActivity());
    }

    private void goToStadiumsActivity() {
        Intent intent = new Intent(this, StadiumsView.class);
        startActivity(intent);
    }

    private void goToTeamsActivity() {
        Intent intent = new Intent(this, TeamsView.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent();

        if (item.getItemId() == R.id.menu_item_stadiums) {
            goToStadiumsActivity();
        } else if (item.getItemId() == R.id.menu_item_teams) {
            goToTeamsActivity();
        } else {
            return super.onOptionsItemSelected(item);
        }

        startActivity(intent);
        return true;

    }
}

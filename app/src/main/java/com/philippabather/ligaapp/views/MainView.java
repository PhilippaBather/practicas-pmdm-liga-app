package com.philippabather.ligaapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.philippabather.ligaapp.R;

public class MainView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            intent = new Intent(this, StadiumsView.class);
        } else if (item.getItemId() == R.id.menu_item_teams) {
            intent = new Intent(this, TeamsView.class);
        } else {
            return super.onOptionsItemSelected(item);
        }

        startActivity(intent);
        return true;

    }
}
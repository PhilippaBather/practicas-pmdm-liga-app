package com.philippabather.ligaapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.philippabather.ligaapp.R;
import com.philippabather.ligaapp.adapter.TeamsAdapter;

import java.util.ArrayList;
import java.util.List;

public class TeamsView extends AppCompatActivity {

    private TeamsAdapter teamsAdapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView teamsRecyclerView;

    private List<String> dummyData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_list);
        findViews();

        // TODO - remove DUMMY DATA
        dummyData = new ArrayList<>();
        dummyData.add("Brighton & Hove Albion");
        dummyData.add("Southampton FC");
        dummyData.add("Manchester City FC");

        linearLayoutManager = new LinearLayoutManager(TeamsView.this);
        teamsRecyclerView.setLayoutManager(linearLayoutManager);

        teamsAdapter = new TeamsAdapter(dummyData);
        teamsRecyclerView.setAdapter(teamsAdapter);
    }

    private void findViews() {
        teamsRecyclerView = findViewById(R.id.rv_team_list);
        teamsRecyclerView.setHasFixedSize(true);
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
        } else if (item.getItemId() == R.id.menu_item_stadiums) {
            intent = new Intent(this, StadiumsView.class);
        } else {
            return super.onOptionsItemSelected(item);
        }

        startActivity(intent);
        return true;
    }
}

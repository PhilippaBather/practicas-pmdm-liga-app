package com.philippabather.ligaapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.philippabather.ligaapp.R;
import com.philippabather.ligaapp.adapter.TeamsAdapter;
import com.philippabather.ligaapp.contract.TeamsContract;
import com.philippabather.ligaapp.domain.Team;
import com.philippabather.ligaapp.presenter.TeamPresenter;

import java.util.ArrayList;
import java.util.List;

public class TeamsView extends AppCompatActivity implements TeamsContract.View {

    private TeamsAdapter teamsAdapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView teamsRecyclerView;
    private TeamPresenter presenter;
    private List<Team> teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_list);
        findViews();

        presenter = new TeamPresenter(this);
        teamList = new ArrayList<>();

        linearLayoutManager = new LinearLayoutManager(TeamsView.this);
        teamsRecyclerView.setLayoutManager(linearLayoutManager);

        teamsAdapter = new TeamsAdapter(teamList);
        teamsRecyclerView.setAdapter(teamsAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadTeams();
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
        } else if (item.getItemId() == R.id.menu_item_add_stadium) {
            intent = new Intent(this, AddStadiumView.class);
        } else {
            return super.onOptionsItemSelected(item);
        }

        startActivity(intent);
        return true;
    }

    @Override
    public void listTeams(List<Team> teamsList) {
        this.teamList.clear();
        this.teamList.addAll(teamsList);
        teamsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}

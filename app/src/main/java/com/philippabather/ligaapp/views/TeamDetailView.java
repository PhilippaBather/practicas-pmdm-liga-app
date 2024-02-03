package com.philippabather.ligaapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.philippabather.ligaapp.R;
import com.philippabather.ligaapp.contract.TeamDetailContract;
import com.philippabather.ligaapp.contract.TeamsUpdateContract;
import com.philippabather.ligaapp.domain.Team;
import com.philippabather.ligaapp.presenter.TeamUpdatePresenter;
import com.philippabather.ligaapp.presenter.TeamsDetailPresenter;

public class TeamDetailView extends AppCompatActivity implements TeamDetailContract.View, TeamsUpdateContract.View {

    private Button btnBack;
    private Button btnDelete;
    private Button btnUpdate;
    private EditText etName;
    private EditText etFounded;
    private EditText etChampions;
    private EditText etPoints;
    private TeamsDetailPresenter teamsDetailPresenter;
    private TeamUpdatePresenter teamUpdatePresenter;

    private long teamId;
    private Team team;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);
        findViews();
        setListeners();

        Intent intent = getIntent();
        teamId = intent.getLongExtra("teamId", 1L);
        team = new Team();

        teamsDetailPresenter = new TeamsDetailPresenter(this);
        teamUpdatePresenter = new TeamUpdatePresenter(this);

        // add dialogs

        // add action bar
    }

    @Override
    protected void onResume() {
        super.onResume();
        teamsDetailPresenter.loadTeam(teamId);
    }

    private void findViews() {
        btnBack = findViewById(R.id.btn_back);
        btnDelete = findViewById(R.id.btn_delete);
        btnUpdate = findViewById(R.id.btn_update);
        etChampions = findViewById(R.id.et_team_details_champions);
        etFounded = findViewById(R.id.et_team_details_founded);
        etName = findViewById(R.id.et_team_details_name);
        etPoints = findViewById(R.id.et_team_details_points);
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
    public void listTeam(Team team) {
        this.team = team;
        setFields();
    }

    private void setFields() {
        etChampions.setText(team.getAreChampions().toString());
        etFounded.setText(team.getFoundationDate());
        etName.setText(team.getName());
        etPoints.setText(String.valueOf(team.getLeaguePoints()));
    }

    private void setListeners() {
        btnBack.setOnClickListener(v -> handleBackBtn());
        btnDelete.setOnClickListener(v -> handleDelete());
        btnUpdate.setOnClickListener(v -> handleUpdate());
    }

    private void handleBackBtn() {
        Intent intent = new Intent(this, TeamsView.class);
        startActivity(intent);
    }

    private void handleDelete() {
        // TODO - dialog
        teamUpdatePresenter.deleteTeamById(team.getId());
    }

    private void handleUpdate() {
        // TODO - dialog

        String name = etName.getText().toString();
        String founded = etFounded.getText().toString();
        boolean areChampions = etChampions.getText().toString().toLowerCase().equals("true"); // default: false
        int points = Integer.parseInt(etPoints.getText().toString());
        Team updatedTeam = new Team(name, founded, areChampions, points);

        teamUpdatePresenter.updateTeamById(team.getId(), updatedTeam);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}

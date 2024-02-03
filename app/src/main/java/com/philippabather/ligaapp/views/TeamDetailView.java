package com.philippabather.ligaapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.LongDef;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.philippabather.ligaapp.R;
import com.philippabather.ligaapp.contract.TeamDetailContract;
import com.philippabather.ligaapp.domain.Team;
import com.philippabather.ligaapp.presenter.TeamsDetailPresenter;

public class TeamDetailView extends AppCompatActivity implements TeamDetailContract.View {

    private Button btnDelete;
    private Button btnUpdate;
    private EditText etName;
    private EditText etFounded;
    private EditText etChampions;
    private EditText etPoints;
    private TeamsDetailPresenter presenter;
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
        Log.e("teamId", String.valueOf(teamId));
        team = new Team();

        presenter = new TeamsDetailPresenter(this);

        // set fields

        // add delete and update calls to API
        // update contract, MVP

        // add dialogs

        // add action bar
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadTeam(teamId);
    }

    private void findViews() {
        btnDelete = findViewById(R.id.btn_delete);
        btnUpdate = findViewById(R.id.btn_update);
        etChampions = findViewById(R.id.et_team_details_champions);
        etFounded = findViewById(R.id.et_team_details_founded);
        etName = findViewById(R.id.et_team_details_name);
        etPoints = findViewById(R.id.et_team_details_points);
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
        btnDelete.setOnClickListener(v -> handleDelete());
        btnUpdate.setOnClickListener(v -> handleUpdate());
    }

    private void handleDelete() {
        // TODO - dialog and delete
    }

    private void handleUpdate() {
        // TODO - dialog and update
    }


    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}

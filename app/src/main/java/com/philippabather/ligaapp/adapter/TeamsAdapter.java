package com.philippabather.ligaapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.philippabather.ligaapp.R;
import com.philippabather.ligaapp.domain.Team;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsHolder> {

    private List<Team> teams;
    private TeamsHolder teamsHolder;

    public TeamsAdapter(List<Team> teams) {
        this.teams = teams;
    }

    @NonNull
    @Override
    public TeamsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_team_item, parent, false);
        return new TeamsHolder(view, teams);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsHolder holder, int position) {
        Team team = teams.get(position);
        holder.tvTeamName.setText(team.getName());
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }
}

package com.philippabather.ligaapp.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.philippabather.ligaapp.R;
import com.philippabather.ligaapp.domain.Team;
import com.philippabather.ligaapp.views.TeamDetailView;

import java.util.List;

public class TeamsHolder extends RecyclerView.ViewHolder {

    protected CardView cvTeamItem;
    protected TextView tvTeamName;
    private final View parentView;
    private List<Team> teams;

    public TeamsHolder(@NonNull View itemView, List<Team> teams) {
        super(itemView);
        parentView = itemView;
        this.teams = teams;
        findViews();

        cvTeamItem.setOnClickListener(v -> goToTeamDetailsView(teams));
    }

    private void findViews() {
        cvTeamItem = parentView.findViewById(R.id.cv_team_item);
        tvTeamName = parentView.findViewById(R.id.tv_team_name);
    }

    private void goToTeamDetailsView(List<Team> teams) {
        // TODO - method to go to specific team page
        Intent intent = new Intent(parentView.getContext(), TeamDetailView.class);
        Team team = getCurrentTeam(teams);
        // TODO - use parcelable
//        intent.putExtra("team_name");
//        parentView.getContext().startActivity(intent);
    }

    private Team getCurrentTeam(List<Team> teams) {
        int adapterPosition = getAdapterPosition();
        return teams.get(adapterPosition);
    }

}

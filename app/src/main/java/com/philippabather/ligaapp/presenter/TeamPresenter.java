package com.philippabather.ligaapp.presenter;

import com.philippabather.ligaapp.contract.TeamsContract;
import com.philippabather.ligaapp.domain.Team;
import com.philippabather.ligaapp.model.TeamsModel;
import com.philippabather.ligaapp.views.TeamsView;

import java.util.List;

public class TeamPresenter implements TeamsContract.Presenter, TeamsContract.Model.OnLoadTeamsListener {

    private TeamsModel teamsModel;
    private TeamsView teamsView;


    public TeamPresenter(TeamsView teamsView) {
        this.teamsView = teamsView;
        this.teamsModel = new TeamsModel();
    }

    @Override
    public void loadTeams() {
        teamsModel.loadTeams(this);
    }
    @Override
    public void onLoadTeamsSuccess(List<Team> teamsList) {
        teamsView.listTeams(teamsList);
    }

    @Override
    public void onLoadTeamsError(String msg) {
        teamsView.showMessage(msg);
    }


}

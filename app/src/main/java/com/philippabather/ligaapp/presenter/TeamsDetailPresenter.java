package com.philippabather.ligaapp.presenter;

import com.philippabather.ligaapp.contract.TeamDetailContract;
import com.philippabather.ligaapp.domain.Team;
import com.philippabather.ligaapp.model.TeamDetailModel;
import com.philippabather.ligaapp.views.TeamDetailView;

public class TeamsDetailPresenter implements TeamDetailContract.Presenter, TeamDetailContract.Model.OnLoadTeamListener {

    private TeamDetailModel teamDetailModel;
    private TeamDetailView teamDetailView;

    public TeamsDetailPresenter(TeamDetailView teamDetailView) {
        this.teamDetailView = teamDetailView;
        this.teamDetailModel = new TeamDetailModel();
    }

    @Override
    public void onLoadTeamSuccess(Team team) {
        teamDetailView.listTeam(team);
    }

    @Override
    public void onLoadTeamError(String msg) {
        teamDetailView.showMessage(msg);
    }

    @Override
    public void loadTeam(long id) {
        teamDetailModel.loadTeam(this, id);
    }
}

package com.philippabather.ligaapp.presenter;

import com.philippabather.ligaapp.contract.TeamsUpdateContract;
import com.philippabather.ligaapp.domain.Team;
import com.philippabather.ligaapp.model.TeamUpdateModel;
import com.philippabather.ligaapp.views.TeamDetailView;

public class TeamUpdatePresenter implements TeamsUpdateContract.Presenter, TeamsUpdateContract.Model.OnUpdateTeamListener, TeamsUpdateContract.Model.OnDeleteTeamListener {

    private TeamDetailView view;
    private TeamUpdateModel model;

    public TeamUpdatePresenter(TeamDetailView view) {
        this.view = view;
        this.model = new TeamUpdateModel();
    }

    @Override
    public void onUpdateTeamSuccess(Team team) {
        view.showMessage("Updated: " + team.getName());
    }

    @Override
    public void onUpdateTeamError(String msg) {
        view.showMessage(msg);
    }

    @Override
    public void updateTeamById(long id, Team team) {
        model.updateTeamById(this, id, team);
    }

    @Override
    public void deleteTeamById(long id) {
        model.deleteTeamById(this, id);
    }

    @Override
    public void onDeleteTeamSuccess() {
        view.showMessage("Team deleted.");
    }

    @Override
    public void onDeleteTeamError(String msg) {
        view.showMessage(msg);
    }
}

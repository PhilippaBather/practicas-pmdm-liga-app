package com.philippabather.ligaapp.contract;

import com.philippabather.ligaapp.domain.Team;

public interface TeamsUpdateContract {

    interface Model {

        interface OnUpdateTeamListener {
            void onUpdateTeamSuccess(Team team);
            void onUpdateTeamError(String msg);
        }

        interface OnDeleteTeamListener {
            void onDeleteTeamSuccess();
            void onDeleteTeamError(String msg);
        }

        void updateTeamById(OnUpdateTeamListener updateTeamListener, long id, Team team);
        void deleteTeamById(OnDeleteTeamListener deleteTeamListener, long id);

    }

    interface View {
        void showMessage(String msg);
    }

    interface Presenter {
        void updateTeamById(long id, Team team);
        void deleteTeamById(long id);
    }
}

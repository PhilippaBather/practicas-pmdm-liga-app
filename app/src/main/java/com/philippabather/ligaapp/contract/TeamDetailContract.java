package com.philippabather.ligaapp.contract;

import com.philippabather.ligaapp.domain.Team;

public interface TeamDetailContract {

    interface Model {

        interface OnLoadTeamListener {
            void onLoadTeamSuccess(Team team);
            void onLoadTeamError(String msg);
        }

        void loadTeam(OnLoadTeamListener onLoadTeamListener, long id);
    }

    interface View {
        void listTeam(Team team);
        void showMessage(String msg);

    }

    interface Presenter {
        void loadTeam(long id);
    }

}

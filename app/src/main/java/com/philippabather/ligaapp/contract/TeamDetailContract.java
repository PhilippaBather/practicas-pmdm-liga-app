package com.philippabather.ligaapp.contract;

import com.philippabather.ligaapp.domain.Team;

public interface TeamContract {

    interface Model {

        interface OnLoadTeamListener {
            void onLoadTeamSuccess(Team team);
            void onLoadTeamError(String msg);
        }

        void loadTeam(OnLoadTeamListener onLoadTeamListener);
    }

    interface View {
        void listTeam(Team team);
        void showMessage(String msg);

    }

    interface Presenter {
        void loadTeam();
    }

}

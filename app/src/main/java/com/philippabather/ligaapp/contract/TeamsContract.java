package com.philippabather.ligaapp.contract;

import com.philippabather.ligaapp.domain.Team;

import java.util.List;
public interface TeamsContract {

    interface Model {

        interface OnLoadTeamsListener {
            void onLoadTeamsSuccess(List<Team> teamsList);
            void onLoadTeamsError(String msg);
        }
        void loadTeams(OnLoadTeamsListener onLoadTeamsListener);
    }

    interface View {
        void listTeams(List<Team> teamsList);
        void showMessage(String msg);
    }

    interface Presenter {
        void loadTeams();
    }

}

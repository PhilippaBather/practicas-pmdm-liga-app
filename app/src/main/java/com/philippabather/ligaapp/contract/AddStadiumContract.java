package com.philippabather.ligaapp.contract;

import com.philippabather.ligaapp.domain.NewStadiumDTO;
import com.philippabather.ligaapp.domain.Stadium;

public interface AddStadiumContract {

    interface Model {

        interface OnAddStadiumListener {
            void onAddStadiumSuccess(Stadium stadium);
            void onAddStadiumError(String msg);
        }

        void addStadium(OnAddStadiumListener onAddStadiumListener, NewStadiumDTO stadium);
    }

    interface View {
        void showMessage(String msg);
    }

    interface Presenter {
        void addStadiumByTeamId(NewStadiumDTO stadium);
    }
}

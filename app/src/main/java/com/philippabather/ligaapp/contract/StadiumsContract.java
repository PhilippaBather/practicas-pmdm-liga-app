package com.philippabather.ligaapp.contract;

import com.philippabather.ligaapp.domain.Stadium;

import java.util.List;

public interface StadiumsContract {

    interface Model {

        interface OnLoadStadiumsListener {
            void onLoadStadiumsSuccess(List<Stadium> stadiumList);
            void onLoadStadiumsError(String msg);
        }
        void loadStadiums(OnLoadStadiumsListener onLoadStadiumsListener);
    }

    interface View {
        void listStadiums(List<Stadium> stadiumList);
        void showMessage(String msg);

    }

    interface Presenter {
        void loadStadiums();
    }
}

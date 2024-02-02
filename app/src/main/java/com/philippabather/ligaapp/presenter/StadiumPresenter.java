package com.philippabather.ligaapp.presenter;

import com.philippabather.ligaapp.contract.StadiumsContract;
import com.philippabather.ligaapp.domain.Stadium;
import com.philippabather.ligaapp.model.StadiumModel;
import com.philippabather.ligaapp.views.StadiumsView;

import java.util.List;

public class StadiumPresenter implements StadiumsContract.Presenter, StadiumsContract.Model.OnLoadStadiumsListener {

    private StadiumModel stadiumModel;
    private StadiumsView stadiumsView;

    public StadiumPresenter(StadiumsView stadiumsView) {
        this.stadiumsView = stadiumsView;
        this.stadiumModel = new StadiumModel(this.stadiumsView);
    }

    @Override
    public void loadStadiums() {
        stadiumModel.loadStadiums(this);
    }

    @Override
    public void onLoadStadiumsSuccess(List<Stadium> stadiumList) {
        stadiumsView.listStadiums(stadiumList);
    }

    @Override
    public void onLoadStadiumsError(String msg) {
        stadiumsView.showMessage(msg);
    }
}

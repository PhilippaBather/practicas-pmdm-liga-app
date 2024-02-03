package com.philippabather.ligaapp.presenter;

import com.philippabather.ligaapp.contract.AddStadiumContract;
import com.philippabather.ligaapp.domain.NewStadiumDTO;
import com.philippabather.ligaapp.domain.Stadium;
import com.philippabather.ligaapp.model.AddStadiumModel;
import com.philippabather.ligaapp.views.AddStadiumView;

public class AddStadiumPresenter implements AddStadiumContract.Presenter, AddStadiumContract.Model.OnAddStadiumListener {

    private AddStadiumView view;

    private AddStadiumModel model;

    public AddStadiumPresenter(AddStadiumView view) {
        this.view = view;
        this.model = new AddStadiumModel();
    }

    @Override
    public void onAddStadiumSuccess(Stadium stadium) {
        view.showMessage("Added");
    }

    @Override
    public void onAddStadiumError(String msg) {
        view.showMessage(msg);
    }

    @Override
    public void addStadiumByTeamId(NewStadiumDTO stadium) {
        model.addStadium(this, stadium);
    }
}

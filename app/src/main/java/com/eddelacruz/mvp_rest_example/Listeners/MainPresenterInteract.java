package com.eddelacruz.mvp_rest_example.Listeners;

import com.eddelacruz.mvp_rest_example.Models.School_Item;

import java.util.List;

public class MainPresenterInteract implements PVContract.presenter, PVContract.GetSchoolInteractor.OnFinishedListener {

    private PVContract.MainView mainView;
    private PVContract.GetSchoolInteractor getNoticeIntractor;

    public MainPresenterInteract(PVContract.MainView mainView, PVContract.GetSchoolInteractor getNoticeIntractor) {
        this.mainView = mainView;
        this.getNoticeIntractor = getNoticeIntractor;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }


    @Override
    public void requestDataFromServer() {
        getNoticeIntractor.getSchoolList(this);
    }


    @Override
    public void onFinished(List<School_Item> SchoolList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(SchoolList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}

package com.eddelacruz.mvp_rest_example.Listeners;

import com.eddelacruz.mvp_rest_example.Models.School_Item;
import java.util.List;

public interface PVContract {

    interface presenter{

        void onDestroy();

        void requestDataFromServer();

    }

    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<School_Item> noticeArrayList);

        void onResponseFailure(Throwable throwable);

    }

    interface GetSchoolInteractor {

        interface OnFinishedListener {
            void onFinished(List<School_Item> noticeArrayList);
            void onFailure(Throwable t);
        }

        void getSchoolList(OnFinishedListener onFinishedListener);
    }
}

package za.co.taffy.spacexcodetest.contract;

import java.util.List;

import za.co.taffy.spacexcodetest.model.LaunchListResponse;

public interface LaunchesMainActivityContract {

    interface Model {
        interface OnFinishListener {
            void onFinished(List<LaunchListResponse> launchesList);
            void onFailure(Throwable t);
        }

        void getLaunchesList(OnFinishListener onFinishsListener);
    }

    interface View {
        void showLaunchesProgressBar();
        void hideLaunchesProgressBar();
        void setDataToRecyclerView(List <LaunchListResponse> launchesList);
        void onLaunchesResponseFailure(Throwable t);
    }

    interface Presenter {
        void onDestroy();
        void requestLaunchesListFromApi();
    }
}
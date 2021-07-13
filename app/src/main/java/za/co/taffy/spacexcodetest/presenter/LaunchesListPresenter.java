package za.co.taffy.spacexcodetest.presenter;

import java.util.List;

import za.co.taffy.spacexcodetest.contract.LaunchesMainActivityContract;
import za.co.taffy.spacexcodetest.model.LaunchListResponse;
import za.co.taffy.spacexcodetest.service.LaunchesListModel;

public class LaunchesListPresenter implements LaunchesMainActivityContract.Presenter, LaunchesMainActivityContract.Model.OnFinishListener {

    private LaunchesMainActivityContract.View launchesListView;
    private LaunchesMainActivityContract.Model launchesListModel;

    public LaunchesListPresenter(LaunchesMainActivityContract.View launchesListView) {
        this.launchesListView = launchesListView;
       launchesListModel = new LaunchesListModel();
    }

    @Override
    public void onDestroy() {
        this.launchesListView = null;
    }

    @Override
    public void requestLaunchesListFromApi() {
        if (launchesListView != null) {
            launchesListView.showLaunchesProgressBar();
        }

        launchesListModel.getLaunchesList(this);
    }

    @Override
    public void onFinished(List<LaunchListResponse> launchesList) {
        launchesListView.setDataToRecyclerView(launchesList);

        if (launchesListView != null) {
            launchesListView.hideLaunchesProgressBar();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        launchesListView.onLaunchesResponseFailure(t);

        if (launchesListView != null) {
            launchesListView.hideLaunchesProgressBar();
        }
    }
}

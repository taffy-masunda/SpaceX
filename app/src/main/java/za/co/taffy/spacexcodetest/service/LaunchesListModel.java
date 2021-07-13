package za.co.taffy.spacexcodetest.service;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import za.co.taffy.spacexcodetest.contract.LaunchesMainActivityContract;
import za.co.taffy.spacexcodetest.model.LaunchListResponse;
import za.co.taffy.spacexcodetest.network.ApiClient;
import za.co.taffy.spacexcodetest.network.ApiInterface;

public class LaunchesListModel implements LaunchesMainActivityContract.Model {

    final String TAG = "LaunchesListModel";

    @Override
    public void getLaunchesList(OnFinishListener onFinishsListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<LaunchListResponse>> call = apiService.getAllLaunches();

        call.enqueue(new Callback<List<LaunchListResponse>>() {
            @Override
            public void onResponse(Call<List<LaunchListResponse>> call, Response<List<LaunchListResponse>> response) {
                List<LaunchListResponse> launchesList = response.body();
                Log.e(TAG, "Number of launches: " + launchesList.size());
                onFinishsListener.onFinished(launchesList);
            }

            @Override
            public void onFailure(Call<List<LaunchListResponse>> call, Throwable t) {
                Log.e(TAG, "Error getting Launches" + t.getMessage());
                onFinishsListener.onFailure(t);
            }
        });
    }
}

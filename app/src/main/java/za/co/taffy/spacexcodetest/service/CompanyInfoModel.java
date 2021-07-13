package za.co.taffy.spacexcodetest.service;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import za.co.taffy.spacexcodetest.contract.CompanyInfoMainActivityContract;
import za.co.taffy.spacexcodetest.model.Company;
import za.co.taffy.spacexcodetest.model.LaunchListResponse;
import za.co.taffy.spacexcodetest.network.ApiClient;
import za.co.taffy.spacexcodetest.network.ApiInterface;

public class CompanyInfoModel implements CompanyInfoMainActivityContract.Model {

    final String TAG = "CompanyInfoModel";

    @Override
    public void getCompanyInfo(OnFinishListener onFinishListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<Company> call = apiService.getCompanyInformation();
        call.enqueue(new Callback<Company>() {
            @Override
            public void onResponse(Call<Company> call, Response<Company> response) {
                Company companyInfo = response.body();
                Log.e(TAG, "Company Info : \n" + companyInfo.toString());
                onFinishListener.onFinished(companyInfo);
            }

            @Override
            public void onFailure(Call<Company> call, Throwable t) {
                Log.e(TAG, "Company Info Error occured : \n" + t.getMessage());
                onFinishListener.onFailure(t);
            }
        });
    }
}

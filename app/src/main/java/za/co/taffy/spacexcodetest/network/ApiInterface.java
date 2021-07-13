package za.co.taffy.spacexcodetest.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import za.co.taffy.spacexcodetest.model.Company;
import za.co.taffy.spacexcodetest.model.LaunchListResponse;

public interface ApiInterface {

    @GET("info")
    Call<Company> getCompanyInformation();

    @GET("launches")
    Call<List<LaunchListResponse>> getAllLaunches();
}

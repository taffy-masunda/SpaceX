package za.co.taffy.spacexcodetest.presenter;

import za.co.taffy.spacexcodetest.contract.CompanyInfoMainActivityContract;
import za.co.taffy.spacexcodetest.model.Company;

public class CompanyInformationPresenter implements CompanyInfoMainActivityContract.Presenter, CompanyInfoMainActivityContract.Model.OnFinishListener {

    private CompanyInfoMainActivityContract.View mainView;
    private CompanyInfoMainActivityContract.Model companyModel;

    public CompanyInformationPresenter(CompanyInfoMainActivityContract.View mainView, CompanyInfoMainActivityContract.Model companyModel) {
        this.mainView = mainView;
        this.companyModel = companyModel;
    }

    @Override
    public void onDestroy() {
        this.mainView = null;
    }

    @Override
    public void requestDataFromApi() {
        if (mainView != null) {
            mainView.showProgressBar();
        }
        companyModel.getCompanyInfo(this);

    }

    @Override
    public void onFinished(Company companyInformation) {
        mainView.setDataToTextView(companyInformation);
        if (mainView != null) {
            mainView.hideProgressBar();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        mainView.onResponseFailure(t);
        if (mainView != null) {
            mainView.hideProgressBar();
        }
    }
}

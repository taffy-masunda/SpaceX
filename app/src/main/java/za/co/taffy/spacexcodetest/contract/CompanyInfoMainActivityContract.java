package za.co.taffy.spacexcodetest.contract;

import za.co.taffy.spacexcodetest.model.Company;

public interface CompanyInfoMainActivityContract {

    interface Model{
        interface OnFinishListener {
            void onFinished(Company companyInformation);
            void onFailure(Throwable t);
        }
        void getCompanyInfo(OnFinishListener onFinishsListener);
    }

    interface View{
        void showProgressBar();
        void hideProgressBar();
        void setDataToTextView(Company companyInfo);
        void onResponseFailure(Throwable t);
    }

    interface Presenter{
        void onDestroy();
        void requestDataFromApi() ;
    }
}

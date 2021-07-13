package za.co.taffy.spacexcodetest.view;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import za.co.taffy.spacexcodetest.R;
import za.co.taffy.spacexcodetest.contract.CompanyInfoMainActivityContract;
import za.co.taffy.spacexcodetest.contract.LaunchesMainActivityContract;
import za.co.taffy.spacexcodetest.model.Company;
import za.co.taffy.spacexcodetest.model.LaunchListResponse;
import za.co.taffy.spacexcodetest.presenter.CompanyInformationPresenter;
import za.co.taffy.spacexcodetest.presenter.LaunchesListPresenter;
import za.co.taffy.spacexcodetest.service.CompanyInfoModel;

public class MainActivity extends AppCompatActivity implements CompanyInfoMainActivityContract.View, LaunchesMainActivityContract.View, View.OnClickListener, LaunchesRecyclerAdapter.OnLaunchListener {

    private CompanyInformationPresenter companyInformationPresenter;
    private LaunchesListPresenter launchesListPresenter;

    private Toolbar toolbar;
    private ImageView filterIconImageview;
    private ProgressBar companyInfoProgressBar;
    private TextView companyInfoTextview;
    private ProgressBar launchesProgressBar;
    private RecyclerView launchesRecyclerView;
    private List<LaunchListResponse> launchListResponses;
    private LaunchesRecyclerAdapter launchesRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

        companyInformationPresenter = new CompanyInformationPresenter(this, new CompanyInfoModel());
        companyInformationPresenter.requestDataFromApi();

        launchListResponses = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        launchesRecyclerView.setLayoutManager(layoutManager);
       // launchesRecyclerView.setHasFixedSize(true);

        launchesListPresenter = new LaunchesListPresenter(this);
        launchesListPresenter.requestLaunchesListFromApi();
    }

    public void setupViews() {
        toolbar = findViewById(R.id.top_toolbar);
        filterIconImageview = findViewById(R.id.icon_filter_imageview);
        companyInfoProgressBar = findViewById(R.id.company_info_progress_bar);
        companyInfoTextview = findViewById(R.id.company_info_textview);
        launchesProgressBar = findViewById(R.id.launches_progress_bar);
        launchesRecyclerView = findViewById(R.id.launches_recycler_view);

        // action listeners
        filterIconImageview.setOnClickListener(this);
    }

    /* COMPANY INFO METHODS */
    @Override
    public void showProgressBar() {
        companyInfoProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        companyInfoProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setDataToTextView(Company companyInfo) {
        companyInfoTextview.setText(buildCompanyProfileMessage(companyInfo));
    }

    @Override
    public void onResponseFailure(Throwable t) {
        Log.e("ERROR - Company Information : \n", t.getMessage());
        Toast.makeText(this, "Error fetching company information.", Toast.LENGTH_SHORT).show();
    }

    private String buildCompanyProfileMessage(Company companyInfo) {
        StringBuilder companyProfileStringBuilder = new StringBuilder();
        companyProfileStringBuilder.append(companyInfo.getName());
        companyProfileStringBuilder.append(" was founded by ");
        companyProfileStringBuilder.append(companyInfo.getFounder());
        companyProfileStringBuilder.append(" in ");
        companyProfileStringBuilder.append(companyInfo.getFounded());
        companyProfileStringBuilder.append(".");
        companyProfileStringBuilder.append(" it has now ");
        companyProfileStringBuilder.append(companyInfo.getEmployees());
        companyProfileStringBuilder.append(" employees, ");
        companyProfileStringBuilder.append(companyInfo.getLaunchSites());
        companyProfileStringBuilder.append(" launch sites, and is values at USD ");
        companyProfileStringBuilder.append(companyInfo.getValuation());

        return companyProfileStringBuilder.toString();
    }

    /* LAUNCHES METHODS */
    @Override
    public void showLaunchesProgressBar() {
        launchesProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLaunchesProgressBar() {
        launchesProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(List<LaunchListResponse> launchesList) {
        launchListResponses.addAll(launchesList);
        launchesRecyclerAdapter = new LaunchesRecyclerAdapter(launchesList, MainActivity.this, this);
        launchesRecyclerView.setAdapter(launchesRecyclerAdapter);
    }

    @Override
    public void onLaunchClicked(int position) {

        String articleLink = launchListResponses.get(position).getLinks().getArticleLink();
        String wikiLink = launchListResponses.get(position).getLinks().getWikipedia();
        String youtubeVideoLink = launchListResponses.get(position).getLinks().getVideoLink();

        openLinksSelectionDialog(articleLink, wikiLink, youtubeVideoLink);
    }

    @Override
    public void onLaunchesResponseFailure(Throwable t) {
        Log.e("ERROR - Launches list : \n", t.getMessage());
        Toast.makeText(this, "Error fetching list of launches.", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icon_filter_imageview:
                showFilterDialog();
        }
    }

    public void openLinksSelectionDialog(String articleLink, String wikiLink, String youtubeLink) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View linksDialogView = inflater.inflate(R.layout.links_dialog_view_layout, null);
        dialogBuilder.setView(linksDialogView);
        dialogBuilder.setTitle("Open Link to Read / View");
        dialogBuilder.setCancelable(true);

        ImageView articleIcon = linksDialogView.findViewById(R.id.article_icon_imageview);
        ImageView wikiIcon = linksDialogView.findViewById(R.id.wiki_icon_imageview);
        ImageView youtubeIcon = linksDialogView.findViewById(R.id.youtube_icon_imageview);

        articleIcon.setOnClickListener(v -> startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse(articleLink))));

        wikiIcon.setOnClickListener(v -> startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse(wikiLink))));

        youtubeIcon.setOnClickListener(v -> startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse(youtubeLink))));

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    public void showFilterDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View filterDialogView = inflater.inflate(R.layout.filter_dialog_view_layout, null);

        Spinner yearsSpinner, successSpinner, ascDescSpinner;

        yearsSpinner =  filterDialogView.findViewById(R.id.years_spinner);
        successSpinner =  filterDialogView.findViewById(R.id.success_spinner);
        ascDescSpinner =  filterDialogView.findViewById(R.id.asc_desc_spinner);

        dialogBuilder.setView(filterDialogView)
                .setPositiveButton("Filter Launches", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String selectedYear, selectedSuccessStatus, selectedAscOrDesc;

                        selectedYear = yearsSpinner.getSelectedItem().toString();
                        selectedSuccessStatus = successSpinner.getSelectedItem().toString();
                        selectedAscOrDesc = ascDescSpinner.getSelectedItem().toString();

                        Toast.makeText(MainActivity.this, selectedYear + " - " + selectedSuccessStatus
                                + " - " + selectedAscOrDesc , Toast.LENGTH_SHORT).show();

                        getFilteredList(selectedYear, selectedSuccessStatus, selectedAscOrDesc);
                    }
                });
        dialogBuilder.setTitle("Filter Launches");
        dialogBuilder.setCancelable(true);
        dialogBuilder.setIcon(R.drawable.icon_funnel);

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void getFilteredList(String selectedYear, String selectedSuccessStatus, String selectedAscOrDesc) {
        // TODO : action data filtering & sorting & update view
        Collections.sort(launchListResponses, new Comparator<LaunchListResponse>() {
            @Override
            public int compare(LaunchListResponse o1, LaunchListResponse o2) {

               return selectedYear.compareToIgnoreCase(selectedYear);
            }
        });
    }
}
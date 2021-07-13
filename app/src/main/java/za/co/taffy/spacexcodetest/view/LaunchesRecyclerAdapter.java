package za.co.taffy.spacexcodetest.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import za.co.taffy.spacexcodetest.R;
import za.co.taffy.spacexcodetest.model.LaunchListResponse;

public class LaunchesRecyclerAdapter extends RecyclerView.Adapter<LaunchesRecyclerAdapter.ViewHolder> implements View.OnClickListener {

    private List<LaunchListResponse> launchesList;
    private Context context;
    private OnLaunchListener mOnLaunchListener;

    public LaunchesRecyclerAdapter(List<LaunchListResponse> launchesList, Context context, OnLaunchListener onLaunchListener) {
        this.launchesList = launchesList;
        this.context = context;
        this.mOnLaunchListener = onLaunchListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_launch_item_layout, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view, mOnLaunchListener);
    }

    @SuppressLint({"ResourceType", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // mission patch icon
        Glide.with(context)
                .load(launchesList.get(position).getLinks().getMissionPatchSmall())
                .centerCrop()
                .placeholder(R.drawable.icon_placeholder)
                .into(holder.missionIconImageview);

        holder.missionNameTextview.setText(launchesList.get(position).getMissionName());
        holder.rocketNameTextview.setText(launchesList.get(position).getRocket().getRocketName());
        holder.dateTextview.setText(launchesList.get(position).getLaunchDateLocal().substring(0, 10));
        holder.timeTextview.setText(launchesList.get(position).getLaunchDateLocal().substring(11, 16));
        holder.daysLabelTextview.setText(getFromOrSinceLabel(getDifferenceDays(launchesList.get(position).getLaunchDateUnix().toString())));
        holder.daysTextview.setText(getDifferenceDays(getDifferenceDays(launchesList.get(position).getLaunchDateUnix().toString())));

        // success icon
        holder.missionSuccessImageview.setImageResource(determineSuccessIcon(launchesList.get(position).getLaunchSuccess()));
    }

    public String getDifferenceDays(String launchDateString) {
        Date today = Calendar.getInstance().getTime();
        Date launchDate = new java.util.Date(Long.parseLong(launchDateString));

        int daysdiff = 0;
        long diff = today.getTime() - launchDate.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
        daysdiff = (int) diffDays;
        return ""+ daysdiff;
    }

    public String getFromOrSinceLabel(String launchDateString){
        Date today = Calendar.getInstance().getTime();
        Date launchDate = new java.util.Date(Long.parseLong(launchDateString));

        if(today.getTime() > launchDate.getTime()){
            return "Days \nsince now:";
        }else{
            return "Days \nfrom now:";
        }
    }

    private int determineSuccessIcon(Boolean success) {
        if(success == null){
            return R.drawable.icon_unsuccessful;
        }
        if (success) {
            return R.drawable.icon_success;
        } else {
            return R.drawable.icon_unsuccessful;
        }
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "click click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return launchesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView missionIconImageview, missionSuccessImageview;
        public TextView missionNameTextview, dateTextview, timeTextview, rocketNameTextview, daysTextview, daysLabelTextview;
        OnLaunchListener onLaunchListener;
        public ViewHolder(View itemView, OnLaunchListener onLaunchListener) {

            super(itemView);
            this.onLaunchListener = onLaunchListener;

            missionIconImageview = itemView.findViewById(R.id.icon_mission_patch_imageview);
            missionSuccessImageview = itemView.findViewById(R.id.icon_launch_success_imageview);
            missionNameTextview = itemView.findViewById(R.id.mission_name_textview);
            dateTextview = itemView.findViewById(R.id.date_textview);
            timeTextview = itemView.findViewById(R.id.time_textview);
            rocketNameTextview = itemView.findViewById(R.id.rocket_name_textview);
            daysTextview = itemView.findViewById(R.id.days_textview);
            daysLabelTextview = itemView.findViewById(R.id.days_label_textview);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onLaunchListener.onLaunchClicked(getAdapterPosition());
        }
    }

    public interface OnLaunchListener{
        void onLaunchClicked(int position);
    }
}

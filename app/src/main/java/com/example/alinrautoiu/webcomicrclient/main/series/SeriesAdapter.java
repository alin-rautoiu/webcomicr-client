package com.example.alinrautoiu.webcomicrclient.main.series;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alinrautoiu.webcomicrclient.R;
import com.example.alinrautoiu.webcomicrclient.common.Episode;
import com.example.alinrautoiu.webcomicrclient.common.Series;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alin.rautoiu on 10.08.2016.
 */
public class SeriesAdapter extends RecyclerView.Adapter<SeriesViewHolder> {
    private ArrayList<Series> series;
    private Context context;

    public SeriesAdapter(Context context) {
        this.context = context;
        series = new ArrayList<>();
    }

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_series_list, parent, false);

        return new SeriesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SeriesViewHolder holder, int position) {
        Series aSeries = series.get(position);
        holder.titleTextView.setText(aSeries.name);
        holder.id = aSeries.id;

        Uri uri = Uri.parse(aSeries.thumbnail);
        Picasso.with(holder.thumbnailImageView.getContext())
                .load(uri)
                .into(holder.thumbnailImageView);
    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    public void addSeries(List<Series> series) {
        this.series.clear();
        this.series.addAll(series);
        notifyDataSetChanged();
    }

    public void setOnClickCallback() {
    }
}

package com.example.alinrautoiu.webcomicrclient.main.episodes;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alinrautoiu.webcomicrclient.R;
import com.example.alinrautoiu.webcomicrclient.common.Episode;
import com.example.alinrautoiu.webcomicrclient.main.comic.ComicsViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alin.rautoiu on 10.08.2016.
 */
public class EpisodesAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {
    private ArrayList<Episode> episodes;
    private Context context;

    public EpisodesAdapter(Context context) {
        this.context = context;
        episodes = new ArrayList<>();
    }

    @Override
    public EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_episode_list, parent, false);

        return new EpisodeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EpisodeViewHolder holder, int position) {
        Episode episode = episodes.get(position);
        holder.titleTextView.setText(episode.name);
        holder.id = episode.id;

        Uri uri = Uri.parse(episode.thumbnail.replace(" ", "%20"));
        Picasso.with(holder.thumbnailImageView.getContext())
                .load(uri)
                .into(holder.thumbnailImageView);
    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }

    public void addEpisodes(List<Episode> episodes) {
        this.episodes.clear();
        this.episodes.addAll(episodes);
        notifyDataSetChanged();
    }

    public void setOnClickCallback() {
    }
}

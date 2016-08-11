package com.example.alinrautoiu.webcomicrclient.main.comic;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alinrautoiu.webcomicrclient.R;
import com.example.alinrautoiu.webcomicrclient.common.ComicPanel;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alin.rautoiu on 09.08.2016.
 */
public class ComicAdapter extends RecyclerView.Adapter<ComicsViewHolder> {

    private List<ComicPanel> panels;

    public ComicAdapter() {
        panels = new LinkedList<>();
    }

    @Override
    public ComicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comic, parent, false);

        return new ComicsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ComicsViewHolder holder, int position) {
        ComicPanel panel = panels.get(position);

        Uri uri = Uri.parse(panel.imageUrl.replace(" ", "%20"));
        Picasso.with(holder.panelImageView.getContext())
                .load(uri)
                .into(holder.panelImageView);
    }

    @Override
    public int getItemCount() {
        return panels == null ? 0 : panels.size();
    }

    public void addAll(List<ComicPanel> images) {
        panels.addAll(images);
        notifyDataSetChanged();
    }

    public void clear() {
        panels.clear();
    }

    public int getColSpan(int position) {
        return panels.get(position).colspan;
    }

}

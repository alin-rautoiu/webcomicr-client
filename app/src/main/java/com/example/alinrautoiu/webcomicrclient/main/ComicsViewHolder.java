package com.example.alinrautoiu.webcomicrclient.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.alinrautoiu.webcomicrclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alin.rautoiu on 09.08.2016.
 */
public class ComicsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.panel_iv) ImageView panelImageView;

    public ComicsViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}

package com.example.alinrautoiu.webcomicrclient.main.series;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alinrautoiu.webcomicrclient.R;
import com.example.alinrautoiu.webcomicrclient.common.EpisodeSelectedEvent;
import com.example.alinrautoiu.webcomicrclient.common.SeriesSelectedEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by alin.rautoiu on 10.08.2016.
 */
public class SeriesViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.thumbnail_iv)
    ImageView thumbnailImageView;
    @BindView(R.id.title_tv)
    TextView titleTextView;
    String id;

    @OnClick(R.id.episode_cv)
    void cardViewClicked(View view) {
        EventBus.getDefault().post(new SeriesSelectedEvent(id));
    }


    public SeriesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}

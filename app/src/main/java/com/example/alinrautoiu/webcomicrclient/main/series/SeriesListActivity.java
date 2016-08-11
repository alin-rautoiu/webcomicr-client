package com.example.alinrautoiu.webcomicrclient.main.series;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alinrautoiu.webcomicrclient.R;
import com.example.alinrautoiu.webcomicrclient.common.Episode;
import com.example.alinrautoiu.webcomicrclient.common.Series;
import com.example.alinrautoiu.webcomicrclient.main.episodes.EpisodesAdapter;
import com.example.alinrautoiu.webcomicrclient.main.episodes.EpisodesListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeriesListActivity extends AppCompatActivity {

    @BindView(R.id.series_rv)
    RecyclerView episodesListRecyclerView;
    SeriesListPresenter presenter;
    SeriesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_list);
        ButterKnife.bind(this);

        adapter = new SeriesAdapter(this);

        episodesListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        episodesListRecyclerView.setAdapter(adapter);

        presenter = new SeriesListPresenter(this);
        presenter.loadSeries();
    }

    public void displaySeries(List<Series> series) {
        adapter.addSeries(series);
    }
}

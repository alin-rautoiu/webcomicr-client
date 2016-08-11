package com.example.alinrautoiu.webcomicrclient.main.episodes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alinrautoiu.webcomicrclient.R;
import com.example.alinrautoiu.webcomicrclient.common.Episode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EpisodesListActivity extends AppCompatActivity {

    @BindView(R.id.episodes_rv)
    RecyclerView episodesListRecyclerView;
    EpisodesListPresenter presenter;
    EpisodesAdapter adapter;
    int seriesId;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, EpisodesListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes_list);
        ButterKnife.bind(this);

        Intent startIntent = getIntent();
        if(startIntent.getExtras() != null) {
            seriesId = startIntent.getExtras().getInt("SID");
        } else {
            seriesId = 1;
        }

        adapter = new EpisodesAdapter(this);

        episodesListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        episodesListRecyclerView.setAdapter(adapter);

        presenter = new EpisodesListPresenter(this);
        presenter.loadEpisodes(seriesId);
    }

    public void displayEpisodes(List<Episode> episodes) {
        adapter.addEpisodes(episodes);
    }
}

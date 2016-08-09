package com.example.alinrautoiu.webcomicrclient.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alinrautoiu.webcomicrclient.R;
import com.example.alinrautoiu.webcomicrclient.common.ComicPanel;
import com.example.alinrautoiu.webcomicrclient.common.Episode;
import com.example.alinrautoiu.webcomicrclient.common.Series;

import butterknife.BindView;
import butterknife.ButterKnife;



public class ComicBookDisplayActivity extends AppCompatActivity {

    @BindView(R.id.comic_rv) RecyclerView comicRecyclerView;
    private ComicAdapter comicAdapter;
    private ComicBookDisplayPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_book_display);
        ButterKnife.bind(this);

        comicRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        comicRecyclerView.setAdapter(comicAdapter = new ComicAdapter(2, 4, this));

        presenter = new ComicBookDisplayPresenter(this);
        presenter.loadPanels();
    }

    public void displayPanels(Series items) {
        comicAdapter.clear();
        Episode ep = items.episodes.get(0);
        comicAdapter.addAll(ep.images);
    }
}


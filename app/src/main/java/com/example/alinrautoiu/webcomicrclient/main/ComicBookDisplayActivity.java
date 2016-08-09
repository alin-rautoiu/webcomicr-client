package com.example.alinrautoiu.webcomicrclient.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.alinrautoiu.webcomicrclient.R;
import com.example.alinrautoiu.webcomicrclient.common.ComicPanel;
import com.example.alinrautoiu.webcomicrclient.common.Episode;
import com.example.alinrautoiu.webcomicrclient.common.Series;
import com.example.alinrautoiu.webcomicrclient.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;



public class ComicBookDisplayActivity extends AppCompatActivity {

    @BindView(R.id.comic_rv) RecyclerView comicRecyclerView;
    private ComicAdapter comicAdapter;
    private ComicBookDisplayPresenter presenter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_book_display);
        ButterKnife.bind(this);

        context = this;

        presenter = new ComicBookDisplayPresenter(this);
        presenter.loadPanels();
    }

    public void displayPanels(Series items) {
        Episode ep = items.episodes.get(0);

        int orientation = Utils.getOrientation(context);

        if (orientation == OrientationHelper.VERTICAL) {
            comicRecyclerView.setLayoutManager(
                    new GridLayoutManager(context, 2));
        } else {
            comicRecyclerView.setLayoutManager(
                    new GridLayoutManager(context, 4));
        }

        comicRecyclerView.setAdapter(comicAdapter = new ComicAdapter(2, 4, this));

        comicAdapter.clear();
        comicAdapter.addAll(ep.images);
    }
}


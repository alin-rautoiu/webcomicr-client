package com.example.alinrautoiu.webcomicrclient.main.comic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.example.alinrautoiu.webcomicrclient.R;
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
    int episodeId;
    public static Intent getStartIntent(Context context) {
        return new Intent(context, ComicBookDisplayActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_book_display);
        ButterKnife.bind(this);

        Intent startIntent = getIntent();
        if (startIntent.getExtras() != null) {
            episodeId = startIntent.getExtras().getInt("EPID");
        } else {
            episodeId = 1;
        }
        context = this;

        presenter = new ComicBookDisplayPresenter(this);
        presenter.loadPanels(episodeId);
    }

    public void displayPanels(Episode ep) {
        int orientation = Utils.getOrientation(context);

        if (orientation == OrientationHelper.VERTICAL) {
            comicRecyclerView.setLayoutManager(
                    new GridLayoutManager(context, 2));
        } else {
            comicRecyclerView.setLayoutManager(
                    new GridLayoutManager(context, 4));
        }

        comicRecyclerView.setAdapter(comicAdapter = new ComicAdapter());

        comicAdapter.clear();
        comicAdapter.addAll(ep.images);
    }
}


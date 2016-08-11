package com.example.alinrautoiu.webcomicrclient.main.series;

import android.content.Intent;

import com.example.alinrautoiu.webcomicrclient.base.App;
import com.example.alinrautoiu.webcomicrclient.common.Episode;
import com.example.alinrautoiu.webcomicrclient.common.EpisodeSelectedEvent;
import com.example.alinrautoiu.webcomicrclient.common.Series;
import com.example.alinrautoiu.webcomicrclient.common.SeriesSelectedEvent;
import com.example.alinrautoiu.webcomicrclient.main.comic.ComicBookDisplayActivity;
import com.example.alinrautoiu.webcomicrclient.main.episodes.EpisodesListActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by alin.rautoiu on 10.08.2016.
 */

public class SeriesListPresenter {
    SeriesListActivity view;

    public SeriesListPresenter(SeriesListActivity view) {
        EventBus.getDefault().register(this);
        this.view = view;
    }

    public void loadSeries() {
        App.getServerAPI()
                .getSeriesList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Series>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<Series> series) {
                        view.displaySeries(series);
                    }
                });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSeriesSelected(SeriesSelectedEvent event) {
        Intent startIntent = EpisodesListActivity.getStartIntent(view);
        startIntent.putExtra("SID", event.selectedSeries);
        view.startActivity(startIntent);
    }
}

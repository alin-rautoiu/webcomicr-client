package com.example.alinrautoiu.webcomicrclient.main.episodes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alinrautoiu.webcomicrclient.base.App;
import com.example.alinrautoiu.webcomicrclient.common.Episode;
import com.example.alinrautoiu.webcomicrclient.common.EpisodeSelectedEvent;
import com.example.alinrautoiu.webcomicrclient.common.Series;
import com.example.alinrautoiu.webcomicrclient.main.comic.ComicBookDisplayActivity;

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

public class EpisodesListPresenter {

    EpisodesListActivity view;

    public EpisodesListPresenter(EpisodesListActivity view) {
        EventBus.getDefault().register(this);
        this.view = view;
    }

    public void loadEpisodes() {
        App.getServerAPI()
                .getEpisodesList(1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Episode>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<Episode> episodes) {
                        view.displayEpisodes(episodes);
                    }
                });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEpisodeSelected(EpisodeSelectedEvent event) {
        Intent startIntent = ComicBookDisplayActivity.getStartIntent(view);
        startIntent.putExtra("EPID", event.selectedEpisode);
        view.startActivity(startIntent);
    }
}

package com.example.alinrautoiu.webcomicrclient.main.comic;

import com.example.alinrautoiu.webcomicrclient.base.App;
import com.example.alinrautoiu.webcomicrclient.common.Episode;
import com.example.alinrautoiu.webcomicrclient.common.Series;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by alin.rautoiu on 09.08.2016.
 */

public class ComicBookDisplayPresenter {

    private ComicBookDisplayActivity view;

    ComicBookDisplayPresenter(ComicBookDisplayActivity view) {
        this.view = view;
    }

    public void loadPanels(int episodeId) {
        App.getServerAPI()
                .getEpisode(episodeId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Episode>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Episode episode) {
                        view.displayPanels(episode);
                    }
                });
    }
}

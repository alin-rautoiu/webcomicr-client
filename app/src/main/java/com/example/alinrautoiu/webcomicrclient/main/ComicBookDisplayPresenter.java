package com.example.alinrautoiu.webcomicrclient.main;

import com.example.alinrautoiu.webcomicrclient.base.App;
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

    public void loadPanels() {
        App.getServerAPI()
                .getSeries(1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Series>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Series series) {
                        view.displayPanels(series);
                    }
                });
    }
}

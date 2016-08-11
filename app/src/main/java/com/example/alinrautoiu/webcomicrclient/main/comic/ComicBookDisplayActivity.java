package com.example.alinrautoiu.webcomicrclient.main.comic;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;

import com.example.alinrautoiu.webcomicrclient.R;
import com.example.alinrautoiu.webcomicrclient.common.Episode;
import com.example.alinrautoiu.webcomicrclient.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;



public class ComicBookDisplayActivity extends AppCompatActivity {

    private static final int MIN_COLUMN_COUNT = 1;
    private static final int MAX_COLUMN_COUNT = 4;
    @BindView(R.id.comic_rv) RecyclerView comicRecyclerView;
    @BindView(R.id.activity_comic_book_display) FrameLayout layout;

    ScaleGestureDetector scaleGestureDetector;
    private float firstSpanX;
    private float firstSpanY;

    //TODO Find a more correct way to get scale up/down events
    ScaleGestureDetector.OnScaleGestureListener scaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener() {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            firstSpanX = scaleGestureDetector.
                    getCurrentSpanX() * scaleGestureDetector.getScaleFactor();
            firstSpanY = scaleGestureDetector.
                    getCurrentSpanY() * scaleGestureDetector.getScaleFactor();

            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            float currentSpanX = scaleGestureDetector.getCurrentSpanX()
                    * scaleGestureDetector.getScaleFactor();
            float currentSpanY = scaleGestureDetector.getCurrentSpanY()
                    * scaleGestureDetector.getScaleFactor();
            if (currentSpanX > firstSpanX || currentSpanY > firstSpanY) {
                columnCount = Math.max(MIN_COLUMN_COUNT, columnCount - 1);
                updateColumnLayout();
            } else if (currentSpanX < firstSpanX || currentSpanY < firstSpanY) {
                columnCount = Math.min(MAX_COLUMN_COUNT, columnCount + 1);
                updateColumnLayout();
            }
        }
    };

    private void updateColumnLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, columnCount);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return Math.max(comicAdapter.getColSpan(position), MIN_COLUMN_COUNT);
            }
        });

        comicRecyclerView.setLayoutManager(gridLayoutManager);
    }

    ComicAdapter comicAdapter;
    ComicBookDisplayPresenter presenter;
    Context context;

    int episodeId;
    int columnCount;

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

        scaleGestureDetector = new ScaleGestureDetector(this, scaleGestureListener);
        comicRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                scaleGestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });

        presenter = new ComicBookDisplayPresenter(this);
        presenter.loadPanels(episodeId);
    }

    public void displayPanels(Episode ep) {
        int orientation = Utils.getOrientation(context);

        if (orientation == OrientationHelper.VERTICAL) {
            columnCount = 2;
        } else {
            columnCount = 4;
        }

        updateColumnLayout();
        comicRecyclerView.setAdapter(comicAdapter = new ComicAdapter());

        comicAdapter.clear();
        comicAdapter.addAll(ep.images);
    }
}


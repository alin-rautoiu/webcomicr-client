package com.example.alinrautoiu.webcomicrclient.network;

import com.example.alinrautoiu.webcomicrclient.common.Episode;
import com.example.alinrautoiu.webcomicrclient.common.Series;

import java.util.List;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by alin.rautoiu on 09.08.2016.
 */

public interface ServerAPI {

    public static final String ENDPOINT = "https://webcomicr.herokuapp.com";

    @GET("/getSeries/{id}")
    Observable<Series> getSeries(@Path("id") String  id);

    @GET("/getEpisodesList/{seriesId}")
    Observable<List<Episode>> getEpisodesList(@Path("seriesId") String  id);

    @GET("/getEpisode/")
    Observable<Episode> getEpisode( @Query("episodeId") String  episodeId);

    @GET("/getSeriesList/")
    Observable<List<Series>> getSeriesList();
}

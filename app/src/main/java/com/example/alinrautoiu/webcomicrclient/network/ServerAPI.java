package com.example.alinrautoiu.webcomicrclient.network;

import com.example.alinrautoiu.webcomicrclient.common.Series;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by alin.rautoiu on 09.08.2016.
 */

public interface ServerAPI {

    public static final String ENDPOINT = "https://webcomicr.herokuapp.com";

    @GET("/getSeries/{id}")
    Observable<Series> getSeries(@Path("id") int  id);
}

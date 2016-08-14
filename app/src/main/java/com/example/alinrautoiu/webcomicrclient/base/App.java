package com.example.alinrautoiu.webcomicrclient.base;

import android.app.Application;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.example.alinrautoiu.webcomicrclient.network.ServerAPI;

import io.fabric.sdk.android.Fabric;
import retrofit.RestAdapter;

/**
 * Created by alin.rautoiu on 09.08.2016.
 */

public class App extends Application {
    private static ServerAPI serverAPI;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        serverAPI = new RestAdapter.Builder()
                .setEndpoint(ServerAPI.ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String message) {
                        Log.v("Retrofit", message);
                    }
                })
                .build().create(ServerAPI.class);
    }

    public static ServerAPI getServerAPI() {
        return serverAPI;
    }
}

package com.example.alinrautoiu.webcomicrclient.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alin.rautoiu on 09.08.2016.
 */

public class Series {
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("episodes")
    public List<Episode> episodes;
    @SerializedName("thumbnail")
    public String thumbnail;
}

package com.example.alinrautoiu.webcomicrclient.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alin.rautoiu on 09.08.2016.
 */
public class ComicPanel {
    @SerializedName("id")
    public int id;
    @SerializedName("path")
    public String imageUrl;
    @SerializedName("colspan")
    public int colspan;
}

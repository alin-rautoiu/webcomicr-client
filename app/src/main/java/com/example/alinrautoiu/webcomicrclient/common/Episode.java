package com.example.alinrautoiu.webcomicrclient.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alin.rautoiu on 09.08.2016.
 */

public class Episode {
    @SerializedName("id")
    public int id;
    @SerializedName("row")
    public int rows;
    @SerializedName("columns")
    public int columns;
    @SerializedName("name")
    public String name;
    @SerializedName("images")
    public List<ComicPanel> images;
}

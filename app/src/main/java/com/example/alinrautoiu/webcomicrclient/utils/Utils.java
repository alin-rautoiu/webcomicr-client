package com.example.alinrautoiu.webcomicrclient.utils;

import android.content.Context;

/**
 * Created by Alin on 8/9/2016.
 */

public class Utils {
    public static int getOrientation(Context context) {
        return context.getResources().getConfiguration().orientation;
    }
}

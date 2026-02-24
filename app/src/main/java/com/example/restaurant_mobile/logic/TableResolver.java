package com.example.restaurant_mobile.logic;

import com.example.restaurant_mobile.R;

public class TableResolver {

    public static String resolve(int viewId) {
        if (viewId == R.id.viewT1) return "T1";
        if (viewId == R.id.viewT2) return "T2";
        if (viewId == R.id.viewT3) return "T3";
        if (viewId == R.id.viewT4) return "T4";
        if (viewId == R.id.viewT5) return "T5";
        if (viewId == R.id.viewT6) return "T6";
        return null;
    }
}

package com.example.restaurant_mobile.model;

public class TablePosition {

    public final float biasX;     // 0..1
    public final float biasY;     // 0..1
    public final float scale;     // 0..1 (relative to cell)
    public final float rotation; // degrees

    public TablePosition(float biasX, float biasY, float scale, float rotation) {
        this.biasX = biasX;
        this.biasY = biasY;
        this.scale = scale;
        this.rotation = rotation;
    }
}

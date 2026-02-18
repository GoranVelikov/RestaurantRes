package com.example.restaurant_mobile.ui.layout;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.restaurant_mobile.model.TablePosition;

public class TableLayoutHelper {

    public static void apply(View tableView, TablePosition position) {

        ConstraintLayout.LayoutParams params =
                (ConstraintLayout.LayoutParams) tableView.getLayoutParams();

        // Move inside cell
        params.horizontalBias = position.biasX;
        params.verticalBias = position.biasY;

        // Scale relative to allocated square
        params.matchConstraintPercentWidth = position.scale;
        params.matchConstraintPercentHeight = position.scale;

        tableView.setLayoutParams(params);

        // Rotation is visual, not layout
        tableView.setRotation(position.rotation);
    }
}

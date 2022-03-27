package com.github.hanyaeger.tutorial.entities.bubbles;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class PoisonBubble extends Bubble {

    public PoisonBubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation, speed);
        setFill(Color.GREENYELLOW);
        setStrokeColor(Color.GREEN);
    }
}

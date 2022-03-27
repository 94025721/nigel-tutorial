package com.github.hanyaeger.tutorial.entities.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.bubbles.AirBubble;
import com.github.hanyaeger.tutorial.entities.bubbles.PoisonBubble;

import java.util.Random;

public class BubbleSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;

    public BubbleSpawner(double sceneWidth, double sceneHeight) {
        super(1000);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        if (randomNumber() < 0.4) {
            spawn(new AirBubble(randomLocation(), randomSpeed()));
        } else {
            spawn(new PoisonBubble(randomLocation(), randomSpeed()));
        }
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) sceneWidth);
        return new Coordinate2D(x, 0);
    }

    private int randomSpeed() {
        int x = new Random().nextInt((int) 2);
        return x + 1;
    }

    private float randomNumber() {
        return (float) Math.random();
    }
}

package com.github.hanyaeger.tutorial.entities.bubbles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.Hanny;

import java.util.Random;

import static com.github.hanyaeger.api.scenes.SceneBorder.BOTTOM;

public class Bubble extends DynamicCircleEntity implements Collider, Collided, SceneBorderCrossingWatcher {
    protected int speed;

    protected Bubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation);
        this.speed = speed;
        setRadius(setRandomRadius());
        setOpacity(0.3d);
        setMotion(speed, 0d);
    }

    private double setRandomRadius() {
        return new Random().nextInt( 30) + 10;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Hanny) {
            var popSound = new SoundClip("audio/pop.mp3");
            popSound.play();
            remove();
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if(sceneBorder == BOTTOM) {
            remove();
        }
    }
}

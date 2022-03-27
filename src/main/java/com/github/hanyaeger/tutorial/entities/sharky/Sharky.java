package com.github.hanyaeger.tutorial.entities.sharky;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Sharky extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider {

    public Sharky(Coordinate2D initialLocation) {
        super("sprites/sharky.png", initialLocation, new Size(80,160), 1, 19);
        setMotion(1d, 90d);
        setAutoCycle(100);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight() - 81));
        setAnchorLocationX(0);
    }
}

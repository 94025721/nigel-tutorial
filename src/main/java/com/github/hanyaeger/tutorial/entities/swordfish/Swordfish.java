package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Swordfish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

    Coordinate2D initialLocation;

    public Swordfish(Coordinate2D initialLocation) {
        super(initialLocation);
        this.initialLocation = initialLocation;
        setMotion(1d, 270d);
    }

    @Override
    protected void setupEntities() {
        SwordfishSprite swordfishSprite = new SwordfishSprite(initialLocation);
        swordfishSprite.setAnchorPoint(AnchorPoint.CENTER_LEFT);
        addEntity(swordfishSprite);

        HitBox hitBox = new HitBox(initialLocation);
        hitBox.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(hitBox);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
        setAnchorLocationX(getSceneWidth());

    }
}

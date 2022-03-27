package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.bubbles.AirBubble;

import com.github.hanyaeger.tutorial.entities.map.Coral;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided, Collider {

    private int health = 3;
    private int score = 0;

    private final HealthText healthText;
    private final BubblesPoppedText bubblesPoppedText;
    private final Waterworld waterworld;

    public Hanny(Coordinate2D initialLocation, HealthText healthText, BubblesPoppedText bubblesPoppedText, Waterworld waterworld) {
        super("sprites/hanny.png", initialLocation, new Size(20,40), 1, 2);

        this.healthText = healthText;
        this.bubblesPoppedText = bubblesPoppedText;
        this.waterworld = waterworld;

        healthText.setHealthText(health);
        bubblesPoppedText.setBubblePoppedText(score);
        setGravityConstant(0.1d);
        setFrictionConstant(0.04d);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        int speed = 10;
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(speed,270d);
            setCurrentFrameIndex(0);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(speed,90d);
            setCurrentFrameIndex(1);
        } else if(pressedKeys.contains(KeyCode.UP)){
            setMotion(speed,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            setMotion(speed,0d);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);
        switch (border) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(Collider collidingObject){
        if (collidingObject instanceof AirBubble) {
            score++;
            bubblesPoppedText.setBubblePoppedText(score);
        }
        else if (collidingObject instanceof Coral) {
            setSpeed(0);
        }
        else {
            setAnchorLocation(
                    new Coordinate2D(new Random().nextInt((int)(getSceneWidth()
                            - getWidth())),
                            new Random().nextInt((int)(getSceneHeight() - getHeight())))
            );

            health--;
            healthText.setHealthText(health);
            if(health <= 0) {
                waterworld.setActiveScene(2);
            }
        }
    }
}

package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.buttons.ExitButton;
import com.github.hanyaeger.tutorial.entities.buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EndScene extends StaticScene {

    private Waterworld waterworld;

    public EndScene(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background3.jpg");
//        setBackgroundAudio("audio/ocean.mp3");
    }

    @Override
    public void setupEntities() {
        endText();
        retryButton();
        exitButton();
    }

    private void endText() {
        var endText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Game Over");
        endText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        endText.setFill(Color.DARKBLUE);
        endText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(endText);
    }

    private void retryButton() {
        var retryButton = new StartButton(
                new Coordinate2D(getWidth() / 2, 6 * getHeight() / 10),
                waterworld, "Retry");
        retryButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(retryButton);
    }

    private void exitButton() {
        var exitButton = new ExitButton(
                new Coordinate2D(getWidth() / 2, 7 * getHeight() / 10),
                waterworld);
        exitButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(exitButton);
    }

}

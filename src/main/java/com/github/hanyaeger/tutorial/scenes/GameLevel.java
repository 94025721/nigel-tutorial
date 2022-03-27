package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.map.CoralTileMap;
import com.github.hanyaeger.tutorial.entities.sharky.Sharky;
import com.github.hanyaeger.tutorial.entities.spawners.BubbleSpawner;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;


public class GameLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

    private final Waterworld waterworld;
    private HealthText healthText;
    private BubblesPoppedText bubblesPoppedText;

    public GameLevel(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new CoralTileMap());
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new BubbleSpawner(getWidth(), getHeight()));
    }

    @Override
    public void setupEntities() {
        swordfish();
        healthText();
        bubblesPoppedText();
        hanny();
        sharky();
    }

    private void swordfish() {
        Swordfish swordfish = new Swordfish(new Coordinate2D());
        addEntity(swordfish);
    }

    private void healthText() {
        healthText = new HealthText(new Coordinate2D(getWidth()/10, getHeight()/10)
        );
        addEntity(healthText);
    }

    private void bubblesPoppedText(){
        bubblesPoppedText = new BubblesPoppedText(new Coordinate2D(8*getWidth()/10, getHeight()/10));
        addEntity(bubblesPoppedText);
    }

    private void hanny() {
        var hanny = new Hanny(new Coordinate2D(getWidth()/2, getHeight()/2), healthText, bubblesPoppedText, waterworld);
        addEntity(hanny);
    }

    private void sharky() {
        Sharky sharky = new Sharky(new Coordinate2D());
        addEntity(sharky);
    }
}

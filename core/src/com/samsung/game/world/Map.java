package com.samsung.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.KeyHandler;

public class Map implements Runnable {

    private int worldX;
    private int worldY;
    public Array<Tile> tiles = new Array<Tile>();
    private KeyHandler keyH;

    public Map(int x, int y, KeyHandler keyH) {
        this.worldX = x;
        this.worldY = y;
        this.keyH = keyH;
        loadMap();
    }

    @Override
    public void run() {
        render();
    }

    public void render() {
        for (Tile tile : tiles) {
            tile.render();
        }
    }

    public void dispose() {
        for (Tile tile : tiles) {
            tile.dispose();
        }
    }


    private void loadMap() {
        FileHandle file = Gdx.files.internal("maps/map02.txt");
        String tils = file.readString().replaceAll(" ", "");
        String tiles[] = tils.split("\n");

        for (int i = 0; i < worldX; i++) {
            for (int j = 0; j < worldY; j++) {
                String til = String.valueOf(tiles[j].charAt(i));
                Tile tile = new Tile(i,-j,til,keyH);
                this.tiles.add(tile);
            }
        }
    }

}

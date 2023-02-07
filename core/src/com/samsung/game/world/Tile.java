package com.samsung.game.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.KeyHandler;

public class Tile {

    private int x;
    private int y;
    private int worldX;
    private int worldY;


    private final int defaultSize = 32;
    private final int scale = 3;
    private final int tileSize = defaultSize * scale;
    private int sprite;

    private KeyHandler keyH;
    private SpriteBatch batch;
    private Texture texture;

    public Tile(int x, int y, int sprite, KeyHandler keyH) {
        this.worldX = x * 32;
        this.worldY = y * 32;
        this.sprite = sprite;
        this.keyH = keyH;
        loadTexture();
    }

    public void render() {
        move();
        draw();
    }

    public void dispose() {
        texture.dispose();
        batch.dispose();
    }
    private void loadTexture(){
        if (sprite == 0){
            batch = new SpriteBatch();
            texture = new Texture("grass_block.png");
        }
    }

    private void move() {
        x = worldX + keyH.getX();
        y = worldY + keyH.getY();
    }

    private void draw() {
        batch.begin();
        batch.draw(texture, x, y, tileSize, tileSize);
        batch.end();
    }


}

package com.samsung.game.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.KeyHandler;

import java.awt.Rectangle;

public class Tile {

    private int x;
    private int y;
    private int worldX;
    private int worldY;

    private final int defaultSize = 32;
    private final int scale = 2;
    private final int tileSize = defaultSize * scale;
    private String sprite;

    private KeyHandler keyH;
    private SpriteBatch batch;
    private Texture texture;

    public Tile(int x, int y, String sprite, KeyHandler keyH) {
        this.worldX = x * tileSize;
        this.worldY = y * tileSize;
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
        if (sprite.equals("1")){
            batch = new SpriteBatch();
            texture = new Texture("textures/tiles/001.png");
        }else if (sprite.equals("2")){
            batch = new SpriteBatch();
            texture = new Texture("textures/tiles/002.png");
        }else if (sprite.equals("3")){
            batch = new SpriteBatch();
            texture = new Texture("textures/tiles/003.png");
        }else if (sprite.equals("4")){
            batch = new SpriteBatch();
            texture = new Texture("textures/tiles/004.png");
        }else if (sprite.equals("5")){
            batch = new SpriteBatch();
            texture = new Texture("textures/tiles/005.png");
        }else if (sprite.equals("6")){
            batch = new SpriteBatch();
            texture = new Texture("textures/tiles/006.png");
        }else if (sprite.equals("7")){
            batch = new SpriteBatch();
            texture = new Texture("textures/tiles/007.png");
        }else if (sprite.equals("8")){
            batch = new SpriteBatch();
            texture = new Texture("textures/tiles/008.png");
        }else if(sprite.equals("0")){
            batch = new SpriteBatch();
            texture = new Texture("textures/tiles/000.png");
        }
    }

    private void move() {
        x = (worldX + keyH.getX() * -1);
        y = (worldY + keyH.getY() * -1);
    }

    private void draw() {
        batch.begin();
        batch.draw(texture, x, y, tileSize, tileSize);
        batch.end();
    }

    public int getX(){return x;}
    public int getY(){return y;}
    public int getDefaultSize(){return defaultSize;}

}

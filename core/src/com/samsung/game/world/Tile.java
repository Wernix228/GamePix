package com.samsung.game.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.KeyHandler;
import com.samsung.game.entity.SolidArea;

import java.awt.Rectangle;

public class Tile {

    private int x;
    private int y;
    private int worldX;
    private int worldY;
    private boolean collision;

    private final int defaultSize = 32;
    private final int scale = 2;
    private final int tileSize = defaultSize * scale;

    private String sprite;
    private KeyHandler keyH;
    private SpriteBatch batch;
    private Texture texture;
    private SolidArea solidArea;

    public Tile(int x, int y, String sprite, KeyHandler keyH,boolean collision) {
        this.worldX = x * tileSize;
        this.worldY = y * tileSize;
        this.sprite = sprite;
        this.keyH = keyH;
        this.collision = collision;

        loadTexture();
        solidArea = new SolidArea(this,collision,keyH);
    }

    public void render() {
        move();
        draw();
        solidArea.render();
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

    public void getInfo(){
        solidArea.getInfo();
    }
}

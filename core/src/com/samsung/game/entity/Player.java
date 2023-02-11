package com.samsung.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.KeyHandler;
import com.samsung.game.world.Tile;

import java.awt.Rectangle;

public class Player extends Entity {
    private final KeyHandler keyH;

    private int xP;
    private int yP;

    public Player(KeyHandler keyH) {
        this.img = new Texture("textures/player/player.png");
        this.batch = new SpriteBatch();
        this.keyH = keyH;
        xP = Gdx.graphics.getWidth() / 2 - width;
        yP = Gdx.graphics.getHeight() / 2 - height;
    }

    public void render() {
        setCoordinates();
        draw();
        //getLocation();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void setCoordinates() {
        x = keyH.getX();
        y = keyH.getY();
    }

    private void draw() {

        batch.begin();
        batch.draw(img, xP, yP, width, height);
        batch.end();

    }

    private void getLocation() {
        System.out.println(x + "  " + y);
    }


}

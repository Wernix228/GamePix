package com.samsung.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.KeyHandler;

public class Player extends Entity {
    private final KeyHandler keyH;

    public Player(KeyHandler keyH) {
        this.img = new Texture("player.png");
        this.batch = new SpriteBatch();
        this.keyH = keyH;
    }

    public void render() {
        setCoordinates();
        draw();
        getLocation();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    private void setCoordinates() {
        x = keyH.getX();
        y = keyH.getY();
    }

    private void draw() {

        batch.begin();
        batch.draw(img, Gdx.graphics.getWidth()/2-width, Gdx.graphics.getHeight()/2-height, width, height);
        batch.end();

    }

    private void getLocation() {
        System.out.println(x + "  " + y);
    }


}

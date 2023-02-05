package com.samsung.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

    private SpriteBatch batch;
    private Texture img;
    private KeyHandler keyH;

    private int x;
    private int y;

    private int originalWidth = 32;
    private int originalHeight = 32;

    private int scale = 3;

    private int width = originalWidth * scale;
    private int height = originalHeight * scale;

    public Player(KeyHandler keyH) {
        this.img = new Texture("player.png");
        this.batch = new SpriteBatch();
        this.keyH = keyH;
    }

    public void render() {
        setCoordinates();
        draw(x,y);
//        getLocation();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    private void draw(int x,int y) {

        batch.begin();
        batch.draw(img, x, y, width, height);
        batch.end();

    }
    private void setCoordinates(){
        x = keyH.getPlayerX();
        y = keyH.getPlayerY();
    }
    private void getLocation(){
        System.out.println(x + "  " + y);
    }

}

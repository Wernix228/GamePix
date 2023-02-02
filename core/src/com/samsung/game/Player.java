package com.samsung.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

    SpriteBatch batch;
    Texture img;
    KeyHandler keyH;

    public  Player(KeyHandler keyH){
        this.img = new Texture("player.png");
        this.batch = new SpriteBatch();
        this.keyH = keyH;
    }
    public void render(){
        batch.begin();
        batch.draw(img,keyH.playerX,keyH.playerY,64,64);
        batch.end();
    }
    public void dispose(){
        batch.dispose();
        img.dispose();
    }

}

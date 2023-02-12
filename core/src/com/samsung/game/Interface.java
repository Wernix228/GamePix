package com.samsung.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Interface{

    SpriteBatch batch;
    SpriteBatch spriteBatch;
    Texture batchTexture;
    Texture texture;
    String platform;

    float scaleW;
    float scaleY;

    public Interface(String platform,float scaleW,float scaleY){
        this.platform = platform;
        this.scaleW = scaleW;
        this.scaleY = scaleY;
    }

    public Interface(String platform) {
        this.platform = platform;
    }

    public void create(){
        if (platform.equals("Android")){
            batch = new SpriteBatch();
            spriteBatch = new SpriteBatch();
            texture = new Texture("interface/field_touch.png");
            batchTexture = new Texture("interface/touch.png");
        }
    }
    public void render(){
        if (platform.equals("Android")) {
            batch.begin();
            spriteBatch.begin();
            batch.draw(texture, KeyHandler.controllerX(), KeyHandler.controllerY(), Gdx.graphics.getWidth() / 16 * 3 * scaleW, Gdx.graphics.getHeight() / 9 * 3 * scaleY);
//            if (KeyHandler.touchLimit()){
                spriteBatch.draw(batchTexture,Gdx.input.getX() - 150, Gdx.input.getY() * -1 + Gdx.graphics.getHeight() - 150);
//            }
            spriteBatch.end();
            batch.end();
        }
    }
    public void dispose(){
        if (platform.equals("Android")) {
            batch.dispose();
            spriteBatch.dispose();
            texture.dispose();
            batchTexture.dispose();
        }
    }

}

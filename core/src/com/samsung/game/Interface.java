package com.samsung.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Interface {

    SpriteBatch batch;
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

    }

    public void create(){
        if (platform.equals("Android")){
            batch = new SpriteBatch();
            texture = new Texture("interface/field_touch.png");
        }
    }
    public void render(){
        if (platform.equals("Android")) {
            batch.begin();
            batch.draw(texture, 0, 0, Gdx.graphics.getWidth() / 16 * 3 * scaleW, Gdx.graphics.getHeight() / 9 * 3 * scaleY);
            batch.end();
        }
    }
    public void dispose(){
        if (platform.equals("Android")) {
            batch.dispose();
            texture.dispose();
        }
    }

}

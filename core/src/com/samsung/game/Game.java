package com.samsung.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.entity.Player;
import com.samsung.game.world.Map;

public class Game extends ApplicationAdapter {
    KeyHandler keyH;
    Player player;
    SpriteBatch batch;
    Texture texture;
    Map map;

    String os;

    public Game(byte os){
        if (os == 1){
            this.os = "desktop";
        }else if (os == 2){
            this.os = "android";
        }else if (os == 3){
            this.os = "Html";
        }else if (os == 4){
            this.os = "IOS";
        }

    }
    @Override
    public void create() {

        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        keyH = new KeyHandler(0, 0, 4);
        map = new Map(30, 30, keyH);
        player = new Player(keyH);
        batch = new SpriteBatch();
        if (os.equals("android")){
            texture = new Texture("field_touch.png");
        }else texture = new Texture("badlogic.jpg");

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(.01f, .01f, .01f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        keyH.render();
        map.run();
        player.render();
        batch.begin();
        batch.draw(texture, 0, 0, Gdx.graphics.getWidth() / 5.12f, Gdx.graphics.getHeight() / 2.88f);
        batch.end();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        player.dispose();
        map.dispose();
        texture.dispose();
        batch.dispose();
    }
}

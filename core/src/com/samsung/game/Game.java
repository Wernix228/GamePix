package com.samsung.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Game extends ApplicationAdapter {

    KeyHandler keyH;
    Player player;

    @Override
    public void create() {

        keyH = new KeyHandler(100, 100, 4);
        player = new Player(keyH);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(.01f, .01f, .01f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        keyH.render();
        player.render();
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
        
    }
}

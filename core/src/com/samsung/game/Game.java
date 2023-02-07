package com.samsung.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.samsung.game.entity.Player;
import com.samsung.game.world.Map;

public class Game extends ApplicationAdapter {
    KeyHandler keyH;
    Player player;
    Map map;

    @Override
    public void create() {

        keyH = new KeyHandler(0, 0, 4);
        map = new Map(64,64,keyH);
        player = new Player(keyH);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(.01f, .01f, .01f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        keyH.render();
        map.run();
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
        map.dispose();
    }
}

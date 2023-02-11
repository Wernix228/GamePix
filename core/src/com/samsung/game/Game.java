package com.samsung.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.entity.Player;
import com.samsung.game.world.Map;
import com.samsung.game.world.Tile;

public class Game extends ApplicationAdapter {
    KeyHandler keyH;
    Player player;
    Map map;
    String platform;
    Interface anInterface;

    public Game(String platform) {
        this.platform = platform;
        anInterface = new Interface(platform);
    }

    @Override
    public void create() {

        anInterface.create();
        keyH = new KeyHandler(0, 0, 4,platform);
        map = new Map(25,25,keyH);
        player = new Player(keyH);

        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(.01f, .01f, .01f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        anInterface.render();
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

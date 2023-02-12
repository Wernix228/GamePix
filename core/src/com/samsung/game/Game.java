package com.samsung.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Array;
import com.samsung.game.entity.Player;
import com.samsung.game.entity.SolidArea;
import com.samsung.game.world.Map;
import com.samsung.game.world.Tile;

public class Game extends ApplicationAdapter {
    KeyHandler keyH;
    Player player;
    Map map;
    String platform;
    Interface anInterface;

    int timer = 0;
    boolean fullScreen;

    public Game(String platform) {
        this.platform = platform;
        anInterface = new Interface(platform);
    }
    public Game(String platform,boolean fullScreen,float scaleW,float scaleY) {
        this.platform = platform;
        anInterface = new Interface(platform,scaleW,scaleY);
        this.fullScreen = fullScreen;
    }

    @Override
    public void create() {

        anInterface.create();
        keyH = new KeyHandler(0, 0, 4,platform);
        player = new Player(keyH);
        map = new Map(50,50,keyH);
        if (fullScreen){
            Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        }

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(.01f, .01f, .01f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        keyH.render();
        map.run();
        player.render();
        anInterface.render();

        timer++;
        if (timer == 120){
            getInfo();
            timer = 0;
        }

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
    private void getInfo(){
//        map.getInfo();
        player.getLocation();
    }
}

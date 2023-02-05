package com.samsung.game;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera {

    private OrthographicCamera camera;
    private KeyHandler keyH;

    public Camera(KeyHandler keyH) {
        this.keyH = keyH;
        create();
    }

    public void render() {
        camera.translate(keyH.getPlayerX(), keyH.getPlayerY(), 0);
        camera.update();
    }

    private void create() {
        camera = new OrthographicCamera(100,100);
        camera.update();
    }


}

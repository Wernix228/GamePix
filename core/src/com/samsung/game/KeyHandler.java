package com.samsung.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;

public class KeyHandler {

    private int x;
    private int y;
    private int defaultSpeed;
    private int playerSpeed;
    private boolean boost;

    long lastDropTime = System.nanoTime();

    public KeyHandler(int playerX, int playerY, int playerSpeed) {
        this.x = playerX;
        this.y = playerY;
        this.defaultSpeed = playerSpeed;
    }

    public void render() {
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000) {
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                y += playerSpeed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                y -= playerSpeed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                x += playerSpeed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                x -= playerSpeed;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                boost = true;
            } else boost = false;
            if (boost) {
                boostSpeed();
            } else playerSpeed = 4;

            if (Gdx.input.isTouched()) {
                if (Gdx.input.getX() < 3 * Gdx.graphics.getWidth() / 15.36f && Gdx.input.getX() > 2 * Gdx.graphics.getWidth() / 15.36f && touchLimit()) {
                    x += playerSpeed;
                } else if (Gdx.input.getX() < Gdx.graphics.getWidth() / 15.36f && touchLimit()) {
                    x -= playerSpeed;
                }
                if (Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f / 3 && touchLimit()) {
                    y -= playerSpeed;
                }else if (Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f && Gdx.input.getY() < Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f / 2 && touchLimit()){
                    //pls FIX IT
                    y += playerSpeed;
                }
                System.out.println(Gdx.input.getY());
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPlayerX(int playerX) {
        this.x = playerX;
    }

    public void setPlayerY(int playerY) {
        this.y = playerY;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    private void boostSpeed() {
        playerSpeed = defaultSpeed * 2;
    }

    private boolean touchLimit() {
        boolean limitY = false;
        if (Gdx.input.getY() > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.88f && Gdx.input.getX() < Gdx.graphics.getWidth() / 5.12f) {
            limitY = true;
        }
        return limitY;
    }
}

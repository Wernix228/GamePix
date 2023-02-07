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
            }else boost = false;
            if (boost){
                boostSpeed();
            }else playerSpeed = 4;

            if (Gdx.input.isTouched()){
                x = Gdx.input.getX();
                y = Gdx.input.getY();
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
}

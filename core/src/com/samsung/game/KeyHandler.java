package com.samsung.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;

public class KeyHandler {

    int playerX;
    int playerY;
    int playerSpeed;
    boolean speedBoost;

    long lastDropTime = System.nanoTime();

    public KeyHandler(int playerX, int playerY, int playerSpeed) {
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerSpeed = playerSpeed;
    }

    public void render() {
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000) {
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                playerY += playerSpeed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                playerY -= playerSpeed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                playerX += playerSpeed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                playerX -= playerSpeed;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                playerY += playerSpeed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                playerY -= playerSpeed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                playerX -= playerSpeed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                playerX += playerSpeed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                speedBoost = true;
                boost();
            }else speedBoost = false;

            if (Gdx.input.isTouched()){
                playerX = Gdx.input.getX();
                playerY = (Gdx.input.getY() * -1) + Gdx.graphics.getWidth()/2;
            }


        }
    }
    private void boost(){
        playerSpeed = 8;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }
}

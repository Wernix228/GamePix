package com.samsung.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity{

    SpriteBatch batch;
    Texture img;

    int originalWidth = 32;
    int originalHeight = 32;

    int scale = 3;

    int width = originalWidth * scale;
    int height = originalHeight * scale;

    int x;
    int y;

}

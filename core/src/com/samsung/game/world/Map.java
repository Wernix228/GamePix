package com.samsung.game.world;

import com.samsung.game.KeyHandler;

public class Map implements Runnable{

    private int worldX;
    private int worldY;
    private Tile[][] field;
    private KeyHandler keyH;
    public Map(int x,int y,KeyHandler keyH){
        this.worldX = x;
        this.worldY = y;
        this.keyH = keyH;
        field = new Tile[worldX][worldY];
        loadMap();
    }
    @Override
    public void run() {
        render();
    }
    public void render(){
        for (int i = 0; i < worldX; i++) {
            for (int j = 0; j < worldY; j++) {
                field[i][j].render();
            }
        }
    }
    public void dispose(){
        for (int i = 0; i < worldX; i++) {
            for (int j = 0; j < worldY; j++) {
                field[i][j].dispose();
            }
        }
    }

    private void loadMap(){
        for (int i = 0; i < worldX; i++) {
            for (int j = 0; j < worldY; j++) {
                field[i][j] = new Tile(i,j,0,keyH);
            }
        }
    }

}

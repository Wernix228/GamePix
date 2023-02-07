package com.samsung.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.samsung.game.KeyHandler;

import java.io.*;

public class Map implements Runnable{

    private int worldX;
    private int worldY;
    private Tile[][] field;
    private KeyHandler keyH;
    private FileHandle fileH;
    private FileReader fr;
    private BufferedReader br;
    private File file;
    private int tempInt;
    public Map(int x,int y,KeyHandler keyH){
        this.worldX = x;
        this.worldY = y;
        this.keyH = keyH;
        loadFile();
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
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String[] sim = line.split(" ");

                field[i][j] = new Tile(i,j,Integer.parseInt(sim[j]),keyH);
            }
        }
    }
    private void loadFile(){
        fileH = Gdx.files.internal("maps/map01.txt");

        file = fileH.file();
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

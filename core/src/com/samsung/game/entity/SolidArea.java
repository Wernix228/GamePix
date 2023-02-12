package com.samsung.game.entity;

import com.samsung.game.KeyHandler;
import com.samsung.game.world.Tile;

public class SolidArea {

    Tile tile;
    KeyHandler keyH;

    boolean collision;

    public SolidArea(Tile tile, boolean collision, KeyHandler keyH){
        this.tile = tile;
        this.collision = collision;
        this.keyH = keyH;
    }

    public void render(){
        canMove();
    }

    private boolean canMove(){
        boolean move = false;

//        if (keyH.getX() == tile.getX() && collision){
//            System.out.println("lol"); Rabotaet
//
//        }


        return move;
    }

    public void getInfo(){
        System.out.println("Player:  " + keyH.getX() + "   " + keyH.getY());
    }
}

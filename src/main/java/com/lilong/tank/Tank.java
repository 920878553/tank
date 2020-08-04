package com.lilong.tank;

import java.awt.*;

/**
 * @author liLong
 * @date 2020/8/4 15:57
 * @description
 */

public class Tank {
    private int x;
    private int y;
    private DirEnum dir;

    private static final int SPEED=10;

    public Tank(int x, int y, DirEnum dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public DirEnum getDir() {
        return dir;
    }

    public void setDir(DirEnum dir) {
        this.dir = dir;
    }


    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
        switch (dir){
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
        }

    }



}

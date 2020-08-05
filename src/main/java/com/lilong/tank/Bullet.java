package com.lilong.tank;

import lombok.Data;

import java.awt.*;

/**
 * @author liLong
 * @date 2020/8/4 17:48
 * @description 子弹
 */
@Data
public class Bullet {
    private static final int SPEED=10;
    private int x;
    private int y;
    private DirEnum dir;
    private static final int WIDTH=20;
    private static final int HEIGHT=20;
    private boolean isLive=true;
    private TankFrame tankFrame=null;


    public Bullet() {
    }

    public Bullet(int x, int y, DirEnum dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame=tankFrame;
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
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        move();
        g.setColor(color);
    }

    public void move(){

        if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT){
            isLive=false;
        }
        if(!isLive){
            tankFrame.bullets.remove(this);
        }

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
            default:
                break;
        }
    }
}

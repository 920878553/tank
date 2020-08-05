package com.lilong.tank;

import lombok.Data;

import java.awt.*;
import java.util.Iterator;

/**
 * @author liLong
 * @date 2020/8/4 15:57
 * @description 坦克
 */
@Data
public class Tank {

    /**
     * tankFrame对象
     */
    private TankFrame tankFrame=null;
    /**
     * x轴坐标
     */
    private int x;

    /**
     * y轴坐标
     */
    private int y;

    /**
     * 坦克的方向
     */
    private DirEnum dir=DirEnum.DOWN;

    /**
     * 坦克的移动速度
     */
    private static final int SPEED=5;

    /**
     * 坦克是否 移动
     */
    private boolean isMoving = false;

    public Tank(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame =tankFrame;
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

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public void setDir(DirEnum dir) {
        this.dir = dir;
    }


    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,50,50);
        g.setColor(color);
       move();



    }

    private void move(){

        if (!isMoving) {
            return ;
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
        }
    }


    public void fireBullet() {



        if (tankFrame.bullets.size()<10) {

            tankFrame.bullets.add(new Bullet(x, y, dir,this.tankFrame));
        }


    }
}

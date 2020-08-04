package com.lilong.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author liLong
 * @date 2020/7/31 17:42
 * @description
 */
public class TankFrame extends Frame {
    Tank tank = new Tank(200, 200,this);
    Bullet bullet=new Bullet(300,300,tank.getDir());



    static final int GAME_WIDTH=800;
    static final int GAME_HEIGHT=600;


    public TankFrame() {
        setVisible(true);
        //设置 长，宽
        setSize(GAME_WIDTH,GAME_HEIGHT);
        //设置 不可修改长，宽
        setResizable(false);
        //设置 标题
        setTitle("tank war");
        //设置 窗口可关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new KeyListener());
    }
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }
    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        tank.paint(g);



    }


    class KeyListener extends KeyAdapter{
        boolean kl=false;
        boolean kr=false;
        boolean ku=false;
        boolean kd=false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key){
                case KeyEvent.VK_UP :
                    ku=true;
                    break;
                case KeyEvent.VK_DOWN :
                    kd=true;
                    break;
                case KeyEvent.VK_LEFT :
                    kl=true;
                    break;
                case KeyEvent.VK_RIGHT :
                    kr=true;
                    break;
                case KeyEvent.VK_SPACE:
                    tank.fireBullet();
                    break;
                default:
                    break;
            }
            tank.setMoving(true);
            setMainTankDirectory();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");

            switch (e.getKeyCode()){
                case KeyEvent.VK_UP :
                    ku=false;
                    break;
                case KeyEvent.VK_DOWN :
                    kd=false;
                    break;
                case KeyEvent.VK_LEFT :
                    kl=false;
                    break;
                case KeyEvent.VK_RIGHT :
                    kr=false;
                    break;
                default:
                    break;
            }
            tank.setMoving(false);
        }

        private void setMainTankDirectory(){

            if(ku){
                tank.setDir(DirEnum.UP);
            }

            if (kd) {
                tank.setDir(DirEnum.DOWN);
            }

            if (kl) {
                tank.setDir(DirEnum.LEFT);
            }

            if (kr) {
                tank.setDir(DirEnum.RIGHT);
            }

        }
    }
}

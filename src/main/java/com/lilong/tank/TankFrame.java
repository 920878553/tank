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
    private int x=50;
    private int y=50;
    Tank tank = new Tank(200, 200, DirEnum.DOWN);
    private static final int SPEED=10;
    public TankFrame() {
        setVisible(true);
        //设置 长，宽
        setSize(800,600);
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
                default:
                    break;
            }
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

package com.lilong.tank;


/**
 * @author liLong
 * @date 2020/7/31 17:17
 * @description
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
      TankFrame tankFrame=new TankFrame();
      while (true){
          Thread.sleep(50);
          tankFrame.repaint();
      }

    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Airstirke;

/**
 *
 * @author Dong
 */
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Random;

/**
 *
 * @author Dong
 */
public class Island {
    Image img;
    int x, y, speed;
    Random gen;

    Island(Image img, int x, int y, int speed, Random gen) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.gen = gen;
    }

     public void update() {
         y += speed;
         if (y >= 480) {
             y = -100;
             x = Math.abs(gen.nextInt() % (640 - 30));
         }
     }

     public void draw(Graphics g,ImageObserver obs) {
          g.drawImage(img, x, y, obs);
     }
    
}

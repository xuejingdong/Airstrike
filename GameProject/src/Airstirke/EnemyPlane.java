/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Airstirke;

/**
 *
 * @author Dong
 */
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Random;

/**
 *
 * @author Dong
 */
public class EnemyPlane {
    Image img;
    int x, y, sizeX, sizeY, speed;
    Random gen;
    boolean show;
    Random generator = new Random(1234567);
    GameEvents gameEvents;
   
    EnemyPlane(Image img, int speed, Random gen,GameEvents gameEvent){ 
        this.img = img;
        this.x = Math.abs(gen.nextInt() % (600 - 30));
        this.y = -20;
        this.speed = speed;
        this.gen = gen;
        this.show = true;
        sizeX = img.getWidth(null);
        sizeY = img.getHeight(null);
        this.gameEvents = gameEvent;
        System.out.println("w:" + sizeX + " y:" + sizeY);
    }

        public void update() {
            y += speed;
            //Collision part would be handled in collision detecter
            /*if(m.collision(x, y, sizeX, sizeY)) {
                show = false;
                // You need to remove this one and increase score etc
                gameEvents.setValue("Explosion");
                gameEvents.setValue("");
                this.reset();
                show = true;
            }
            else 
                gameEvents.setValue("");*/
        }
        
        public void reset() {
            this.x = Math.abs(generator.nextInt() % (600 - 30));
            this.y = -10;
        }

        public void draw(ImageObserver obs) {
            if (show) {
                g2.drawImage(img, x, y, obs);
            }
        }
    }

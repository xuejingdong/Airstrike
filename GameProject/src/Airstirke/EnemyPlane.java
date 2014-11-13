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
public class EnemyPlane {
    Image img;
    int x, y, width, height, speed;
    Random gen;
    boolean show;
    Random generator = new Random();
    GameEvents gameEvents;
   
    EnemyPlane(Image img, int speed, Random gen){ 
        this.img = img;
        this.x = Math.abs(gen.nextInt() % (600 - 30));
        this.y = -20;
        this.speed = speed;
        this.gen = gen;
        this.show = true;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        //this.gameEvents = gameEvent;
        System.out.println("w:" + width + " y:" + height);
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public int getHeight(){
        return this.height;
    }
       
    public void setX(int a){
        this.x = a;
    }
    
     public void setY(int b){
        this.y = b;
    }

        public void update() {
            y += speed;
            if(y > 430)
                this.reset();
        }
        public void update(int dum){
            show = false;
            //gameEvents.setValue("Explosion");
            //gameEvents.setValue("");
            this.reset();
            show = true;
        }
        
        public void reset() {
            this.x = Math.abs(generator.nextInt() % (600 - 30));
            this.y = -10;
        }

        public void draw(Graphics g,ImageObserver obs) {
            if (show) {
                g.drawImage(img, x, y, obs);
            }
        }
    }

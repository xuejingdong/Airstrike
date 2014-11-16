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
public class EnemyPlane extends GameObject{
    int damage;
    Random gen;
    boolean show;
    Random generator = new Random();
    GameEvents gameEvents;
   
    EnemyPlane(Image img, int speed, int damage, Random gen){ 
       super(img, Math.abs(gen.nextInt() % (600 - 30)),-20,speed);
       this.speed = speed;
       this.gen = gen;
       this.show = true;
       this.damage = damage;
       //this.gameEvents = gameEvent;
    }
    
    public int getDamage(){
        return this.damage;
    }
    
     public void setDamage(int d){
         this.damage = d;
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

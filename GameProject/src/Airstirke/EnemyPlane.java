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
    int damage,health;
    Random gen;
    boolean show;
    Random generator = new Random();
    GameEvents gameEvents;
   
    EnemyPlane(Image img,int health, int Yspeed, int damage, Random gen){ 
       super(img, Math.abs(gen.nextInt() % (600 - 30)),-20,Yspeed);
       this.health = health;
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
     
     public void reduceHealth(int h){
         this.health = health - h;
     }
    public void update() {
         y += Yspeed;
         if(y > 430)
            this.reset();
         if(this.health < 0)
             isDie();
    }
   
    //call explosion, and remove itself from the enemyPlane array
    public void isDie(){
        if(this.health < 0)
            GameWorld.enemyl.remove(this);
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

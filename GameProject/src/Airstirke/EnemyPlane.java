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
    boolean canShoot;
    int shootFreq;
    int direction;//0: from top, 1: from back
   
    EnemyPlane(Image img,int health, int damage,int direction,int y, int Yspeed,Random gen){ 
       super(img, Math.abs(gen.nextInt() % (600 - 30)),y,Yspeed);
       this.health = health;
       this.gen = gen;
       this.show = true;
       this.damage = damage;
       this.direction = direction;
       //this.gameEvents = gameEvent;
    }
    
    public int getDamage(){
        return this.damage;
    }
    
     public void setDamage(int d){
         this.damage = d;
     }
     
     public void reduceHealth(int d){
         this.health -= d;
     }
    //update for enemy planes come from both directions 
    public void update() {
        if(this.direction == 0){
            y += Yspeed;
            if(y > 430)
                this.reset();
            if(this.health <= 0)
                isDied();
        } 
        else{
           y += Yspeed;
           if(y < 0)
               this.reset();
           if(this.health <= 0)
               isDied();
        }
    }
   
    //call explosion, and remove itself from the enemyPlane array
    public void isDied(){
        GameWorld.enemyl.remove(this);
        GameWorld.explosions.add(new Explosion(x,y,1));
        System.out.println("enemy explosion");
    
    }
    public void reset() {
        if(this.direction == 0){
            this.x = Math.abs(generator.nextInt() % (600 - 30));
            this.y = -10;
        }
        else{
            this.x = Math.abs(generator.nextInt() % (600 - 30));
            this.y = 480;
        }
     }

     public void draw(Graphics g,ImageObserver obs) {
         if (show) {
             g.drawImage(img, x, y, obs);
         }
     }
}

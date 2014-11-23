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
    int enemyType;//1: green, 2: yellow, 3: white, 4: back
    int bullet_type;//1: green &yellow; 2: white;
    int bullet_damage;
    Image bullet_image;
   
    EnemyPlane(Image img,int enemyType,int health, int damage,int direction,int y, int Yspeed,Random gen,boolean canShoot){ 
       super(img, Math.abs(gen.nextInt() % (600 - 30)),y,Yspeed);
       this.enemyType = enemyType;
       this.health = health;
       this.gen = gen;
       this.show = true;
       this.damage = damage;
       this.direction = direction;
       this.canShoot = canShoot;
       int shootFreq = 0 ;
       if(enemyType == 1 || enemyType == 2){
           this.bullet_type = 1;
           this.bullet_damage = 2;
           this.bullet_image = GameWorld.enemyBulletSmall;
       }
       if(enemyType == 3){
           this.bullet_type = 2;
           this.bullet_damage = 4;
           this.bullet_image = GameWorld.enemyBulletBig;
           //this.gameEvents = gameEvent;
       }    
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
     
     public void shoot(){
         if(shootFreq%30 == 0 && show){
            Bullet enemyb;
            enemyb = new Bullet(bullet_image,x-width/10,y+5,bullet_damage,0,4);
            GameWorld.enemybl.add(enemyb);
         }
         if(shootFreq%30 == 0 && show&&enemyType ==3){
            Bullet enemyb;
            enemyb = new Bullet(bullet_image,x-width/10,y+5,bullet_damage,-1,4);
            GameWorld.enemybl.add(enemyb);
            enemyb = new Bullet(bullet_image,x+width/10,y+5,bullet_damage,0,4);
            GameWorld.enemybl.add(enemyb);
            enemyb = new Bullet(bullet_image,x+width/10,y+5,bullet_damage,1,4);
            GameWorld.enemybl.add(enemyb);
         }
     }
    //update for enemy planes come from both directions 
    public void update() {
        if(canShoot)
            this.shoot();
        if(this.direction == 0){
            if(y > 430){
                this.reset();
                //show = false;
            }
            if(this.health <= 0)
                isDied();
             y += Yspeed;
        } 
        else{
            if(y < 0){
               this.reset();
               //show = false;
           }
           if(this.health <= 0)
               isDied();
           y += Yspeed;
        }
        shootFreq++;
    }
   
    //call explosion, and remove itself from the enemyPlane array
    public void isDied(){
        GameWorld.enemyl.remove(this);
        GameWorld.explosions.add(new Explosion(x,y,1));
        //show = false;
        System.out.println("enemy explosion");
    }
    
    public void reset() {
        if(this.direction == 0){
            this.x = Math.abs(generator.nextInt() % (600 - 30));
            this.y = -10;
            //show = true;
        }
        else{
            this.x = Math.abs(generator.nextInt() % (600 - 30));
            this.y = 480;
            //show = true;
        }
     }

     public void draw(Graphics g,ImageObserver obs) {
         if (show) {
             g.drawImage(img, x, y, obs);
         }
     }
}

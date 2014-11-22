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
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.Observer;
import java.util.Observable;
import javax.imageio.ImageIO;

public class PlayerPlane extends GameObject implements Observer{
   
    int health,damage,bulletDamage;
    boolean boom;
    Image bulletImg, leftBulletImg, rightBulletImg;

    PlayerPlane(Image img, int damge,int x, int y, int Yspeed) {
         super(img,x,y,Yspeed);
         boom = false;
         health = 100;
         damage = damage;
         bulletDamage = 4;
         try{
             bulletImg = ImageIO.read(new File("Resources/bullet.png"));
             leftBulletImg = ImageIO.read(new File("Resources/bulletLeft.png"));
             rightBulletImg = ImageIO.read(new File("Resources/bulletRight.png"));
         }
         catch (Exception e) {
            System.out.print("No resources are found");
        }
    }
     public int getDamage(){
         return this.damage;
     }
     
     public void reduceHealth(int d){
         this.health -= d;
     }
     
     public void draw(Graphics g, ImageObserver obs){
        g.drawImage(img, x, y, obs);
    }
    
     private  void fire(){
        Bullet playerb;
        playerb = new Bullet(bulletImg,x+width/2,y,bulletDamage,-1,-3);
        GameWorld.playerbl.add(playerb);
        playerb = new Bullet(bulletImg,x+width/2,y,bulletDamage,0,-3);
        GameWorld.playerbl.add(playerb);
        playerb = new Bullet(bulletImg,x+width/2,y,bulletDamage,1,-3);
        GameWorld.playerbl.add(playerb);
        System.out.println("fire!");
           
     }
    
     public void update(Observable obj, Object arg) {
         GameEvents ge = (GameEvents) arg;
         if(ge.type == 1) {
             KeyEvent e = (KeyEvent) ge.event;
             switch (e.getKeyCode()) {    
                case KeyEvent.VK_LEFT:
                    if(x > 0)
                        x -= Yspeed;
	      	break; 
                case KeyEvent.VK_RIGHT:
                     if(x < 570)
                         x += Yspeed;
                break;
                case KeyEvent.VK_UP:
                     if(y > 0)
                         y -= Yspeed;
        	break; 
                case KeyEvent.VK_DOWN:
                     if(y < 400)
                         y += Yspeed;
	       	break;
             default:
            if(e.getKeyChar() == ' ') {
                    fire(); 
                  }
            else if(ge.type == 2) {
                String msg = (String)ge.event;
                if(msg.equals("Explosion")) {
                    System.out.println("Explosion! Reduce Health");
        
                }
            }
        }
     }
  }  

}
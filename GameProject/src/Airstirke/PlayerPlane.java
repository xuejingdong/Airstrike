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
import java.util.ArrayList;

public class PlayerPlane extends GameObject implements Observer{
   
    private int health,damage,bulletDamage;
    private int up,down,left,right,fire;
    private boolean boom;
    private Image bulletImg, leftBulletImg, rightBulletImg;
    private ArrayList <Bullet> myBulletList;
    private Image [] healthBars, healthImg;
    private GameObject healthbar;

    PlayerPlane(Image img, int damge,int x, int y, int Yspeed,int up, int down, int left, int right, int fire) {
         super(img,x,y,Yspeed);
         boom = false;
         health = 200;
         this.damage = damage;
         this.bulletDamage = 4;
         this.up = up;
         this.down = down;
         this.left = left;
         this.right = right;
         this.fire = fire;
         this.myBulletList = new ArrayList<Bullet>();
         this.healthBars = new Image[4];
         
         try{
             bulletImg = ImageIO.read(new File("Resources/bullet.png"));
             leftBulletImg = ImageIO.read(new File("Resources/bulletLeft.png"));
             rightBulletImg = ImageIO.read(new File("Resources/bulletRight.png"));
             healthBars[0] = ImageIO.read(new File("Resources/health.png"));
             healthBars[1] = ImageIO.read(new File("Resources/health1.png"));
             healthBars[2] = ImageIO.read(new File("Resources/health2.png"));
             healthBars[3] = ImageIO.read(new File("Resources/health3.png"));
         }
         catch (Exception e) {
            System.out.print("No resources are found");
        }
    }
     public int getDamage(){
         return this.damage;
     }
     
     public ArrayList<Bullet> getBulletList(){
         return this.myBulletList;
     }
     public void reduceHealth(int d){
         this.health -= d;
     }
     
     public void draw(Graphics g, ImageObserver obs){
        g.drawImage(img, x, y, obs);
        if(health > 150){
            healthbar = new GameObject(healthBars[0],x,y+width,Yspeed);
            healthbar.draw(g, obs);
        }
        
    }
    
     private  void fire(){
        Bullet playerb;
        playerb = new Bullet(bulletImg,x+width/3,y,bulletDamage,-2,-3);
        myBulletList.add(playerb);
        playerb = new Bullet(bulletImg,x+width/3,y,bulletDamage,0,-3);
        myBulletList.add(playerb);
        playerb = new Bullet(bulletImg,x+width/3,y,bulletDamage,2,-3);
        myBulletList.add(playerb);
        System.out.println("fire!");
           
     }
    
     public void update(Observable obj, Object arg) {
         GameEvents ge = (GameEvents) arg;
             if(ge.type == 1) {
                KeyEvent e = (KeyEvent) ge.event;
                int keyCode = e.getKeyCode();
                //System.out.println(keyCode);
                //System.out.println(left + " " + right + " "+ up + " "+ down+ " "+fire);
                if( keyCode == left) {
                    if(x > 0)
                        x -= Yspeed;
                } 
                else if(keyCode == right){
                    if(x < 570)
                        x += Yspeed;
                }
                else if(keyCode == up){   
                    if(y > 0)
                        y -= Yspeed;
                }
                else if(keyCode == down){
                    if(y < 400)
                        y += Yspeed;
                }
                else if(keyCode == fire) {
                    fire(); 
                }
           
             }
             else if(ge.type == 2) {
                String msg = (String)ge.event;
                if(msg.equals("Explosion")) {
                    System.out.println("Explosion! Reduce Health");
                }
           }
       }
 }
    
        


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
import java.awt.Rectangle;

public class Bullet {
    int x, y, speed, damage,width, height;
    Image img;
    boolean show;
    
    public Bullet(Image img, int x, int y, int damage, int speed){
        this.img = img;
        this.x = x;
        this.y = y;
        this.damage = damage;
        this.speed = speed;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.show = false;
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
    
    public int getDamge(){
        return this.damage;
    }
    public boolean getShow(){
        return this.show;
    }
    public void setX(int a){
        this.x = a;
    }
    
     public void setY(int b){
        this.y = b;
    }
     
     public void setShow(boolean s){
         this.show = s;
     }
     //update, if collision happen, make the bullet disappear?
     //if no collsion happen, fly out of the frame, and then?
   
    public void draw(Graphics g,ImageObserver obs) {
        if(show)  
            g.drawImage(img, x, y, obs);
     }
}

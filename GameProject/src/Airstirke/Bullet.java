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
    Rectangle bulletBox;
    Image img;
    
    public Bullet(Image img, int x, int y, int damage, int speed){
        this.img = img;
        this.x = x;
        this.y = y;
        this.damage = damage;
        this.speed = speed;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.bulletBox= new Rectangle(this.x, this.y, this.width, this.height);
    }
     public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
       
    public int getDamge(){
        return this.damage;
    }
    
    public Rectangle getRectangle(){
        return this.bulletBox;
    }
    
    public void setX(int a){
        this.x = a;
    }
    
     public void setY(int b){
        this.y = b;
    }
     //update, if collision happen, make the bullet disappear?
     //if no collsion happen, fly out of the frame, and then?
    public void update(){
        this.y = y + speed;
        //if(y < 0)
        
    }
}

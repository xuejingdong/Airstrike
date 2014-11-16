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

public class Bullet extends GameObject {
    int damage;
    boolean show;
    
    public Bullet(Image img, int x, int y, int damage, int speed){
        super(img,x,y,speed);
        this.damage = damage;
        this.show = false;
    }
         
    public int getDamge(){
        return this.damage;
    }
    public boolean getShow(){
        return this.show;
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

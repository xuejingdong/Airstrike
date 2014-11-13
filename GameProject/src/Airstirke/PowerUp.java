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

public class PowerUp {
    int x, y, width, height;
    Image img;
    int powerType;
    
    PowerUp(Image img, int x, int y, int speed, int powerType){
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.powerType = powerType;
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
        
    public int getPowerType(){
        return this.powerType;
    }
    
    public void setX(int a){
        this.x = a;
    }
    
     public void setY(int b){
        this.y = b;
     }
    public void draw(Graphics g, ImageObserver obs){
        g.drawImage(img, x, y, obs);
    
    }
}

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

public class PowerUp extends GameObject {
    int powerType;
    boolean collected;
    boolean show;
    
    PowerUp(Image img, int x, int y, int speed, int powerType){
        super(img,x,y,speed);
        this.powerType = powerType;
        this.collected = false;
        this.show = false;
    }
    
    public int getPowerType(){
        return this.powerType;
    }
    
    public boolean getShow(){
        return this.show;
    }
    
    public void setCollected(boolean c){
        this.collected = c;
    }
    
    public void setShow(boolean s){
        this.show = s;
    }
    
    public void update(){
        if(this.show && !this.collected)
            y = y + speed;
    }
    
    public void draw(Graphics g, ImageObserver obs){
        if(show && !collected)
            g.drawImage(img, x, y, obs);
    
    }
}

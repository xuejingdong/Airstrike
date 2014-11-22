/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Airstirke;

/**
 *
 * @author Dong
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class Explosion{
    private Image [] img;
    private int x,y;
    private int counter;
    private boolean finished;
    private int type;
    
    public Explosion( int x, int y, int t){
        this.x = x;
        this.y = y;
        this.counter = -1;
        this. finished = false;
        if(type == 1)
            this.img = GameWorld.smallExp;
        else 
            this.img = GameWorld.bigExp;
    }
    
    public boolean getFinished(){
        return this.finished;
    }
    public void update(){
        if(counter < img.length-1)
            counter ++;
        else{
            finished = true;
        }
    }
    
    public void draw(Graphics g,ImageObserver obs) {
         if (!finished) {
             g.drawImage(img[counter], x, y, obs);
         }
     }
}

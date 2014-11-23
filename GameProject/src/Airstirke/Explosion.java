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
    private int count;
    private boolean finished;
    private int type;//1 for small explosions, the other number for big ones
    
    public Explosion( int x, int y, int t){
        this.x = x;
        this.y = y;
        this.count = -1;
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
        if(count < img.length-2){
            count ++;
        }else{
            finished = true;
        }
    }
    
    public void draw(Graphics g,ImageObserver obs) {
         if (!finished) {
             g.drawImage(img[count], x, y, obs);
             //System.out.print(count);
         }
     }
}

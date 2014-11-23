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
        this.count = 0;
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

        if(count < img.length-1){
            //System.out.println(count);
            count ++;
            //System.out.println(count);
        }else{
            finished = true;
        }
    }
    
    public void draw(Graphics g,ImageObserver obs) {
         if (!finished) {
             System.out.println(count);
             g.drawImage(img[count-1], x, y, obs);
             //System.out.print(count);
         }
     }
}

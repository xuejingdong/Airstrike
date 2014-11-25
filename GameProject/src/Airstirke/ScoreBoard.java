/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Airstirke;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

/**
 *
 * @author Dong
 */
public class ScoreBoard extends Explosion{
    private int currentScore,x,y,Yspeed;
    private String content;
    private Image [] img;
    private int count = -1;
    private boolean finished;
            
    public ScoreBoard(Image [] img,int x, int y,int speed){
        super(x,y,img);
        this.Yspeed = speed;
        boolean finish = false;
    }
    
    public boolean getFinished(){
        return this.finished;
    }
    public void update(){
        if(count < img.length){
            System.out.println("I am in update");
            if(y > 480){
                count ++;
            }
            else{
                y += Yspeed;
            }
                
        }
        else 
            finished = true;
        
    }
    
    
    public void draw(Graphics g, ImageObserver obs){
        if (!finished ) {
             g.drawImage(img[count], x, y, obs);
         }
         
    
    }
    
}

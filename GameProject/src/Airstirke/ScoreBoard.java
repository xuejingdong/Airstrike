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
public class ScoreBoard extends GameObject{
    private int currentScore;
    
    public ScoreBoard(Image img, int x, int y, int Yspeed){
        super(img, x, y, Yspeed);
    }
    
    public void update(){
        
    }
    
    public void draw(Graphics g, ImageObserver obs){
         g.drawImage(img, x, y, obs);
    
    }
    
}

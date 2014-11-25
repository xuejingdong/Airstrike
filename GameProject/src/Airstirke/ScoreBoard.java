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
public class ScoreBoard {
    private int currentScore,x,y,Yspeed;
    private String content;
    private Player player;
    
    public ScoreBoard(int x, int y, int Yspeed,Player p){
        this.x = x;
        this.y = y;
        this.Yspeed = Yspeed;
        this.player = p;
    }
    
    public void update(){
        content = "Palyer"+ player.getPlayerID()+ ": "+player.getScore();
        System.out.println(content);
    }
    
    
    public void draw(Graphics g, ImageObserver obs){
         g.drawString(content, x, y);
    
    }
    
}

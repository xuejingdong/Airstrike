/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Airstirke;

/**
 *
 * @author Dong
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.Queue;
import java.util.LinkedList;
public class Player {
    private int life,ID, score;
    private PlayerPlane myPlane;
    private int up,down, left, right, fire;
    private int playerPlaneDamage = 10;
    private Image planeImg;
    private boolean planeChanged;
    
    public Player(int id, int life, int up, int down, int left, int right, int fire){
        this.life = life;
        this.ID = id;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.fire = fire;
        this.score = 0;
        this.planeChanged = false;
        try{
             planeImg = ImageIO.read(new File("Resources/myplane_1.png"));
             
         }
         catch (Exception e) {
            System.out.print("No resources are found in Player Class");
        }
        
         myPlane = new PlayerPlane(planeImg,playerPlaneDamage,100*ID,360,5,up,down,left,right,fire);
        
        
        
    }
    
    
    
    public int getScore(){
        return this.score;
    }
    
    public int getLife(){
        return this.life;
    }
    
    public PlayerPlane getPlane(){
        return this.myPlane;  
    }
    
    public void lifeDeduction(){
        this.life--;
    }
    
    public void addScore(int s){
        this.score += s;
    }
    
    public boolean isfinished(){
        return this.myPlane.getBoom();
        
    } 
}

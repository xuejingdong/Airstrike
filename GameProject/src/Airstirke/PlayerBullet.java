/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Airstirke;

import java.awt.Image;

/**
 *
 * @author Dong
 */

public class PlayerBullet extends Bullet{
    PlayerPlane player;
    public PlayerBullet(Image img, PlayerPlane player, int damage,int speed){
        super(img,player.getX(),player.getY(),damage,speed);
        this.player = player;
    }
    
    public void update(){
         this.y = y - this.speed;
         if(y < 0){
             this.show = false;
         }
    }
}

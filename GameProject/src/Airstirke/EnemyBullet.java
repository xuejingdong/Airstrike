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

public class EnemyBullet extends Bullet{
    EnemyPlane enemy;
    
    public EnemyBullet(Image img, EnemyPlane enemy, int damage,int speed){
        super(img,enemy.getX(),enemy.getY(),damage,speed);
        this.enemy = enemy;
    }
    
    public void update(){
         this.y = y + this.speed;
         if(y < 0){
             this.show = false;
         }
    }
}

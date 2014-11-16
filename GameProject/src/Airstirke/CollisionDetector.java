/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Airstirke;

/**
 *
 * @author Dong
 */
import java.awt.Rectangle;
import java.util.ArrayList;
public class CollisionDetector {
    public void playerVSplayer(PlayerPlane pp, PlayerPlane pp2){
        //check if there is intersection between 2 plane
        Rectangle pbox = new Rectangle(pp.getX(), pp.getY(), pp.getWidth(), pp.getWidth());
        Rectangle pbox2 = new Rectangle(pp2.getX(), pp2.getY(), pp2.getWidth(), pp2.getWidth());
        //if(pbox.intersects(pbox2))
           
    }
    public void playerVSenemy(PlayerPlane pp, ArrayList<EnemyPlane> el){
        for(int i =0; i < el.size(); i++){
            Rectangle pbox = new Rectangle(pp.getX(), pp.getY(), pp.getWidth(), pp.getWidth());
            Rectangle otherBBox = new Rectangle(el.get(i).getX(), el.get(i).getY(),el.get(i).getWidth(), el.get(i).getWidth());
            if(pbox.intersects(otherBBox)){//check intersection
                el.get(i).update(1); // update the enemy -> explosion
                pp.reduceHealth(el.get(i).getDamage()); // update player plane' health
            }    
        }
    }
    public void playerVSenemyBullet(PlayerPlane pp, Bullet b){
        
    }
    public void playerVSpowerup(PlayerPlane pp, PowerUp pu){
        Rectangle pbox = new Rectangle(pp.getX(), pp.getY(), pp.getWidth(), pp.getWidth());
        Rectangle powerbox = new Rectangle(pu.getX(), pu.getY(), pu.getWidth(), pu.getWidth());
        if(pbox.intersects(powerbox)){
            
        }
    }
}

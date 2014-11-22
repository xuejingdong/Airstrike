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
        Rectangle pbox = new Rectangle(pp.getX(), pp.getY(), pp.getWidth(), pp.getHeight());
        Rectangle pbox2 = new Rectangle(pp2.getX(), pp2.getY(), pp2.getWidth(), pp2.getHeight());
        //if(pbox.intersects(pbox2))
           
    }
    public void playerVSenemy(PlayerPlane pp){
        EnemyPlane enemy;
        Rectangle pbox = new Rectangle(pp.getX(), pp.getY(), pp.getWidth(), pp.getHeight());
        for(int i =0; i < GameWorld.enemyl.size(); i++){
            enemy = GameWorld.enemyl.get(i);
            Rectangle eBox = new Rectangle(enemy.getX(), enemy.getY(),enemy.getWidth(), enemy.getHeight());
            if(pbox.intersects(eBox)){//check intersection
                enemy.isDied();// update the enemy -> explosion
                pp.reduceHealth(enemy.getDamage()); // update player plane' health
                System.out.println("playerVSenemy collision");
            }    
        }
    }
    public void playerVSenemyBullet(PlayerPlane pp, ArrayList<Bullet> eb){
        
    }
    public void playerBulletVSenemyPlane(){
        Bullet bullet;
        EnemyPlane enemy;
        for(int i  = 0; i < GameWorld.playerbl.size(); i++){
            bullet = GameWorld.playerbl.get(i);
            Rectangle bulletBox = new Rectangle(bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight());
            for(int j = 0; j < GameWorld.enemyl.size(); j++){
                enemy = GameWorld.enemyl.get(j);
                Rectangle enemyBox = new Rectangle(enemy.getX(),enemy.getY(),enemy.getWidth(),enemy.getHeight());
                //check collision, 
                if(bulletBox.intersects(enemyBox)){
                    GameWorld.playerbl.remove(bullet);//remove bullet 
                    enemy.reduceHealth(bullet.getDamge());//reduce enemy health
                }
            }
        }
    }
    public void playerVSpowerup(PlayerPlane pp, PowerUp pu){
        Rectangle pbox = new Rectangle(pp.getX(), pp.getY(), pp.getWidth(), pp.getHeight());
        Rectangle powerbox = new Rectangle(pu.getX(), pu.getY(), pu.getWidth(), pu.getHeight());
        if(pbox.intersects(powerbox)){
            
        }
    }
}

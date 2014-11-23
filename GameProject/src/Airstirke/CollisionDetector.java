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
    
    GameEvents gameEvent;
    
    public CollisionDetector(GameEvents ge){
        this.gameEvent = ge;
    }
    
    public void playerVSplayer(PlayerPlane pp, PlayerPlane pp2){
        //check if there is intersection between 2 plane
        Rectangle pbox = new Rectangle(pp.getX(), pp.getY(), pp.getWidth(), pp.getHeight());
        Rectangle pbox2 = new Rectangle(pp2.getX(), pp2.getY(), pp2.getWidth(), pp2.getHeight());
        //if(pbox.intersects(pbox2))
           
    }
    public void playerVSenemy(Player player1,Player player2){
        EnemyPlane enemy;
        PlayerPlane p1 = player1.getPlane();
        PlayerPlane p2 = player2.getPlane();
        Rectangle p1_box = new Rectangle(p1.getX(), p1.getY(), p1.getWidth(), p1.getHeight());
        Rectangle p2_box = new Rectangle(p2.getX(), p2.getY(), p2.getWidth(), p2.getHeight());
        for(int i =0; i < GameWorld.enemyl.size(); i++){
            enemy = GameWorld.enemyl.get(i);
            Rectangle eBox = new Rectangle(enemy.getX(), enemy.getY(),enemy.getWidth(), enemy.getHeight());
            if(p1_box.intersects(eBox)){//check intersection
                enemy.isDied();// update the enemy -> explosion
                gameEvent.setValue("Collision"); // update player plane' health
                
            }
            if(p2_box.intersects(eBox)){//check intersection
                enemy.isDied();// update the enemy -> explosion
                gameEvent.setValue("Collision"); // update player plane' health
                System.out.println("playerVSenemy collision");
            }
            
        }
    }
    public void playerVSenemyBullet(PlayerPlane pp, ArrayList<Bullet> eb){
        
    }
    public void playerBulletVSenemyPlane(Player player1,Player player2){
        Bullet bullet;
        EnemyPlane enemy;
        ArrayList<Bullet> player1_bl = player1.getPlane().getBulletList();
        ArrayList<Bullet> player2_bl = player2.getPlane().getBulletList();
        for(int i  = 0; i < player1_bl.size(); i++){
            bullet = player1_bl.get(i);
            Rectangle bulletBox = new Rectangle(bullet.getX(),bullet.getY(),bullet.getWidth(),bullet.getHeight());
            for(int j = 0; j < GameWorld.enemyl.size(); j++){
                enemy = GameWorld.enemyl.get(j);
                Rectangle enemyBox = new Rectangle(enemy.getX(),enemy.getY(),enemy.getWidth(),enemy.getHeight());
                //check collision, 
                if(bulletBox.intersects(enemyBox)){
                    player1_bl.remove(bullet);//remove bullet from list 
                    player1.addScore(enemy.getDamage());
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Airstirke;

/**
 *
 * @author Dong
 */
import java.util.List;
public class CollisionDetector {
    public boolean playerVSplayer(PlayerPlane pp, PlayerPlane pp2){
        //check if there is intersection between 2 plane
        if((pp.getRectangle()).intersects(pp2.getRectangle()))
            return true;
        return false;
    }
    public void playerVSenemy(PlayerPlane pp, List<EnemyPlane> el){
        for(int i =0; i < el.size(); i++){
            if((pp.getRectangle()).intersects(el.get(i).getRectangle()))
                el.get(i).update(1);
        }
    }
    public boolean playerVSenemyBullet(PlayerPlane pp, Bullet b){
        if((pp.getRectangle()).intersects(b.getRectangle()))
            return true;
        return false;
    }
    public boolean playerVSpowerup(PlayerPlane pp, PowerUp pu){
        if((pp.getRectangle()).intersects(pu.getRectangle()))
            return true;
        return false;
    }
}

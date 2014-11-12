/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Airstirke;

/**
 *
 * @author Dong
 */
public class CollisionDetector {
    public boolean playerVSplayer(PlayerPlane pp, PlayerPlane pp2){
        //check if there is intersection between 2 plane
        if((pp.getRectangle()).intersects(pp2.getRectangle()))
            return true;
        return false;
    }
    public boolean playerVSenemy(PlayerPlane pp, EnemyPlane pe){
        if((pp.getRectangle()).intersects(pe.getRectangle()))
            return true;
        return false;
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

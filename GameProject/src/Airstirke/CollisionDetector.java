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
        return false;
    }
    public boolean playerVSenemy(PlayerPlane pp, EnemyPlane pe){
        return false;
    }
    public boolean playerVSenemyBullet(PlayerPlane pp, Bullet b){
        return false;
    }
    public boolean playerVSpowerup(PlayerPlane a, PowerUp pu){
        return false;
    }
}

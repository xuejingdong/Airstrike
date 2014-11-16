/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Airstirke;

/**
 *
 * @author Dong
 */
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.Observer;
import java.util.Observable;

public class PlayerPlane extends GameObject implements Observer{
   
    int health;
    boolean boom;

    PlayerPlane(Image img, int x, int y, int speed) {
         super(img,x,y,speed);
         boom = false;
         health = 100;
    }
  
     public void reduceHealth(int d){
         this.health -= d;
     }
     
     public void draw(Graphics g, ImageObserver obs){
        g.drawImage(img, x, y, obs);
    
    }
  
        public void update(Observable obj, Object arg) {
            GameEvents ge = (GameEvents) arg;
            if(ge.type == 1) {
                KeyEvent e = (KeyEvent) ge.event;
                switch (e.getKeyCode()) {    
                    case KeyEvent.VK_LEFT:
                        if(x > 0)
                            x -= speed;
	        	break; 
                    case KeyEvent.VK_RIGHT:
                        if(x < 570)
                            x += speed;
	        	break;
                    case KeyEvent.VK_UP:
                        if(y > 0)
                            y -= speed;
	        	break; 
                    case KeyEvent.VK_DOWN:
                        if(y < 400)
                            y += speed;
	        	break;
                    default:
                  if(e.getKeyChar() == ' ') {
                      
                      for(int h = 0, i =-1; h < 3|| i <2; h++){
                           if(!(AirstrikeGameWorld.playerbl.get(h)).getShow()){
                               (AirstrikeGameWorld.playerbl.get(h)).setX(this.x + i+10);
                               (AirstrikeGameWorld.playerbl.get(h)).setShow(true);
                                i += 10;
                                System.out.println("Fire");
                           }
                      }
                  }
            else if(ge.type == 2) {
                String msg = (String)ge.event;
                if(msg.equals("Explosion")) {
                    System.out.println("Explosion! Reduce Health");
        
                }
            }
        }
     }
  }  

}
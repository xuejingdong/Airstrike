/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Airstirke;

/**
 *
 * @author Dong
 */
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.Observer;
import java.util.Observable;

public class PlayerPlane implements Observer{
    Image img;
        int x, y, speed, width, height;
        Rectangle bbox;
        boolean boom;

        PlayerPlane(Image img, int x, int y, int speed) {
            this.img = img;
            this.x = x;
            this.y = y;
            this.speed = speed;
            width = img.getWidth(null);
            height = img.getHeight(null);
            boom = false;
        }

        public void draw(ImageObserver obs) {
            g2.drawImage(img, x, y, obs);
        }
        
        public boolean collision(int x, int y, int w, int h) {
            bbox = new Rectangle(this.x, this.y, this.width, this.height);
            Rectangle otherBBox = new Rectangle (x,y,w,h);
            if(this.bbox.intersects(otherBBox)) { 
                return true;
            }
            return false;
        }
      
        public void update(Observable obj, Object arg) {
            game1942WithObserver.GameEvents ge = (game1942WithObserver.GameEvents) arg;
            if(ge.type == 1) {
                KeyEvent e = (KeyEvent) ge.event;
                switch (e.getKeyCode()) {    
                    case KeyEvent.VK_LEFT:
                        if(x > 0)
                            x -= speed;
	        	break; 
                    case KeyEvent.VK_RIGHT:
                        if(x < 640)
                            x += speed;
	        	break;
                    case KeyEvent.VK_UP:
                        if(y > 0)
                            y -= speed;
	        	break; 
                    case KeyEvent.VK_DOWN:
                        if(y < 480)
                            y += speed;
	        	break;
                    default:
                  if(e.getKeyChar() == ' ') {
                      
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

 

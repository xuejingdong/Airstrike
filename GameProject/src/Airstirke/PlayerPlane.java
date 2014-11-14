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

public class PlayerPlane implements Observer{
    Image img;
    int x, y, speed, width, height;
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
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public void setX(int a){
        this.x = a;
    }
    
     public void setY(int b){
        this.y = b;
    }

     public void draw(Graphics g, ImageObserver obs){
        g.drawImage(img, x, y, obs);
    
    }
        
   /* public boolean collision(int x, int y, int w, int h) {
        bbox = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle otherBBox = new Rectangle (x,y,w,h);
        if(this.bbox.intersects(otherBBox)) { 
             return true;
        }
        return false;
    }*/
      
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
                      
                      for(int h = 0, i =-1; h < 4|| i <2; h++){
                           if(!(AirstrikeGameWorld.playerbl.get(h)).getShow()){
                               (AirstrikeGameWorld.playerbl.get(h)).setX(this.x + i);
                               (AirstrikeGameWorld.playerbl.get(h)).setShow(true);
                                i++;
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
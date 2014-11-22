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
import java.awt.event.*;
import java.awt.image.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class GameWorld extends JApplet implements Runnable{
    private Thread thread;
    Image sea;
    Image myPlane;
    static Image [] smallExp;
    static Image [] bigExp;
    private BufferedImage bimg;
    Graphics2D g2;
    int speed = 1, move = 0;
    Random generator = new Random(1234567);
    Island I1, I2, I3;
    PlayerPlane m;
    int w = 640, h = 480; // fixed size window game 
    EnemyPlane e1;
    GameEvents gameEvents;
    Bullet bullet;
    int eneCount = 10;
    int enemyPDamage = 5;
    int playerPlaneDamage = 10;
    CollisionDetector CD = new CollisionDetector();
    static ArrayList<EnemyPlane> enemyl = new ArrayList<EnemyPlane>();
    static ArrayList<Bullet> playerbl = new ArrayList<Bullet>();
    static ArrayList<Bullet> enemybl = new ArrayList<Bullet>();
       
    public void init() {
        setFocusable(true);
        setBackground(Color.white);
        Image island1, island2, island3, enemyImg, bulletImg;

        try {
        //sea = getSprite("Resources/water.png");
        sea = ImageIO.read(new File("Resources/water.png"));
        island1 = ImageIO.read(new File("Resources/island1.png"));
        island2 = ImageIO.read(new File("Resources/island2.png"));
        island3 = ImageIO.read(new File("Resources/island3.png"));
        myPlane = ImageIO.read(new File("Resources/myplane_1.png"));
        enemyImg = ImageIO.read(new File("Resources/enemy1_1.png"));
        bulletImg = ImageIO.read(new File("Resources/bullet.png"));
        //get small explosion image array
        /*smallExp[0] = ImageIO.read(new File("Resources/explosion1_1.png"));
        smallExp[1] = ImageIO.read(new File("Resources/explosion1_2.png"));
        smallExp[2] = ImageIO.read(new File("Resources/explosion1_3.png"));
        smallExp[3] = ImageIO.read(new File("Resources/explosion1_4.png"));
        smallExp[4] = ImageIO.read(new File("Resources/explosion1_5.png"));
        smallExp[5] = ImageIO.read(new File("Resources/explosion1_6.png"));
        //get big explosion image array
        bigExp[0] = ImageIO.read(new File("Resources/explosion2_1.png"));
        bigExp[1] = ImageIO.read(new File("Resources/explosion2_2.png"));
        bigExp[2] = ImageIO.read(new File("Resources/explosion2_3.png"));
        bigExp[3] = ImageIO.read(new File("Resources/explosion2_4.png"));
        bigExp[4] = ImageIO.read(new File("Resources/explosion2_5.png"));
        bigExp[5] = ImageIO.read(new File("Resources/explosion2_6.png"));
        bigExp[6] = ImageIO.read(new File("Resources/explosion2_7.png"));
        */
        I1 = new Island(island1, 100, 100, speed, generator);
        I2 = new Island(island2, 200, 400, speed, generator);
        I3 = new Island(island3, 300, 200, speed, generator);
        m = new PlayerPlane(myPlane,playerPlaneDamage, 300, 360, 5);
        
        for(int i = 0; i < eneCount; i++){
            enemyl.add( new EnemyPlane(enemyImg,2,enemyPDamage,2,generator));
        }
        
        gameEvents = new GameEvents();
        gameEvents.addObserver(m);
        KeyControl key = new KeyControl(gameEvents);
        addKeyListener(key);
        }
        catch (Exception e) {
            System.out.print("No resources are found");
        }
    }
    
    public void drawBackGroundWithTileImage() {
        int TileWidth = sea.getWidth(this);
        int TileHeight = sea.getHeight(this);

        int NumberX = (int) (w / TileWidth);
        int NumberY = (int) (h / TileHeight);

        for (int i = -1; i <= NumberY; i++) {
            for (int j = 0; j <= NumberX; j++) {
                g2.drawImage(sea, j * TileWidth, 
                        i * TileHeight + (move % TileHeight), TileWidth, 
                        TileHeight, this);
            }
        }
        move += speed;
    }

    public void drawDemo() {
            
            I1.update();
            I2.update();
            I3.update();
            //e1.update();
            CD.playerVSenemy(m);
            CD.playerBulletVSenemyPlane();
            for(int i = 0; i < enemyl.size(); i++){
                enemyl.get(i).update();
            }
            for(int i = 0; i < playerbl.size(); i++){
                playerbl.get(i).update();
            }
            //bullet.update();
            
            drawBackGroundWithTileImage();
            I1.draw(g2,this);
            I2.draw(g2,this);
            I3.draw(g2,this);
            m.draw(g2,this);
            //e1.draw(g2, this);
            for(int i = 0; i < enemyl.size(); i++){
                enemyl.get(i).draw(g2,this);
            }
            for(int i = 0; i < playerbl.size(); i++){
                playerbl.get(i).draw(g2,this);
            }
            
    }

    public void paint(Graphics g) {
        if(bimg == null) {
            Dimension windowSize = getSize();
            bimg = (BufferedImage) createImage(windowSize.width, 
                    windowSize.height);
            g2 = bimg.createGraphics();
        }
        drawDemo();
        g.drawImage(bimg, 0, 0, this);
    }

    public void start() {
        System.out.println();
        thread = new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }

    public void run() {
    	
        Thread me = Thread.currentThread();
        while (thread == me) {
            repaint();  
          try {
                thread.sleep(25);
            } catch (InterruptedException e) {
                break;
            }
            
        }
    }

    public static void main(String argv[]) {
        final GameWorld demo = new GameWorld();
        demo.init();
        JFrame f = new JFrame("Scrolling Shooter");
        f.addWindowListener(new WindowAdapter() {
        });
        f.getContentPane().add("Center", demo);
        f.pack();
        f.setSize(new Dimension(640, 480));
        f.setVisible(true);
        f.setResizable(false);
        demo.start();
    }
    
}

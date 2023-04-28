package no.uib.inf101.sem2.Ball;

/**
 * Denne klassen representerer ballen i spillet. 
 * Klassen implementerer grensesnittet IPongDrawablem som beskriver alle metodene i klassen.
 */

import java.awt.Color;
import java.awt.Graphics;


import no.uib.inf101.sem2.Paddles.Paddles;

public class PongBall implements IPongDrawable {
    private int x, y, vx, vy;
    private boolean right;
    private boolean down;
    public final int radius = 10;
    

    //Constructor
    public PongBall(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.right = true;
        this.down = true;
    }
    
    public void moveBall() {
        x += vx;
        y += vy;
    }
    
    public void draw(Graphics g) {
        
        g.setColor(Color.yellow);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
    
    
    public boolean collidesWith(Paddles paddle) {
        // Sjekker om ballen har kollidert med racketen
        int paddleX = paddle.getX();
        int paddleY = paddle.getY();
        int paddleWidth = paddle.getWidth();
        int paddleHeight = paddle.getHeight();
        
        if (x + radius > paddleX && x - radius < paddleX + paddleWidth &&
            y + radius > paddleY && y - radius < paddleY + paddleHeight) {
            return true;
        }
        
        
        
        return false;
    }
    


    public void bounceOffPaddle(Paddles paddle) {
        
        if (vx > 0) {
            x = paddle.getX() - radius;
        } else {
            x = paddle.getX() + paddle.getWidth() + radius;
        }
        
        if (right) {
            vx = -vx - 1;
            right = false;
        } else {
            vx = -1 * vx + 1;
            right = true;
        }
        if (down) {
            vy = vy + 1;
            down = false;
        } else {
            vy = vy - 1;
            down = true;
        }
        
    }
    
    
    public boolean collidesWithTopWall() {
        // Sjekker om ballen har kollidert med toppveggen
        if (y - radius < 21) {
            return true;
        }
        
        return false;
    }
    
    
    public boolean collidesWithBottomWall() {
        // Sjekker om ballen har kollidert med bunnveggen
        if (y + radius > 500) {
            return true;
        }
        
        return false;
    }

    public void reset() {
        x = 400;
        y = 260;
        vx = 2;
        vy = 2;
        
    }
    
    public void changeStartDir() {
        vx = -2;
        vy = 2;
    }

    public boolean outOfLeftBounds() {
        return x < 0;
    }
    
    public boolean outOfRightBounds() {
        return x + 20 > 800;
    }

    public void bounceOffWall() {
        
        vy = -vy;
    }
    
    public int getX() {
        
        return x;
    }
    
    public int getY() {
        
        return y;
    } 

    //FOR TESTER

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }
}

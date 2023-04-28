package no.uib.inf101.sem2.Paddles;

/**
 * Denne klassen representerer spillets paddles, og deres egenskaper. 
 * Klassen implementerer grensesnittet IPaddles, som beskriver alle metodene i klassen.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import no.uib.inf101.sem2.PongGame.PongController;

public class Paddles implements IPaddles {
    private int x, y, vy, width, height, upKey, downKey;
    private boolean upPressed, downPressed;
    int id;
    int yVelocity;
    private int score;
    

    //Constructor
    public Paddles(int x, int y, int vy, int height, int upKey, int downKey, int id) {
        
        this.x = x;
        this.y = y;
        this.vy = vy;
        this.width = 10;
        this.height = height;
        this.upKey = upKey;
        this.downKey = downKey;
        this.id = id;
    }
    
    
    
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == upKey) {
            upPressed = true;
        } else if (e.getKeyCode() == downKey) {
            downPressed = true;
        }
        
	}
    
	public void keyReleased(KeyEvent e) {
		System.out.println("paddle keypressed");
        if (e.getKeyCode() == upKey) {
            upPressed = false;
            System.out.println("uPpressed");
        } else if (e.getKeyCode() == downKey) {
            downPressed = false;
        }
        
	}
     
    public void moveL(PongController controller) {
		
        if (controller.isWPressed()) {
            y = Math.max(23, y - vy);
        } else if (controller.isSPressed()) {
            y = Math.min(499 - height, y + vy);
        }  
	}

    public void moveR(PongController controller) {
		
        if (controller.isUpPressed()) {
            y = Math.max(23, y - vy);
        } else if (controller.isDownPressed()) {
            y = Math.min(499 - height, y + vy);
        }  
	}

    
   
	public void draw(Graphics g) {
		if(id==1)
			g.setColor(Color.pink);
		else
			g.setColor(Color.cyan);
		g.fillRect(x, y, width, height);
	}

    public int getUpKey() {
        return upKey;
    }
    
    public int getDownKey() {
        return downKey;
    }
    
    public void stop() {
        upPressed = false;
        downPressed = false;
    }

    public int getX() { 
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getWidth() { 
        return width;
    }
    
    public int getHeight() {
        return height;
    }

    public int getSpeed() {
        return vy;
    }

    public int getScore() {
        return score;
    }
    public void incrementScore() {
        score++;
    }


}

package no.uib.inf101.sem2.PongGame;

/**
 * PongController er en JPanel som implementerer KeyListener.
 * Denne klassen håndterer tastetrykk fra brukeren, og setter variabler som indikerer om visse taster
 * er trykket ned eller sluppet opp. Den har også metoder som sjekker om bestemte taster er trykket ned,
 * og en metode for å stoppe bevegelsen av paddlene.
 */

import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import no.uib.inf101.sem2.Paddles.Paddles;





public class PongController extends JPanel implements KeyListener {

    
    
    private boolean upPressed, downPressed, wPressed, sPressed, enterPressed;


    //Constructor
    public PongController(Paddles leftPaddle, Paddles rightPaddle) { 

        addKeyListener(this);
        setFocusable(true);
        System.out.println("Controller constructor called");
    }


    /**
     * Håndterer tastetrykk som blir gjort av brukeren.
     * Metoden vil sette variabler til å indikere om visse taster er trykket ned eller ikke.
     *
     * @param e hendelsesobjektet som representerer tastetrykket som ble gjort.
     */
    public void keyPressed(KeyEvent e) {
        
        System.out.println("KeyPressed");
        
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            wPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            sPressed = true;
        } 
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
    }
    
    
    /**
     * Håndterer tastetrykk som blir gjort av brukeren.
     * Metoden vil sette variabler til å indikere om visse taster er sluppet opp eller ikke.
     *
     * @param e hendelsesobjektet som representerer tastetrykket som ble sluppet opp.
     */
    public void keyReleased(KeyEvent e) {
         
        System.out.println("KeyReleased");
        
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            wPressed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            sPressed = false;
        }
    }
    
    /**
     * Stopper bevegelsen av paddlen ved å sette variabler for tastetrykk til false.
     */
    public void stop() {
        upPressed = false;
        downPressed = false;
    }


    /**
     * Sjekker om tasten for å bevege høyre paddle opp er trykket ned.
     *
     * @return true hvis tasten er trykket ned, ellers false.
     */
    public boolean isUpPressed() {
        if (upPressed) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Sjekker om tasten for å bevege høyre paddle ned er trykket ned.
     *
     * @return true hvis tasten er trykket ned, ellers false.
     */
    public boolean isDownPressed() {
        if (downPressed) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Sjekker om tasten for å bevege venstre paddle opp er trykket ned.
     *
     * @return true hvis tasten er trykket ned, ellers false.
     */
    public boolean isWPressed() {
        if (wPressed) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sjekker om tasten for å bevege venstre paddle ned er trykket ned.
     *
     * @return true hvis tasten er trykket ned, ellers false.
     */
    public boolean isSPressed() {
        if (sPressed) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sjekker om enter-tasten er trykket ned.
     *
     * @return true hvis tasten er trykket ned, ellers false.
     */
    public boolean isEnterPressed() {
        if (enterPressed) {
            return true;
        } else {
            return false;
        }
    }



    @Override
    public void keyTyped(KeyEvent arg0) {}
    
}

package no.uib.inf101.sem2.Paddles;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import no.uib.inf101.sem2.PongGame.PongController;

public interface IPaddles {

    
    /**
     * Metoden kalles når en tast blir trykket ned.
     * 
     * @param e KeyEvent-objektet som representerer tasten som ble trykket ned
     */
    void keyPressed(KeyEvent e);
    
    /**
     * Metoden kalles når en tast blir sluppet.
     * 
     * @param e KeyEvent-objektet som representerer tasten som ble sluppet
     */
    void keyReleased(KeyEvent e);
    
    /**
     * Metoden flytter racketen til venstre.
     * 
     * @param controller PongController-objektet som brukes for å styre spillet
     */
    void moveL(PongController controller);
    
    /**
     * Metoden flytter racketen til høyre.
     * 
     * @param controller PongController-objektet som brukes for å styre spillet
     */
    void moveR(PongController controller);
    
    /**
     * Metoden tegner racketen.
     * 
     * @param g Graphics-objektet som brukes for å tegne racketen
     */
    void draw(Graphics g);
    
    /**
     * Metoden returnerer tastekoden for opp-tasten.
     * 
     * @return integer som representerer tastekoden for opp-tasten
     */
    int getUpKey();
    
    /**
     * Metoden returnerer tastekoden for ned-tasten.
     * 
     * @return integer som representerer tastekoden for ned-tasten
     */
    int getDownKey();
    
    /**
     * Metoden stopper racketen.
     */
    void stop();

    /**
     * Metoden returnerer x-koordinaten til racketen.
     * 
     * @return integer som representerer x-koordinaten til racketen
     */
    int getX();
    
    /**
     * Metoden returnerer y-koordinaten til racketen.
     * 
     * @return integer som representerer y-koordinaten til racketen
     */
    int getY();
    
    /**
     * Metoden returnerer bredden til racketen.
     * 
     * @return integer som representerer bredden til racketen
     */
    int getWidth();
    
    /**
     * Metoden returnerer høyden til racketen.
     * 
     * @return integer som representerer høyden til racketen
     */
    int getHeight();

    /**
     * Metoden returnerer farten til racketen.
     * 
     * @return integer som representerer farten til racketen
     */
    int getSpeed();

    /**
     * Metoden returnerer poengsummen til racketen.
     * 
     * @return integer som representerer poengsummen til racketen
     */
    int getScore();
    
    /**
     * Metoden øker poengsummen til racketen med 1.
     */
    void incrementScore();
}

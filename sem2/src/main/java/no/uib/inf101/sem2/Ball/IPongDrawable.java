package no.uib.inf101.sem2.Ball;

import java.awt.Graphics;


import no.uib.inf101.sem2.Paddles.Paddles;

public interface IPongDrawable {

    /**
     * Metoden tegner ballen.
     */
    void draw(Graphics g);

    /**
     * Metoden sjekker om ballen har kollidert med racketen.
     * 
     * @param paddle
     *            Racketen som ballen skal sjekkes mot.
     * @return true hvis ballen har kollidert med racketen, ellers false.
     */
    boolean collidesWith(Paddles paddle);

    /**
     * Metoden får ballen til å sprette av racketen.
     * 
     * @param paddle
     *            Racketen som ballen skal sprette av.
     */
    void bounceOffPaddle(Paddles paddle);

    /**
     * Metoden sjekker om ballen har kollidert med øvre vegg.
     * 
     * @return true hvis ballen har kollidert med øvre vegg, ellers false.
     */
    boolean collidesWithTopWall();

    /**
     * Metoden sjekker om ballen har kollidert med nedre vegg.
     * 
     * @return true hvis ballen har kollidert med nedre vegg, ellers false.
     */
    boolean collidesWithBottomWall();

    /**
     * Metoden tilbakestiller ballens posisjon og hastighet.
     */
    void reset();

    /**
     * Metoden som endrer ballens retning ved start.
     */
    void changeStartDir();

    /**
     * Metoden sjekker om ballen har gått ut av venstre skjermkant.
     * 
     * @return true hvis ballen har gått ut av venstre skjermkant, ellers false.
     */
    boolean outOfLeftBounds();

    /**
     * Metoden sjekker om ballen har gått ut av høyre skjermkant.
     * 
     * @return true hvis ballen har gått ut av høyre skjermkant, ellers false.
     */
    boolean outOfRightBounds();

    /**
     * Metoden får ballen til å sprette av veggen.
     */
    void bounceOffWall();

    /**
     * Metoden returnerer ballens x-koordinat.
     * 
     * @return ballens x-koordinat.
     */
    int getX();

    /**
     * Metoden returnerer ballens y-koordinat.
     * 
     * @return ballens y-koordinat.
     */
    int getY();

    /**
     * Metoden setter ballens x-koordinat.
     * 
     * @param x
     *            ballens x-koordinat.
     */
    void setX(int x);

    /**
     * Metoden setter ballens y-koordinat.
     * 
     * @param y
     *            ballens y-koordinat.
     */
    void setY(int y);

    /**
     * Metoden setter ballens hastighet i x-retning.
     * 
     * @param vx
     *            ballens hastighet i x-retning.
     */
    void setVx(int vx);

    /**
     * Metoden setter ballens hastighet i y-retning.
     * 
     * @param vy
     *            ballens hastighet i y-retning.
     */
    void setVy(int vy);

    /**
     * Metoden returnerer ballens hastighet i x-retning.
     * 
     * @return ballens hastighet i x-retning.
     */
    int getVx();

    /**
     * Metoden returnerer ballens hastighet i y-retning.
     * 
     * @return ballens hastighet i y-retning.
     */
    int getVy();

}

package no.uib.inf101.sem2.PongGame;


/**
 * PongView-klassen er en underklasse av JPanel-klassen, og er ansvarlig for å tegne
 * grafikkelementene til Pon-spillet. Klassen inneholder en referanse til PongGame-objektet
 * som skal vises og en referanse til PongController-objektet som skal håndtere brukerinput.
 */


import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;

import no.uib.inf101.sem2.Ball.PongBall;
import no.uib.inf101.sem2.Paddles.Paddles;




public class PongView extends JPanel  {

    private PongGame game;
    private PongController controller;
    

    //Constructor
    public PongView(PongGame game) {
        this.game = game;
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        addKeyListener(controller);
        setFocusable(true);
    }


    /**
     * Tegner opp grafikkelementene for Pong-spillet, inkludert scoretavle, racketene og ballen.
     * Metoden vil bli kalt av Swing-biblioteket når komponenten blir tegnet.
     *
     * @param g grafikkobjektet som brukes for å tegne komponenten.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(Color.white);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        //g.drawRect(20, 20, getWidth() - 40, getHeight() - 50);

        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g.drawLine(20, 20, getWidth() - 20, 20);
        g.drawLine(getWidth() - 20, getHeight() - 30, 20, getHeight() - 30);
        g2D.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, new float[]{10}, 0));
        g.drawLine(getWidth() - 20, 20, getWidth() - 20, getHeight() - 30);
        g.drawLine(20, getHeight() - 30, 20, 20);

        g.setColor(Color.DARK_GRAY);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, new float[]{10}, 0));
        g2d.drawLine(getWidth() / 2, 25, getWidth() / 2, getHeight() - 30);

        g.setColor(Color.pink);
        g.setFont(new Font("Arial", Font.PLAIN, 36));
        g.drawString(String.format("%02d", game.getLeftScore()), 340, 60);
        g.setColor(Color.cyan);
        g.drawString(String.format("%02d", game.getRightScore()), 405, 60);

        g.setColor(Color.pink);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("PLAYER 1", 40, 480);
        g.setColor(Color.cyan);
        g.drawString("PLAYER 2", 650, 480);


        PongBall ball = game.getBall();
        Paddles leftPaddle = game.getLeftPaddle();
        Paddles rightPaddle = game.getRightPaddle();

        ball.draw(g);
        leftPaddle.draw(g);
        rightPaddle.draw(g);
        
        //PONG LOGO
        Graphics2D G = (Graphics2D) g;
        G.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.setColor(Color.DARK_GRAY);
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth("PONG");
        int textHeight = fm.getHeight();
        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() - textHeight) / 2 + fm.getAscent();
        g.drawString("PONG", x, y);
        
    }

    
    
}

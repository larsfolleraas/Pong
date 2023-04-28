package no.uib.inf101.sem2.PongGame;

/**
 * PongGame er klassen som representerer logikken og kontrollen for selve spillet Pong.
 * Klassen implementerer Runnable-grensesnittet for å kunne kjøre hovedløkka i spillet
 * i en egen tråd
 */

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import no.uib.inf101.sem2.Ball.PongBall;
import no.uib.inf101.sem2.Paddles.Paddles;


public class PongGame implements Runnable {
    
    public PongView view;
    public PongBall ball;
    private Paddles leftPaddle, rightPaddle;
    private int leftScore, rightScore;
    private boolean running;
    private int x = 400;
    private PongController controller;
    public String filename1 = "Sounds/170149__timgormly__8-bit-hurt.aiff";
    public String filename2 = "Sounds/12657__wwwbonsonca__whoosh_swish_02.wav";


    //Constructor
    public PongGame() {
        leftPaddle = new Paddles(46, 240, 10, 80, KeyEvent.VK_W, KeyEvent.VK_S, 1);
        rightPaddle = new Paddles(730, 240, 10, 80, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 2);
        controller = new PongController(leftPaddle, rightPaddle);
        view = new PongView(this);
        ball = new PongBall(400, 200, 2, 2);
        leftScore = 0;
        rightScore = 0;
        view.addKeyListener(controller); 
    }


    /**
     * Spiller av en lydfil med navnet gitt som parameter.
     * Hvis det oppstår en feil under avspillingen, vil en
     * feilmelding skrives ut til standard error output.
     *
     * @param filename navnet på lydfilen som skal spilles av.
     */
    public static void playSound(String filename) {
        try {
            File soundFile = new File(filename);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    

    /**
     * Oppdaterer spillet ved å bevege ballen og racketene og sjekke for kollisjoner.
     * Hvis ballen kolliderer med en racket eller en vegg, spilles en lyd avhengig av hvilken hendelse som skjer.
     * Hvis ballen går ut av venstre eller høyre side av skjermen, vil scoret økes og ballen resettes og endre retning.
     */
    public void update() {
        
        ball.moveBall();
        leftPaddle.moveL(controller);
        rightPaddle.moveR(controller);
    
        if (ball.collidesWith(leftPaddle)) {
            ball.bounceOffPaddle(leftPaddle);
            playSound(filename1);
            
        } else if (ball.collidesWith(rightPaddle)) {
            ball.bounceOffPaddle(rightPaddle);   
            playSound(filename1);
        }
        if (ball.collidesWithTopWall() || ball.collidesWithBottomWall()) {
            ball.bounceOffWall();
            playSound(filename1);
            
        }
        if (ball.outOfLeftBounds()) {
            playSound(filename2);
            rightScore++;
            ball.reset();
            ball.changeStartDir();
        } else if (ball.outOfRightBounds()) {
            playSound(filename2);
            leftScore++;
            ball.reset();
        }
        
    }
    
    

    /**
     * Starter spillet ved å sette "running" til "true" og starte en ny tråd.
     */
    public void start() {
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }
    

    /**
     * Sjekker om ballen er utenfor venstre side av skjermen.
     *
     * @return true hvis ballen er utenfor venstre side av skjermen, false ellers.
     */
    public boolean outOfLeftBounds() {
        return x < 0;
    }
    
    /**
     * Sjekker om ballen er utenfor høyre side av skjermen.
     *
     * @return true hvis ballen er utenfor høyre side av skjermen, false ellers.
     */
    public boolean outOfRightBounds() {
        return x + ball.radius * 2 > 800;
    }


    /**
     * Returnerer player 1 sin score.
     *
     * @return player 1 score.
     */
    public int getLeftScore() {
        return leftScore;
    }


    /**
     * Returnerer player 2 sin score.
     *
     * @return player 2 score.
     */
    public int getRightScore() {
        return rightScore;
    }

    /**
     * Returnerer ballen.
     *
     * @return ball.
     */
    public PongBall getBall() {
        return ball;
    }

    /**
     * Returnerer venstre paddle.
     *
     * @return venstre paddle.
     */
    public Paddles getLeftPaddle() {
        return leftPaddle;
    }


    /**
     * Returnerer høyre paddle.
     *
     * @return høyre paddle.
     */
    public Paddles getRightPaddle() {
        return rightPaddle;
    }

    /**
     * Kjører hovedløkka for spillet. Oppdaterer spillet og oppdaterer visningen av spillet.
     * Metoden vil kjøre i en egen tråd så lenge "running" er satt til "true".
     */
    @Override
    public void run() {
        while (running) {
            update();
            view.repaint();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    




    //FOR TESTER

    /**
     * Setter venstrescoren i spillet til den verdien som er gitt som parameter.
     *
     * @param score den nye venstrescoren.
     */
    public void setLeftScore(int score) {
        this.leftScore = score;
    }


    /**
     * Setter høyrescoren i spillet til den verdien som er gitt som parameter.
     *
     * @param score den nye høyrescoren.
     */
    public void setRightScore(int score) {
        this.rightScore = score;
    }


    /**
     * Setter venstre paddle i spillet til den som er gitt som parameter.
     *
     * @param leftPaddle2 den nye venstre paddle.
     */
    public void setLeftPaddle(Paddles leftPaddle2) {
        this.leftPaddle = leftPaddle2;
    }


    /**
     * Setter høyre paddle i spillet til den som er gitt som parameter.
     *
     * @param rightPaddle2 det nye høyre paddle.
     */
    public void setRightPaddle(Paddles rightPaddle2) {
        this.rightPaddle = rightPaddle2;
    }

    
    /**
     * Setter kontrolleren for spillet til den som er gitt som parameter.
     *
     * @param controller2 den nye kontrolleren.
     */
    public void setController(PongController controller2) {
        this.controller = controller2;
    }


    /**
     * Setter ballen i spillet til den som er gitt som parameter.
     *
     * @param ball2 den nye ballen.
     */
    public void setBall(PongBall ball2) {
        this.ball = ball2;
    }
    
}

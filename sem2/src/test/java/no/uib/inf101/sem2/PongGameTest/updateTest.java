package no.uib.inf101.sem2.PongGameTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import no.uib.inf101.sem2.Ball.PongBall;
import no.uib.inf101.sem2.Paddles.Paddles;
import no.uib.inf101.sem2.PongGame.PongController;
import no.uib.inf101.sem2.PongGame.PongGame;



import java.awt.event.KeyEvent;

public class updateTest {


    @Test
    public void testIfBallMove() {
        Paddles leftPaddle = new Paddles(46, 240, 10, 80, KeyEvent.VK_W, KeyEvent.VK_S, 1);
        Paddles rightPaddle = new Paddles(730, 240, 10, 80, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 2);
        PongController controller = new PongController(leftPaddle, rightPaddle);
        PongGame game = new PongGame();
        game.setLeftScore(0);
        game.setRightScore(0);
        game.setLeftPaddle(leftPaddle);
        game.setRightPaddle(rightPaddle);
        game.setController(controller);
        PongBall ball = new PongBall(400, 200, 2, 2);
        game.setBall(ball);
        
        
        // Test at ballen flyttes og racketene ikke flyttes
        game.update();
        assertEquals(402, ball.getX());
        assertEquals(202, ball.getY());
        assertEquals(240, leftPaddle.getY());
        assertEquals(240, rightPaddle.getY());
        assertEquals(0, game.getLeftScore());
        assertEquals(0, game.getRightScore());
        
    }


    @Test
    public void ballCollidesLPaddle() {

        Paddles leftPaddle = new Paddles(46, 240, 10, 80, KeyEvent.VK_W, KeyEvent.VK_S, 1);
        Paddles rightPaddle = new Paddles(730, 240, 10, 80, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 2);
        PongController controller = new PongController(leftPaddle, rightPaddle);
        PongGame game = new PongGame();
        game.setLeftScore(0);
        game.setRightScore(0);
        game.setLeftPaddle(leftPaddle);
        game.setRightPaddle(rightPaddle);
        game.setController(controller);
        PongBall ball = new PongBall(400, 200, 2, 2);
        game.setBall(ball);

        // Test at ballen kolliderer med venstre racket og endrer retning
        ball.setX(56);
        ball.setY(260);
        game.update();
        assertEquals(-3, ball.getVx());
        assertEquals(3, ball.getVy());
        assertEquals(0, game.getLeftScore());
        assertEquals(0, game.getRightScore());
    }

    @Test
    public void ballCollidesRPaddle(){
        Paddles leftPaddle = new Paddles(46, 240, 10, 80, KeyEvent.VK_W, KeyEvent.VK_S, 1);
        Paddles rightPaddle = new Paddles(730, 240, 10, 80, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 2);
        PongController controller = new PongController(leftPaddle, rightPaddle);
        PongGame game = new PongGame();
        game.setLeftScore(0);
        game.setRightScore(0);
        game.setLeftPaddle(leftPaddle);
        game.setRightPaddle(rightPaddle);
        game.setController(controller);
        PongBall ball = new PongBall(400, 200, 2, 2);
        game.setBall(ball);


        // Test at ballen kolliderer med høyre racket og endrer retning
        ball.setX(724);
        ball.setY(260);
        game.update();
        assertEquals(-3, ball.getVx());
        assertEquals(3, ball.getVy());
        assertEquals(0, game.getLeftScore());
        assertEquals(0, game.getRightScore());
    }

    @Test
    public void collideWithTopWall() {
        Paddles leftPaddle = new Paddles(46, 240, 10, 80, KeyEvent.VK_W, KeyEvent.VK_S, 1);
        Paddles rightPaddle = new Paddles(730, 240, 10, 80, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 2);
        PongController controller = new PongController(leftPaddle, rightPaddle);
        PongGame game = new PongGame();
        game.setLeftScore(0);
        game.setRightScore(0);
        game.setLeftPaddle(leftPaddle);
        game.setRightPaddle(rightPaddle);
        game.setController(controller);
        PongBall ball = new PongBall(400, 200, 2, 2);
        game.setBall(ball);

        // Test at ballen kolliderer med toppveggen og endrer retning
        ball.setX(400);
        ball.setY(23);
        game.update();
        assertEquals(2, ball.getVx());
        assertEquals(-2, ball.getVy());
        assertEquals(0, game.getLeftScore());
        assertEquals(0, game.getRightScore());
    }

    @Test
    public void CollideWithBottomWall() {
        Paddles leftPaddle = new Paddles(46, 240, 10, 80, KeyEvent.VK_W, KeyEvent.VK_S, 1);
        Paddles rightPaddle = new Paddles(730, 240, 10, 80, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 2);
        PongController controller = new PongController(leftPaddle, rightPaddle);
        PongGame game = new PongGame();
        game.setLeftScore(0);
        game.setRightScore(0);
        game.setLeftPaddle(leftPaddle);
        game.setRightPaddle(rightPaddle);
        game.setController(controller);
        PongBall ball = new PongBall(400, 200, 2, 2);
        game.setBall(ball);


        // Test at ballen kolliderer med bunnveggen og endrer retning
        ball.setX(400);
        ball.setY(477);
        game.update();
        assertEquals(2, ball.getVx());
        assertEquals(2, ball.getVy());
        assertEquals(0, game.getLeftScore());
        assertEquals(0, game.getRightScore());
    }

    @Test
    public void outOfBoundsLeft() {
        Paddles leftPaddle = new Paddles(46, 240, 10, 80, KeyEvent.VK_W, KeyEvent.VK_S, 1);
        Paddles rightPaddle = new Paddles(730, 240, 10, 80, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 2);
        PongController controller = new PongController(leftPaddle, rightPaddle);
        PongGame game = new PongGame();
        game.setLeftScore(0);
        game.setRightScore(0);
        game.setLeftPaddle(leftPaddle);
        game.setRightPaddle(rightPaddle);
        game.setController(controller);
        PongBall ball = new PongBall(400, 200, 2, 2);
        game.setBall(ball);


        // Test at ballen går ut av venstre side og scoren til høyre øker
        ball.setX(-10);
        ball.setY(250);
        game.update();
        assertEquals(-2, ball.getVx());
        assertEquals(2, ball.getVy());
        assertEquals(0, game.getLeftScore());
        assertEquals(1, game.getRightScore());
    }

    @Test
    public void outOfBoundsRight() {
        Paddles leftPaddle = new Paddles(46, 240, 10, 80, KeyEvent.VK_W, KeyEvent.VK_S, 1);
        Paddles rightPaddle = new Paddles(730, 240, 10, 80, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 2);
        PongController controller = new PongController(leftPaddle, rightPaddle);
        PongGame game = new PongGame();
        game.setLeftScore(0);
        game.setRightScore(0);
        game.setLeftPaddle(leftPaddle);
        game.setRightPaddle(rightPaddle);
        game.setController(controller);
        PongBall ball = new PongBall(400, 200, 2, 2);
        game.setBall(ball);


        // Test at ballen går ut av høyre side og scoren til venstre øker
        ball.setX(810);
        ball.setY(250);
        game.update();
        assertEquals(2, ball.getVx());
        assertEquals(2, ball.getVy());
        assertEquals(1, game.getLeftScore());
        assertEquals(0, game.getRightScore());
    }

}


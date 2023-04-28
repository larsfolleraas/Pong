package no.uib.inf101.sem2;
/**

Hovedklassen som starter Pong-spillet.
*/

import javax.swing.JFrame;
import java.awt.Color;

import no.uib.inf101.sem2.PongGame.PongGame;

public class Main {
  
  /**
  Metoden som kjører spillet.
  @param args inputargumenter for programmet, ikke brukt i dette tilfellet.
  */
  public static void main(String[] args) {
    
    PongGame game = new PongGame();
    game.start();
    System.out.println("Spillet starter...");
    JFrame frame = new JFrame("Pong Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(game.view);
    frame.pack();
    frame.setSize(800, 570);
    frame.setBackground(Color.BLACK);
    frame.setResizable(false);
    frame.setVisible(true);
    
  }
}

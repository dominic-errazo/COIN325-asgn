package lab07;

import javax.swing.JFrame;

/**
 *
 * @author Dominic
 */
public class PushRandom {
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Random numbers!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        PushRandomPanel randPanel = new PushRandomPanel();
        frame.getContentPane().add(randPanel);
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
}

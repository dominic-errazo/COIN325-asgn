package lab07;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Random;

/**
 *
 * @author Dominic
 */
public class PushRandomPanel extends JPanel {
    
    private JButton mMyButton;
    private JLabel mNumber;
    private Random mGen;
    private int value;
    
    public PushRandomPanel() {
        mMyButton = new JButton("Randomize!");
        mMyButton.addActionListener(new RandomListener());
        mNumber = new JLabel("");
        mGen = new Random();
        value = 0;
        
        add(mMyButton);
        add(mNumber);
        
        setBackground(Color.ORANGE);
        setPreferredSize(new Dimension(400, 300));
    }
    
    public JButton getButton() {
        return mMyButton;
    }
    
    public JLabel getLabel() {
        return mNumber;
    }
    
    private class RandomListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            value = mGen.nextInt(100) + 1;
            mNumber.setText(value + "");
        }
        
        
    }
}

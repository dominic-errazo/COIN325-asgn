/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import javax.swing.JFrame;

/**
 *
 * @author Dominic
 */
public class CheeseDBRunner {
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Learn about cheese!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CheeseDBPanel cdbPanel = new CheeseDBPanel();
        frame.getContentPane().add(cdbPanel);
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
}

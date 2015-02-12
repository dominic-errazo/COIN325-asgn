/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab07;

import javax.swing.JButton;
import javax.swing.JLabel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominic
 */
public class PushRandomPanelTester {
    
    private PushRandomPanel testPanel;
    
    
    public PushRandomPanelTester() {
        testPanel = new PushRandomPanel();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void checkValues() {
        int savedValue;
        
        for(int i = 0; i < 20; i++) {
            testPanel.clickButton();
            savedValue = Integer.parseInt(testPanel.getLabelText());
            //System.out.println(savedValue);
            assertTrue(savedValue > 0 & savedValue < 101);
            
        }
    }
}

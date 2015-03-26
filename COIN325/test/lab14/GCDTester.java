/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab14;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominic
 */
public class GCDTester {
    
    public GCDTester() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void GCDTest() {
        assertTrue(DivisorCalc.gcd(80, 20) == 20);
        
        assertTrue(DivisorCalc.gcd(3, 9) == 3);
        
        assertTrue(DivisorCalc.gcd(17, 53) == 1);
        
        assertTrue(DivisorCalc.gcd(75, 60) == 15);
    }
}

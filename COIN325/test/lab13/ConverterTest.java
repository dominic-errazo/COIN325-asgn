/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab13;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominic
 */
public class ConverterTest {
    
    public ConverterTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void converterTester() {
        assertTrue(Converter.utoi("10").equals(new Integer(10)));
        assertTrue(Converter.utoi("16").equals(new Integer(16)));
        assertTrue(Converter.utoi("105").equals(new Integer(105)));
        
        assertNull(Converter.utoi("1g5"));
        assertNull(Converter.utoi("definitely not a number"));
        
    }
}

package lab09;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominic
 */
public class IntegerCountTester {
    
    private IntegerCount counter;
    
    public IntegerCountTester() {
        counter = new IntegerCount();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void simpleAddTest() {
        assertTrue(counter.receiveInteger(1));
        assertTrue(counter.receiveInteger(1));
        assertTrue(counter.receiveInteger(20));
        assertTrue(counter.receiveInteger(30));
        assertTrue(counter.receiveInteger(50));
        assertTrue(counter.receiveInteger(100));
        
        assertTrue(counter.receiveCount(1) == 2);
        assertTrue(counter.receiveCount(20) == 1);
        assertTrue(counter.receiveCount(30) == 1);
        assertTrue(counter.receiveCount(40) == 0);
        assertTrue(counter.receiveCount(50) == 1);   
        assertTrue(counter.receiveCount(100) == 1);
    }
    
    @Test
    public void incorrectAddTest() {
        assertFalse(counter.receiveInteger(0));
        assertFalse(counter.receiveInteger(-99));
        assertFalse(counter.receiveInteger(300));
    }
    
    @Test
    public void stringSourceTester() {
        counter.clear();
        counter.addFromString("1 40 1 40 40");
        
        assertTrue(counter.receiveCount(1) == 2);
        assertTrue(counter.receiveCount(40) == 3);
    }
    
    @Test
    public void stringWithIncorrectTester() {
        counter.clear();
        counter.addFromString("0 5 -4 101 5");
        
        assertTrue(counter.receiveCount(0) == -1);
        assertTrue(counter.receiveCount(5) == 2);
        assertTrue(counter.receiveCount(-4) == -1);
        assertTrue(counter.receiveCount(101) == -1);        
    }
    
    @Test
    public void stringWithIncorrectTester2() {
        counter.clear();
        counter.addFromString("three six three 3 6 3");
        
        assertTrue(counter.receiveCount(3) == 2);
        assertTrue(counter.receiveCount(6) == 1);
    }
}

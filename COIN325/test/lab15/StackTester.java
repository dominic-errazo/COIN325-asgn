/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab15;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominic
 */
public class StackTester {
    public StackTester() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void ArrayStackTest() {
        IntegerStackTest(new ArrayStack<Integer>());
    }
    
    private void IntegerStackTest(Stack<Integer> stack) {
        try {
            assertTrue(stack.size() == 0);
            assertTrue(stack.isEmpty());

            stack.push(new Integer(1));
            stack.push(new Integer(10));
            stack.push(new Integer(6));

            assertTrue(stack.size() == 3);
            assertFalse(stack.isEmpty());
            assertTrue(stack.peek().intValue() == 6);
            assertTrue(stack.pop().intValue() == 6);
            assertTrue(stack.peek().intValue() == 10);
            assertTrue(stack.size() == 2);
            assertTrue(stack.pop().intValue() == 10);
            assertTrue(stack.peek().intValue() == 1);
            assertTrue(stack.pop().intValue() == 1);
            assertTrue(stack.isEmpty());
        }
        catch(EmptyCollectionException ece) {
            System.err.println("Should not reach this area");
        }
    }
    
    @Test
    public void EmptyTest() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        
        try {
            stack.peek();
            fail("peek should have thrown an exception");
        }
        catch(EmptyCollectionException ece) {
            
        }
        
        try {
            stack.pop();
            fail("pop should have thrown an exception");
        }
        catch(EmptyCollectionException ece) {
            
        }
    }
}

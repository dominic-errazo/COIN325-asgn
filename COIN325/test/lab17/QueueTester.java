/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab17;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominic
 */
public class QueueTester {
    
    public QueueTester() {
    }

    @Test
    public void LinkedQueueTest() {
        IntegerQueueTest(new LinkedQueue<Integer>());
    }
    
    @Test
    public void CircularArrayQueueTest() {
        Queue<Integer> circular = new CircularArrayQueue<>(10);
        IntegerQueueTest(circular);
        
        //test circularity as a primary difference from linked implementation
        try {
            for(int i = 0; i < 10; i++)
                circular.enqueue(new Integer(i));
            circular.enqueue(new Integer(10));
            fail("should not be reached");
        }
        catch(UnsupportedOperationException uoe)
        {
            
        }
    }
    
    private void IntegerQueueTest(Queue<Integer> queue) {
        try {
            assertTrue(queue.size() == 0);
            assertTrue(queue.isEmpty());
            
            queue.enqueue(new Integer(6));
            queue.enqueue(new Integer(10));
            queue.enqueue(new Integer(1));
            

            assertTrue(queue.size() == 3);
            assertFalse(queue.isEmpty());
            assertTrue(queue.first().intValue() == 6);
            assertTrue(queue.dequeue().intValue() == 6);
            assertTrue(queue.first().intValue() == 10);
            assertTrue(queue.size() == 2);
            assertTrue(queue.dequeue().intValue() == 10);
            assertTrue(queue.first().intValue() == 1);
            assertTrue(queue.dequeue().intValue() == 1);
            assertTrue(queue.isEmpty());
        }
        catch(EmptyCollectionException ece) {
            System.err.println("Should not reach this area");
            fail("again, should not reach this area");
        }
    }
    
    
    @Test
    public void EmptyLinkedTest() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        
        try {
            queue.first();
            fail("first should have thrown an exception");
        }
        catch(EmptyCollectionException ece) {
            
        }
        
        try {
            queue.dequeue();
            fail("dequeue should have thrown an exception");
        }
        catch(EmptyCollectionException ece) {
            
        }
    }
}

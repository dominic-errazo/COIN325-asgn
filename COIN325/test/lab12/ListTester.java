/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab12;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominic
 */
public class ListTester {
    private List list;
    public ListTester() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void SLinkedListTest() {
        listTest(new SLinkedList());
    }
    
    @Test
    public void ArrayListTest() {
        listTest(new ArrayList());
    }
    
    
    public void listTest(List list) {        
        list.add(new Integer(10));
        list.add(new Integer(11));
        list.add(new Integer(16));
        
        assertTrue(list.size() == 3);
        list.add(new Integer(20));
        list.add(new Integer(30));
        assertTrue(list.size() == 5);
        
        assertTrue(list.get(3).equals(new Integer(20)));
        
        //note, add other types
        
        list.add("lacking in type safety");
        list.add("very unsafe here");
        list.add(new Float(36.0f));
        
        assertTrue(list.size() == 8);
        assertTrue(list.get(5).equals("lacking in type safety"));
        assertTrue(list.get(7).equals(new Float(36.0f)));
        
        
    }
}

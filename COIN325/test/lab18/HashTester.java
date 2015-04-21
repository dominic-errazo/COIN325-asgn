/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab18;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;

/**
 *
 * @author Dominic
 */
public class HashTester {
    
    public HashTester() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void HashPutTest() {
        HashLinkedChaining<String, Employee> hash = new HashLinkedChaining<>();
        
        Employee emp = new Employee("Dan","123-45-6789","01-01-2000","Vulcan");
        hash.put("123-45-6789Vulcan", emp);
        emp = new Employee("Captain Kirk","123-45-6000","01-01-2263","Human");
        hash.put("123-45-6000Human", emp);
        emp = new Employee("Uhura","123-45-5000","01-02-2263","Human");
        hash.put("123-45-5000Human", emp);
        
        assertTrue(hash.get("123-45-6789Vulcan").getBDay().equals("01-01-2000"));
        assertTrue(hash.size() == 3);
        hash.put("123-45-5000Human", emp); //note: deal with duplicates
        assertTrue(hash.size() == 3);
        
        //testing collision but not same value
        emp = new Employee("Kvothe","123-45-5000","05-18-1961","Human");
        hash.put("123-45-5000Human", emp);
        assertTrue(hash.size() == 4);
        assertFalse(hash.get("123-45-5000Human").getBDay().equals("05-18-1961"));
        
        //testing a little differently for collisions: aiming for a result in the
        //same bucket but not the first one
        HashSet<Employee> results = hash.getAll("123-45-5000Human");
        boolean desiredFound = false;
        for(Employee e : results)
            if(e.getBDay().equals("05-18-1961"))
                desiredFound = true;
        
        assertTrue(desiredFound);
    }
}

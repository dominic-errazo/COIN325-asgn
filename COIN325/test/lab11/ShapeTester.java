/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab11;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominic
 */
public class ShapeTester {
    
    private double delta;
    
    public ShapeTester() {
        delta = 0.0001;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void circleTest() {
        Shape2D circle = new Circle(1.0);
        
        assertTrue(circle.getNumberOfAngles() == 0);
        assertEquals((Math.PI * 1.0 * 1.0), circle.getArea(), delta);
        assertEquals((2 * Math.PI), circle.getCircumference(), delta);
    }
    
    @Test
    public void rectangleTest() {
        Shape2D rect = new Rectangle(2.0, 3.5);
        
        assertTrue(rect.getNumberOfAngles() == 4);
        assertEquals(7.0, rect.getArea(), delta);
        assertEquals(11.0, rect.getCircumference(), delta);
    }
    
    @Test
    public void rightTriangleTest() {
        Shape2D rTriangle = new RightTriangle(3.0, 4.0);
        
        assertTrue(rTriangle.getNumberOfAngles() == 3);
        assertEquals(6.0, rTriangle.getArea(), delta);
        assertEquals(12.0, rTriangle.getCircumference(), delta);
    }
}

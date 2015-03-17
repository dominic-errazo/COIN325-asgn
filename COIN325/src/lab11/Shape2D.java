/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab11;

/**
 *
 * @author Dominic
 */
public class Shape2D {
    
    protected int _sides;
    
    public Shape2D(int sides) {
        _sides = sides;
    }
    
    public double getArea() {
        return 0.0;
    }
    
    public double getCircumference() {
        return 0.0;
    }
    
    public final int getNumberOfAngles() {
        return _sides;
    }
    
}

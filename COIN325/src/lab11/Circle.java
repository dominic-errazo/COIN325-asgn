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
public class Circle extends Shape2D{
    
    private double _radius;
    
    public Circle(double radius){
        super(0);
        _radius = radius;
    }
    
    public double getArea() {
        return Math.PI * Math.pow(_radius, 2);
    }
    
    public double getCircumference() {
        return Math.PI * 2 * _radius;
    }
    
}

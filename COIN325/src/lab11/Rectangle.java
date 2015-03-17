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
public class Rectangle extends Shape2D {

    private double _height, _width;
    
    public Rectangle(double height, double width) {
        super(4);
        _height = height;
        _width = width;
    }
    
    public double getArea() {
        return _height * _width;
    }
    
    public double getCircumference() {
        return 2 * (_height + _width);
    }
    
}

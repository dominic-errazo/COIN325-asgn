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
public class RightTriangle extends Shape2D{
    
    private double _height, _width;

    public RightTriangle(double height, double width) {
        super(3);
        _height = height;
        _width = width;
    }
    
    public double getArea() {
        return .5 * _height * _width;
    }
    
    public double getCircumference() {
        return _height + _width + (Math.sqrt(Math.pow(_height, 2) + Math.pow(_width, 2)));
    }
    
}

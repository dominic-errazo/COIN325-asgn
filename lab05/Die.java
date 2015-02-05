/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Die class from Java Foundations text
 * @author Dominic
 */
public class Die {
    private final int MAX = 6;
    private int faceValue;
    
    public Die() {
        faceValue = 1;
    }
    
    public int roll() {
        faceValue = (int)(Math.random() * MAX) + 1;
        return faceValue;
    }
    
    public void setFaceValue(int value) {
        if(value > 0 && value <= MAX)
            faceValue = value;
    }
    
    public int getFaceValue() {
        return faceValue;
    }
    
    public String toString() {
        String result = Integer.toString(faceValue);
        return result;
    }
}

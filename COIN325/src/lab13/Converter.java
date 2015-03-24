/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab13;

/**
 *
 * @author Dominic
 */
public class Converter {
    
    public static Integer utoi(String toConvert) {
        try {
            return new Integer(Integer.parseInt(toConvert));
        }
        catch(NumberFormatException nfe){
            return null;
        }
    }
    
}

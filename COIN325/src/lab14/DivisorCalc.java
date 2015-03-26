/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab14;

/**
 *
 * @author Dominic
 */
public class DivisorCalc {
    public static int gcd(int num1, int num2) {
        if(num2 <= num1 && num1 % num2 == 0)
            return num2;
        else if(num1 < num2)
            return gcd(num2, num1);
        else
            return gcd(num2, num1%num2);
    }
}

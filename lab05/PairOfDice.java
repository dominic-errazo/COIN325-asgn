/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Dominic
 */
public class PairOfDice {
    
    public static void main(String[] args) {
        
        Scanner inp = new Scanner(System.in);
        
        Die die1 = new Die(), die2 = new Die();
        
        System.out.print("Input the value of the first die: ");
        int setVal = inp.nextInt();
        if(setVal == -1)
            die1.roll();
        else
            die1.setFaceValue(setVal);
        System.out.print("Input the value of the second die: ");
        setVal = inp.nextInt();
        if(setVal == -1)
            die2.roll();
        else
            die2.setFaceValue(setVal);
        System.out.print("The sum is: " + (die1.getFaceValue() + die2.getFaceValue()));
        
    }
    
}

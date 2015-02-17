package lab08;

import javax.swing.JOptionPane;

/**
 *
 * @author Dominic
 */
public class DialogSumProduct {
    public static void main(String[] args) {
        int first, second;
        String firstStr, secondStr;
        do {
            firstStr = JOptionPane.showInputDialog("Please enter the first integer: ");
            secondStr = JOptionPane.showInputDialog("Please enter the second integer: ");
            first = Integer.parseInt(firstStr);
            second = Integer.parseInt(secondStr);
            
            JOptionPane.showMessageDialog(null, "The sum is: " + (first + second) + 
                                            "\nThe product is: " + (first * second));
        }while(JOptionPane.showConfirmDialog(null, "Do you wish to process another?") == JOptionPane.YES_OPTION);
    }
}

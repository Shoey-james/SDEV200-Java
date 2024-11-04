// James Shoemaker
// 9/17/24
// p. 252

import javax.swing.JOptionPane;

public class NumberInput {
    public static void main(String[] args) 
    {
        String inputString;
        int inputNumber, result;
        final int FACTOR = 10;

        inputString = JOptionPane.showInputDialog(null, "Enter a number");
        inputNumber = Integer.parseInt(inputString);

        result = inputNumber * FACTOR;

        JOptionPane.showMessageDialog(null, inputNumber + " * " + FACTOR + " = " + result);
    }
}
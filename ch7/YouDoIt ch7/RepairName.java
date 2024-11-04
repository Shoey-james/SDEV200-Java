// James Shoemaker
// 9/17/24
// p. 251

import javax.swing.JOptionPane;

public class RepairName {
    public static void main(String[] args) 
    {
        String fullName, firstName, lastName, repairedName;

        fullName = JOptionPane.showInputDialog(null, "Please enter your first and last name");
        String names[] = fullName.split(" ");

        firstName = names[0].substring(0, 1).toUpperCase() + names[0].substring(1);
        lastName = names[1].substring(0, 1).toUpperCase() + names[1].substring(1);
        repairedName = firstName + " " + lastName;

        JOptionPane.showMessageDialog(null, "Orignal name was " + fullName +
                "\nRepaired name is " + repairedName);
    }
}
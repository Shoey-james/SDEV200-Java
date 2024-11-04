// James Shoemaker
// 9/30/24
// Bicycles.java p 355


import javax.swing.JOptionPane;

public class Bicycles extends Vehicle {
    public Bicycles() {
        super("a person", 2);
    }

    @Override
    public void setPrice() {
        String entry;
        final int MAX = 4000;
        entry = JOptionPane.showInputDialog(null, "Enter bicycle price ");
        price = Integer.parseInt(entry);
        if (price > MAX)
            price = MAX;
    }

    @Override
    public String toString() {
        return ("The bicycle is powered by " + getPowerSource() + "; it has " + getWheels() + " wheels and costs $"
                + getPrice());
    }
}
// James Shoemaker
// 9/30/24
// DemoVehicles.java p 355

import javax.swing.JOptionPane;

public class DemoVehicles {
    public static void main(String[] args) {
        Sailboat aBoat = new Sailboat();
        Bicycles aBike = new Bicycles();

        JOptionPane.showMessageDialog(null, "\nVehicle descriptions:\n" +
                aBoat.toString() + "\n" + aBike.toString());
    }
}
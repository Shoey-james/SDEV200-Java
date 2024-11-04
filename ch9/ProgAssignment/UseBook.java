// James Shoemaker
// 10/7/24
// UseBook.java p 387-c

import javax.swing.JOptionPane;

public class UseBook {
    public static void main(String[] args) {
        String fictionTitle;
        String nonFictionTitle;
        fictionTitle = JOptionPane.showInputDialog(null, "Enter your fiction book's title: ");
        Fiction fictionBook = new Fiction(fictionTitle);
        nonFictionTitle = JOptionPane.showInputDialog(null, "Enter your fiction book's title: ");
        NonFiction nonFictionBook = new NonFiction(nonFictionTitle);
        JOptionPane.showMessageDialog(null, "Fiction book: " + fictionBook.getTitle() + 
        "\nPrice: $" + fictionBook.getPrice());
        JOptionPane.showMessageDialog(null, "NonFiction book: " + nonFictionBook.getTitle() + 
        "\nPrice: $" + nonFictionBook.getPrice());        

    }
}
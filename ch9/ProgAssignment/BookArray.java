// James Shoemaker
// 10/7/24
// UseBook.java p 387-d

import javax.swing.JOptionPane;

public class BookArray {
    public static void main(String[] args)
    {
        Book[] books = new Book[10];
        int x;
        String userEntry;
        String bookType;
        String fictionTitle;
        String nonFictionTitle;
        for(x=0; x < books.length; ++x)
        {
            userEntry = JOptionPane.showInputDialog(null, "Please select the type of \n" + "book you wish to enter\n: F-fiction" +
            " N-nonfiction");
            bookType = userEntry;
            if(bookType.equalsIgnoreCase("F"))
            {
                fictionTitle = JOptionPane.showInputDialog(null, "Enter your fiction book's title: ");
                books[x] = new Fiction("F " + fictionTitle);
            }
            else if(bookType.equalsIgnoreCase("N"))
            {
                nonFictionTitle = JOptionPane.showInputDialog(null, "Enter your nonfiction book's title: ");
                books[x] = new NonFiction("N " + nonFictionTitle);    
            }
            else
            {
                JOptionPane.showMessageDialog(null, "you typed an invalid entry; please enter and F or N");
                x = x - 1;
            }
        }
        StringBuffer outString = new StringBuffer();
        for(x = 0; x < books.length; ++x)
        {
            outString.append("\n#"+ (x + 1) + "");
            outString.append(" Tile: " + books[x].getTitle());
            outString.append(" Price: $"+ books[x].getPrice());
        }
        JOptionPane.showMessageDialog(null, "Our available books include: \n" + outString.toString());
    }
}
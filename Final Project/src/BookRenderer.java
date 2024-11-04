// James Shoemaker
// 10/8/24
// BookRenderer.java 
// ChatGPT, stack overflow reference when stuck

import java.awt.*;
import javax.swing.*;


// Create book renderer class to display book title, author, genre and availability
class BookRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                boolean isSelected, boolean cellHasFocus) {
        Book book = (Book) value; // Cast to Book

        // Create a string that shows the title, author, genre, and availability
        String displayText = String.format("%s by %s (Genre: %s) - %s", 
                        book.getTitle(), book.getAuthor(), book.getGenre(),
                        book.isAvailable() ? "Available" : "Unavailable");

        // Call the super method to set the text and styling
        JLabel label = (JLabel) super.getListCellRendererComponent(list, displayText, index, isSelected, cellHasFocus);
        label.setText(displayText);
        return label;
    }
}

// James Shoemaker
// 10/8/24
// LibraryApp.java 
// ChatGPT, stack overflow reference when stuck


//create main app
import java.awt.*;
import javax.swing.*;

public class LibraryApp {
    private Library library;
    private JFrame mainFrame;
    private DefaultListModel<Book> bookListModel; // Model for the JList
    private JList<Book> bookList; // List to display books

    public LibraryApp() {
        library = new Library();
        mainFrame = new JFrame("Library Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);
        mainFrame.setLayout(new BorderLayout());

        // Book List Setup
        bookListModel = new DefaultListModel<>();
        bookList = new JList<>(bookListModel);
        bookList.setCellRenderer(new BookRenderer()); // Set the custom renderer
        JScrollPane scrollPane = new JScrollPane(bookList);
        mainFrame.add(scrollPane, BorderLayout.CENTER); // Add the list to the center of the frame

        // Button Panel
        JPanel panel = new JPanel();
        JButton addBookButton = new JButton("Add Book");
        JButton borrowBookButton = new JButton("Borrow Book");
        JButton returnBookButton = new JButton("Return Book");

        panel.add(addBookButton);
        panel.add(borrowBookButton);
        panel.add(returnBookButton);

        mainFrame.add(panel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);

        // Action listeners
        addBookButton.addActionListener(e -> showAddBookDialog());
        borrowBookButton.addActionListener(e -> showBorrowBookDialog());
        returnBookButton.addActionListener(e -> showReturnBookDialog());

        // Load initial book data into the list
        updateBookList();
    }

    private void showAddBookDialog() {
        JTextField titleField = new JTextField(10);
        JTextField authorField = new JTextField(10);
        JTextField genreField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Title:"));
        myPanel.add(titleField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Author:"));
        myPanel.add(authorField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Genre:"));
        myPanel.add(genreField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Book Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Book newBook = new Book(titleField.getText(), authorField.getText(), genreField.getText());
            library.addBook(newBook);
            updateBookList(); // Update the list after adding a book
            JOptionPane.showMessageDialog(mainFrame, "Book added successfully!");
        }
    }

    private void showBorrowBookDialog() {
        JTextField titleField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Title:"));
        myPanel.add(titleField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Book Title to Borrow", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            User user = new User("Default User", "1");
            try {
                library.borrowBook(user, titleField.getText());
                updateBookList(); // Update the list after borrowing a book
                JOptionPane.showMessageDialog(mainFrame, "Book borrowed successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            }
        }
    }

    private void showReturnBookDialog() {
        JTextField titleField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Title:"));
        myPanel.add(titleField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Book Title to Return", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            User user = new User("Default User", "1");
            try {
                library.returnBook(user, titleField.getText());
                updateBookList(); // Update the list after returning a book
                JOptionPane.showMessageDialog(mainFrame, "Book returned successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            }
        }
    }

    // Method to update the list of available books
    private void updateBookList() {
        bookListModel.clear(); // Clear existing list
        for (Book book : library.getBooks()) { // Get the list of books from the library
            bookListModel.addElement(book); // Add book to the model (will show updated availability)
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibraryApp::new);
    }
}


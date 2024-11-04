// James Shoemaker
// 10/8/24
// Library.java 
// ChatGPT, stack overflow reference when stuck

// create library class 

import java.io.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loadData(); // Load data on initialization
    }

    public void addBook(Book book) {
        books.add(book);
        saveData();
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        saveData();
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // book title Not found
    }

    public void borrowBook(User user, String title) throws Exception {
        Book book = searchBook(title);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            user.borrowBook(book);
        } else {
            throw new Exception("Book is not available.");
        }
    }

    public void returnBook(User user, String title) throws Exception {
        Book book = searchBook(title);
        if (book != null) {
            book.setAvailable(true);
            user.returnBook(book);
        } else {
            throw new Exception("This book was not borrowed.");
        }
    }

    // file I/O - 
    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("library.dat"))) {
            oos.writeObject(books);
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// updates array list of books
    public ArrayList<Book> getBooks() {
        return books; // Return the list of all books
    }
    

    @SuppressWarnings("unchecked")
    public void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("library.dat"))) {
            books = (ArrayList<Book>) ois.readObject();
            users = (ArrayList<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            books = new ArrayList<>();
            users = new ArrayList<>();
        }
    }
}

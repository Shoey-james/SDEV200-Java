// James Shoemaker
// 10/8/24
// User.java 
// ChatGPT, stack overflow reference when stuck

//create User class

import java.util.ArrayList;

public class User {
    private String name;
    private String userID;
    private ArrayList<Book> borrowedBooks;

    public User(String name, String userID) {
        this.name = name;
        this.userID = userID;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getUserID() {
        return userID;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}

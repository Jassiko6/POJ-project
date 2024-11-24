package controllers;

import models.Book;
import java.util.ArrayList;
import java.util.List;

public class BookController {
    private List<Book> books;
    private List<Book> favoriteBooks;
    private int nextId;

    public BookController() {
        books = new ArrayList<>();
        favoriteBooks = new ArrayList<>();
        nextId = 1;
    }

    public void addBook(String title, String author, String isbn) {
        Book book = new Book(nextId++, title, author, isbn);
        books.add(book);
    }

    public void removeBook(int bookId) {
        books.removeIf(book -> book.getBookId() == bookId);
        favoriteBooks.removeIf(book -> book.getBookId() == bookId);
    }

    public Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public void addBookToFavorites(Book book) {
        if (!favoriteBooks.contains(book)) {
            favoriteBooks.add(book);
        }
    }

    public void removeBookFromFavorites(int bookId) {
        favoriteBooks.removeIf(book -> book.getBookId() == bookId);
    }
}
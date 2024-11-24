package Main;

import controllers.BookController;
import models.Book;

import java.util.Scanner;

public class Main {
    private static BookController bookController = new BookController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu główne");
            System.out.println("1: Wyświetl wszystkie książki");
            System.out.println("2: Dodaj książkę");
            System.out.println("3: Usuń książkę");
            System.out.println("4: Dodaj książkę do ulubionych");
            System.out.println("5: Wyświetl ulubione książki");
            System.out.println("6: Usuń książkę z ulubionych");
            System.out.println("7: Wyjście");
            System.out.print("Wybierz: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBooks(bookController.getAllBooks());
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    addBookToFavorites();
                    break;
                case 5:
                    displayBooks(bookController.getFavoriteBooks());
                    break;
                case 6:
                    removeBookFromFavorites();
                    break;
                case 7:
                    System.out.println("Zamykanie programu.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private static void displayBooks(Iterable<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void addBook() {
        System.out.print("Podaj tytuł: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.print("Podaj autora: ");
        String author = scanner.nextLine();
        System.out.print("Podaj ISBN: ");
        String isbn = scanner.nextLine();
        bookController.addBook(title, author, isbn);
        System.out.println("Książka dodana.");
    }

    private static void removeBook() {
        System.out.print("Podaj ID książki do usunięcia: ");
        int bookId = scanner.nextInt();
        Book book = bookController.findBook(bookId);
        if (book != null) {
            bookController.removeBook(bookId);
            System.out.println("Książka usunięta.");
        } else {
            System.out.println("Książka o podanym ID nie istnieje.");
        }
    }

    private static void addBookToFavorites() {
        System.out.print("Podaj ID książki do dodania do ulubionych: ");
        int bookId = scanner.nextInt();
        Book book = bookController.findBook(bookId);
        if (book != null) {
            bookController.addBookToFavorites(book);
            System.out.println("Książka dodana do ulubionych.");
        } else {
            System.out.println("Książka o podanym ID nie istnieje.");
        }
    }

    private static void removeBookFromFavorites() {
        System.out.print("Podaj ID książki do usunięcia z ulubionych: ");
        int bookId = scanner.nextInt();
        Book book = bookController.findBook(bookId);
        if (book != null && bookController.getFavoriteBooks().contains(book)) {
            bookController.removeBookFromFavorites(bookId);
            System.out.println("Książka usunięta z ulubionych.");
        } else {
            System.out.println("Książka o podanym ID nie jest w ulubionych.");
        }
    }
}
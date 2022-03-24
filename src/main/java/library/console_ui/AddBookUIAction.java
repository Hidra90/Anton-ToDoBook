package library.console_ui;

import library.Book;
import library.database.Database;

import java.util.Scanner;

public class AddBookUIAction implements UIAction {

    private Database database;

    public AddBookUIAction(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title:");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author");
        String bookAuthor = scanner.nextLine();
        Book book = new Book(bookTitle, bookAuthor);
        database.save(book);
        System.out.println("Your book add to list");

    }
}

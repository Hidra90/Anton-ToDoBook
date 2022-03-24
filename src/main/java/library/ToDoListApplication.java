package library;

import java.util.Scanner;

public class ToDoListApplication {

    public static void main(String[] args) {

        Database database = new InMemoryDatabaseImpl();
        while (true) {
            printProgramMenu();
            int menuNumber = getMenuNumberFromUser();
            executeSelectMenuItem(database, menuNumber);
        }

    }

    public static void printProgramMenu() {

        System.out.println("Hello, please make a choice:");
        System.out.println("1. Add book");
        System.out.println("2. Show book");
        System.out.println("3. Delete book");
        System.out.println("4. Exit");
    }

    public static int getMenuNumberFromUser() {
        System.out.println("Enter menu number:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void executeSelectMenuItem(Database database, int selectMenu) {
        switch (selectMenu) {
            case 1: {
                addNewBookAction(database);
                break;
            }
            case 2: {
                printAllBooksAction(database);
                break;
            }
            case 3: {
                removeBookAction(database);
                break;
            }
            case 4: {
                exitProgramAction();
                break;
            }
        }
    }

    public static void exitProgramAction() {
        System.out.println("Good by");
        System.exit(0);
    }

    public static void printAllBooksAction(Database database) {
        System.out.println("Books list:");
        database.getAllBooks().forEach(System.out::println);
        System.out.println("list end");
    }

    public static void addNewBookAction(Database database) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title:");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author");
        String bookAuthor = scanner.nextLine();
        Book book = new Book(bookTitle, bookAuthor);
        database.save(book);
        System.out.println("Your book add to list");
    }

    public static void removeBookAction(Database database) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book id to remove");
        Long bookId = Long.parseLong(scanner.nextLine());
        database.deleteById(bookId);
        System.out.println("Your book remove to list");
    }
}

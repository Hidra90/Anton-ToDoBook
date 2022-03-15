import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListApplication {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        while (true) {
            printProgramMenu();
            int menuNumber = getMenuNumberFromUser();
            executeSelectMenuItem(books, menuNumber);
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

    public static void executeSelectMenuItem(List<Book> books, int selectMenu) {
        switch (selectMenu) {
            case 1: {
                addNewBookAction(books);
                break;
            }
            case 2: {
                printAllBooksAction(books);
                break;
            }
            case 3: {
                removeBookAction(books);
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

    public static void printAllBooksAction(List<Book> books) {
        System.out.println("Books list:");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("list end");
    }

    public static void addNewBookAction(List<Book> books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title:");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author");
        String bookAuthor = scanner.nextLine();
        Book book = new Book(bookTitle, bookAuthor);
        books.add(book);
        System.out.println("Your book add to list");
    }

    public static void removeBookAction(List<Book> books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title:");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author");
        String bookAuthor = scanner.nextLine();
        Book book = new Book(bookTitle, bookAuthor);
        books.remove(book);
        System.out.println("Your book remove to list");
    }
}

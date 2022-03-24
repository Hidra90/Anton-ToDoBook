package library;

import library.console_ui.*;
import library.database.Database;
import library.database.InMemoryDatabaseImpl;

import java.util.Scanner;

public class ToDoListApplication {

    private static Database database = new InMemoryDatabaseImpl();
    private static UIAction addBookUIAction = new AddBookUIAction(database);
    private static UIAction getAddBookUIAction = new GetAllBookUIAction(database);
    private static UIAction removeBookUIAction = new RemoveBookUIAction(database);
    private static UIAction exitUIAction = new ExitUIAction(database);

    public static void main(String[] args) {

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
                addBookUIAction.execute();
                break;
            }
            case 2: {
                getAddBookUIAction.execute();
                break;
            }
            case 3: {
                removeBookUIAction.execute();
                break;
            }
            case 4: {
                exitUIAction.execute();
                break;
            }
        }
    }


}

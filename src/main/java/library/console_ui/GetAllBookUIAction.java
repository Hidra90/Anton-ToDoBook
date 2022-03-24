package library.console_ui;

import library.database.Database;

public class GetAllBookUIAction implements UIAction {

    private Database database;

    public GetAllBookUIAction(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        System.out.println("Books list:");
        database.getAllBooks().forEach(System.out::println);
        System.out.println("list end");
    }
}

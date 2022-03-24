package library.console_ui;

import library.database.Database;

public class ExitUIAction implements UIAction {

    private Database database;

    public ExitUIAction(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        System.out.println("Good by");
        System.exit(0);
    }
}

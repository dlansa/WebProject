package src.by.htp.web.command;

public class CommandChooser {

    public static Command chooseCommand(String name) {
        Command command = null;
        switch (name) {
            case "auth":
                command = new Authentification();
                break;
            case "addBook":
                command = new CreateBookCommand();
                break;
            case "regstr":
                command = new CreaterUserCommand();
                break;
        }

        return command;
    }
}

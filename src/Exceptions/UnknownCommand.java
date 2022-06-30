package Exceptions;

public class UnknownCommand extends Exception {
    private final String cmdName;

    public UnknownCommand(String message, String cmdName){
        super(message);
        this.cmdName = cmdName;
    }

    public String getCmdName() {
        return cmdName;
    }
}

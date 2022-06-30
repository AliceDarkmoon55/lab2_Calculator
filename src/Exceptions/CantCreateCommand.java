package Exceptions;

public class CantCreateCommand extends Exception {
    final private String cmdName;

    public CantCreateCommand(String message, String cmdName){
        super(message);
        this.cmdName = cmdName;
    }

    public String getCmdName() {
        return cmdName;
    }
}

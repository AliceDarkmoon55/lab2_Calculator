package Exceptions;

public class InvalidArgumentType extends CommandException {
    private final String argument;

    public InvalidArgumentType(String message, String arg){
        super(message);
        this.argument = arg;
    }

    public String getArgument() {
        return argument;
    }
}

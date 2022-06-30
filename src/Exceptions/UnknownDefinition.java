package Exceptions;

public class UnknownDefinition extends Exception {
    private final String key;

    public UnknownDefinition(String message, String key){
        super(message);
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}

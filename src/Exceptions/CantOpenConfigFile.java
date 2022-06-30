package Exceptions;

public class CantOpenConfigFile extends Exception {
    private final String fileName;

    public CantOpenConfigFile(String message, String fileName){
        super(message);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}

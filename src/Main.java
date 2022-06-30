import Exceptions.CantCreateCommand;
import Exceptions.CantOpenConfigFile;
import Exceptions.InvalidNumberOfArguments;
import StackCalculator.StackCalculator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Main {
    static private final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        String path = null;
        if (args.length > 1){
            logger.log(Level.SEVERE, "More than 1 element");
            System.exit(1);
        }
        else if (args.length == 1){
            path = args[0];
        }
        final String loggerConfigFileName = "/config/logger.properties";
        //try{
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream(loggerConfigFileName));
        //}
        /*catch (IOException ex){
            logger.log(Level.SEVERE, "Exception: ", ex);
        }*/
        try {
            StackCalculator calc = new StackCalculator(path);
            calc.makeCount();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

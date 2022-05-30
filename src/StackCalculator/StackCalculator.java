package StackCalculator;

import Commands.ICommand;
import Exceptions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StackCalculator {
    private static final Logger logger = Logger.getLogger(StackCalculator.class.getName());

    public StackCalculator(String path){
        this.path = path;
        stack = new StackWithDefinitions();
    }

    public StackCalculator(){
        this(null);
    }

    public void makeCount() {
        Parser parser = new Parser(path);
        try {
            parser.parse();
        }
        catch (FileNotFoundException ex){
            logger.log(Level.SEVERE, "Exception", ex);
        }
        if (logger.isLoggable(Level.FINE)){
            logger.fine("Successful parsing");
        }
        List<Command> commandsList = parser.getCommandsList();
        CommandFactory factory = null;
        try {
            factory = CommandFactory.instance();
        } catch (CantOpenConfigFile e) {
            e.printStackTrace();
        } catch (CantCreateCommand e) {
            e.printStackTrace();
        }
        for (Command command: commandsList){
            ICommand cmd;
            try{
                cmd = factory.getCommand(command.getName());
            }
            catch (UnknownCommand | CantCreateCommand ex){
                logger.warning("Entered invalid command name.");
                continue;
            }
            if (logger.isLoggable(Level.FINE)){
                logger.fine("Command" + command.getName() + "created");
            }
            try {
                cmd.execute(stack, command.getArgs());
            }
            catch (CommandException ex){
                logger.log(Level.SEVERE, "Exception:", ex);
                return;
            }
        }
    }

    private final String path;
    private final StackWithDefinitions stack;
}

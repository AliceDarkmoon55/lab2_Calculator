package Commands;

import Exceptions.InvalidNumberOfArguments;
import Exceptions.NotEnoughArgumentsForBinaryOperation;
import StackCalculator.StackWithDefinitions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionTest {

    @Test
    void execute() throws InvalidNumberOfArguments, NotEnoughArgumentsForBinaryOperation {
        StackWithDefinitions stack = new StackWithDefinitions();
        Subtraction cmd = new Subtraction();
        for (int i = 0; i < 100; ++i){
            for (int j = 0; j < 100; ++j){
                stack.push(i);
                stack.push(j);
                cmd.execute(stack);
                assertEquals(i - j, stack.pop());
            }
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testEmptyStack() {
        StackWithDefinitions stack = new StackWithDefinitions();
        Subtraction cmd = new Subtraction();
        try {
            cmd.execute(stack);
            fail("Expected InvalidNumberOfArguments");
        }
        catch (InvalidNumberOfArguments ex) {
            assertNotNull(ex.getMessage());
        } catch (NotEnoughArgumentsForBinaryOperation e) {
            e.printStackTrace();
        }
    }
}

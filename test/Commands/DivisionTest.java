package Commands;

import Exceptions.InvalidNumberOfArguments;
import Exceptions.NotEnoughArgumentsForBinaryOperation;
import StackCalculator.StackWithDefinitions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @Test
    void execute() throws InvalidNumberOfArguments, NotEnoughArgumentsForBinaryOperation {
        StackWithDefinitions stack = new StackWithDefinitions();
        Division cmd = new Division();
        for (int i = 1; i < 100; ++i){
            for (int j = 0; j < 100; ++j){
                stack.push(j);
                stack.push(i);
                cmd.execute(stack);
                assertEquals((double)j / i, stack.pop());
            }
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testEmptyStack() {
        StackWithDefinitions stack = new StackWithDefinitions();
        Division cmd = new Division();
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

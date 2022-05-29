package Commands;

import Exceptions.InvalidArgumentType;
import Exceptions.InvalidNumberOfArguments;
import StackCalculator.StackWithDefinitions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest {

    @Test
    void execute() throws InvalidArgumentType, InvalidNumberOfArguments {
        StackWithDefinitions stack = new StackWithDefinitions();
        Define def = new Define();
        assertNull(stack.getDefine("a"));
        def.execute(stack, "a", "1");
        assertEquals(stack.getDefine("a"), 1);
        def.execute(stack, "a", "15");
        assertEquals(stack.getDefine("a"), 1);
    }

    @Test
    public void testLessArguments() {
        StackWithDefinitions stack = new StackWithDefinitions();
        Define def = new Define();
        try {
            cmd.execute(stack);
            fail("Expected InvalidNumberOfArguments");
        }
        catch (InvalidNumberOfArguments ex) {
            assertNotNull(ex.getMessage());
        }
    }
}

import com.version1.DiceRoller;
import com.version1.Exceptions.InvalidDieException;
import com.version1.Exceptions.InvalidOperandException;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DiceRollerTest {

    @Test
    public void interpretDiceRoll_valid() {
        DiceRoller diceRoller = new DiceRoller();

        List<Integer> results = diceRoller.interpretDiceRoll("2d12");

        assertEquals(results.size(), 2);
        assertTrue(results.getFirst() < 13);
        assertTrue(results.getLast() < 13);
    }

    @Test
    public void interpretDiceRoll_invalid() {
        DiceRoller diceRoller = new DiceRoller();

        assertThrows(InvalidDieException.class, () -> diceRoller.interpretDiceRoll("2d13"));
    }

    @Test
    public void resolveDiceRollsInInput() {
        DiceRoller diceRoller = new DiceRoller();

        String s = diceRoller.convertInputToAnExpression("2d4 + 2d4 + 10 - 10 * 10");

        assertTrue(s.matches("\\d+ \\+ \\d+ \\+ 10 - 10 \\* 10"));
    }

    @Test
    public void stringCalculator_validSimpleAddition() throws InvalidOperandException {
        DiceRoller diceRoller = new DiceRoller();

        String input = "8 + 5";

        assertEquals((Integer)13,diceRoller.stringCalculator(input));
    }

    @Test
    public void stringCalculator_validMultipleOperands() throws InvalidOperandException {
        DiceRoller diceRoller = new DiceRoller();

        String input = "1 + 2 + 3 + 4 - 9";

        assertEquals((Integer)1,diceRoller.stringCalculator(input));
    }

    @Test
    public void stringCalculator_validMultipleOperationsBodmas() throws InvalidOperandException {
        DiceRoller diceRoller = new DiceRoller();

        String input = "1 + 2 + 3 + 4 - 9 * 10";

        assertEquals((Integer)10,diceRoller.stringCalculator(input));
    }
}
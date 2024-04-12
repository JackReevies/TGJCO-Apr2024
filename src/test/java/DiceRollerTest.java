import com.version1.DiceRoller;
import com.version1.Exceptions.InvalidDieException;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;

import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DiceRollerTest {

    @Test
    public void testAdd() {
        assertEquals(10,10);
    }

    @Test
    public void interpretDiceRoll_valid() {
        DiceRoller diceRoller = new DiceRoller();

        List<Integer> results = diceRoller.interpretDiceRoll("2d12");

        assertEquals(results.size(), 2);
        assertTrue(results.getFirst() < 13);
        assertTrue(results.getLast() < 13);
    }


    @Test
    public void interpretDiceRoll_bigNumber() {
        DiceRoller diceRoller = new DiceRoller();

        Integer num = Integer.MAX_VALUE;
        List<Integer> results = diceRoller.interpretDiceRoll(num + "d12");

        assertEquals((Integer)results.size(), num);
        assertTrue(results.getFirst() < 13);
        assertTrue(results.getLast() < 13);
    }

    @Test
    public void interpretDiceRoll_invalid() {
        DiceRoller diceRoller = new DiceRoller();

        assertThrows(InvalidDieException.class, () -> diceRoller.interpretDiceRoll("2d13"));
    }
}
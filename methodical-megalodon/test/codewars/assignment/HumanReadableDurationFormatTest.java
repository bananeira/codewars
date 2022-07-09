package codewars.assignment;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class HumanReadableDurationFormatTest {

    @Test
    @Parameters(method = "parametersToTest")
    @TestCaseName("The correct output is {1} given {0} as input.")
    public void expectCorrectOutput(int value, String expected) {
        assertEquals(expected, HumanReadableDurationFormat.formatDuration(value));
    }

    public Object[] parametersToTest() {
        return new Object[] {
            new Object[] { 0, "now" },
            new Object[] { 1, "1 second" },
            new Object[] { 2, "2 seconds" },
            new Object[] { 60, "1 minute" },
            new Object[] { 2341, "39 minutes and 1 second" },
            new Object[] { 23512, "6 hours, 31 minutes and 52 seconds" },
            new Object[] { 2375723, "27 days, 11 hours, 55 minutes and 23 seconds" },
        };
    }
}
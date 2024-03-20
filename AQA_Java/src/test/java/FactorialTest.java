import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {
    @Test(description = "Positive test")
    public void positiveTest() {
        assertEquals(120, Factorial.calculateFactorial(5));
    }

    @Test(description = "Negative test")
    public void negativeTest() {
        assertNotEquals(1, Factorial.calculateFactorial(5));
    }
}

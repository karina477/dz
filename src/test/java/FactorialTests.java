import org.example.Factorial;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTests {
    @DataProvider(name = "factorialData")
    public Object[][] provideFactorialData() {
        return new Object[][] {
                { 0, 1 },
                { 1, 1 },
                { 5, 120 },
                { 12, 479001600 }
        };
    }

    @Test(dataProvider = "factorialData")
    public void testFactorialValidNumbers(int input, int expected) {
        assertEquals(Factorial.calculate(input), expected);
    }
}

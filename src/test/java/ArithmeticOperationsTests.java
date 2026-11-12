import org.example.ArithmeticOperations;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArithmeticOperationsTests {
    @DataProvider(name = "addData")
    public Object[][] provideAddData() {
        return new Object[][] {
                { 2, 3, 5 },
                { -4, -6, -10 },
                { 0, 7, 7 },
                { -5, 5, 0 }
        };
    }

    @DataProvider(name = "subtractData")
    public Object[][] provideSubtractData() {
        return new Object[][] {
                { 10, 4, 6 },
                { 4, 10, -6 },
                { 5, -3, 8 },
                { 0, 5, -5 }
        };
    }

    @DataProvider(name = "multiplyData")
    public Object[][] provideMultiplyData() {
        return new Object[][] {
                { 3, 4, 12 },
                { 7, 0, 0 },
                { -3, 5, -15 },
                { -4, -5, 20 }
        };
    }

    @DataProvider(name = "divideData")
    public Object[][] provideDivideData() {
        return new Object[][] {
                { 10, 2, 5.0 },
                { 5, 2, 2.5 },
                { -9, 3, -3.0 },
                { 0, 5, 0.0 }
        };
    }

    @Test(dataProvider = "addData")
    public void testAdd(int a, int b, int expected) {
        assertEquals(ArithmeticOperations.add(a, b), expected);
    }

    @Test(dataProvider = "subtractData")
    public void testSubtract(int a, int b, int expected) {
        assertEquals(ArithmeticOperations.subtract(a, b), expected);
    }

    @Test(dataProvider = "multiplyData")
    public void testMultiply(int a, int b, int expected) {
        assertEquals(ArithmeticOperations.multiply(a, b), expected);
    }

    @Test(dataProvider = "divideData")
    public void testDivide(int a, int b, double expected) {
        assertEquals(ArithmeticOperations.divide(a, b), expected, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Деление на ноль невозможно")
    public void testDivideByZeroThrowsException() {
        ArithmeticOperations.divide(10, 0);
    }
}

import org.example.ArithmeticOperations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTests {
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "2, 3, 5",
            "-4, -6, -10",
            "0, 7, 7",
            "-5, 5, 0"
    })
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.add(a, b));
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "10, 4, 6",
            "4, 10, -6",
            "5, -3, 8",
            "0, 5, -5"
    })
    void testSubtract(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.subtract(a, b));
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "3, 4, 12",
            "7, 0, 0",
            "-3, 5, -15",
            "-4, -5, 20"
    })
    void testMultiply(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.multiply(a, b));
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "10, 2, 5.0",
            "5, 2, 2.5",
            "-9, 3, -3.0",
            "0, 5, 0.0"
    })
    void testDivide(int a, int b, double expected) {
        assertEquals(expected, ArithmeticOperations.divide(a, b), 0.001);
    }

    @Test
    void testDivideByZeroThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> ArithmeticOperations.divide(10, 0)
        );
        assertEquals("Деление на ноль невозможно", exception.getMessage());
    }
}
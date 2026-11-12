import org.example.Factorial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTests {

    @ParameterizedTest(name = "Факториал {0} должен быть равен {1}")
    @CsvSource({
            "0, 1",
            "1, 1",
            "5, 120",
            "12, 479001600"
    })
    void testFactorialValidNumbers(int input, int expected) {
        assertEquals(expected, Factorial.calculate(input));
    }

    @Test
    void testFactorialOfNegativeNumberThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Factorial.calculate(-1)
        );
        assertEquals("Число должно быть неотрицательным", exception.getMessage());
    }
}
import org.example.NumberComparator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTests {
    @ParameterizedTest(name = "Сравнение {0} и {1} должно вернуть: \"{2}\"")
    @CsvSource({
            "10, 5, '10 > 5'",
            "-2, -8, '-2 > -8'",
            "3, -3, '3 > -3'",
            "4, 9, '4 < 9'",
            "-10, -5, '-10 < -5'",
            "-1, 0, '-1 < 0'",
            "7, 7, '7 = 7'",
            "-5, -5, '-5 = -5'",
            "0, 0, '0 = 0'"
    })
    void testCompare(int a, int b, String expectedResult) {
        assertEquals(expectedResult, NumberComparator.compare(a, b));
    }
}
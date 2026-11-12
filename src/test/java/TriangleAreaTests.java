import org.example.TriangleArea;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaTests {

    @ParameterizedTest(name = "Площадь со сторонами ({0}, {1}, {2}) должна быть {3}")
    @CsvSource({
            "3.0, 4.0, 5.0, 6.0",
            "5.0, 5.0, 6.0, 12.0",
            "6.0, 6.0, 6.0, 15.588",
            "2.5, 3.5, 4.0, 4.330"
    })
    void testValidTriangles(double a, double b, double c, double expectedArea) {
        assertEquals(expectedArea, TriangleArea.getArea(a, b, c), 0.001);
    }

    @ParameterizedTest(name = "Невалидные стороны ({0}, {1}, {2}) должны вызывать исключение")
    @CsvSource({
            "0.0, 4.0, 5.0",
            "-3.0, 4.0, 5.0",
            "1.0, 2.0, 3.0",
            "1.0, 2.0, 10.0"
    })
    void testInvalidTrianglesThrowException(double a, double b, double c) {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TriangleArea.getArea(a, b, c)
        );
        assertEquals("Треугольник с такими сторонами не существует", exception.getMessage());
    }
}
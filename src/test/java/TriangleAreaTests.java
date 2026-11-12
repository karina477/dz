import org.example.TriangleArea;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleAreaTests {
    @DataProvider(name = "validTriangles")
    public Object[][] provideValidTriangles() {
        return new Object[][] {
                { 3.0, 4.0, 5.0, 6.0 },
                { 5.0, 5.0, 6.0, 12.0 },
                { 6.0, 6.0, 6.0, 15.588 },
                { 2.5, 3.5, 4.0, 4.330 }
        };
    }

    @DataProvider(name = "invalidTriangles")
    public Object[][] provideInvalidTriangles() {
        return new Object[][] {
                { 0.0, 4.0, 5.0 },
                { -3.0, 4.0, 5.0 },
                { 1.0, 2.0, 3.0 },
                { 1.0, 2.0, 10.0 }
        };
    }

    @Test(dataProvider = "validTriangles")
    public void testValidTriangles(double a, double b, double c, double expectedArea) {
        assertEquals(TriangleArea.getArea(a, b, c), expectedArea, 0.001);
    }

    @Test(dataProvider = "invalidTriangles",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Треугольник с такими сторонами не существует")
    public void testInvalidTrianglesThrowException(double a, double b, double c) {
        TriangleArea.getArea(a, b, c);
    }
}

import org.example.NumberComparator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberComparatorTests {
    @DataProvider(name = "comparisonData")
    public Object[][] provideComparisonData() {
        return new Object[][] {
                { 10, 5, "10 > 5" },
                { -2, -8, "-2 > -8" },
                { 3, -3, "3 > -3" },
                { 4, 9, "4 < 9" },
                { -10, -5, "-10 < -5" },
                { -1, 0, "-1 < 0" },
                { 7, 7, "7 = 7" },
                { -5, -5, "-5 = -5" },
                { 0, 0, "0 = 0" }
        };
    }

    @Test(dataProvider = "comparisonData")
    public void testCompare(int a, int b, String expectedResult) {
        assertEquals(NumberComparator.compare(a, b), expectedResult);
    }
}

package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CalculatorTestDivision {

    Calculator calculator;

    @BeforeMethod
    public void initializeCalculator() {
        calculator = new Calculator();
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "divisionDouble")
    public void divisionTestMethod(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected, 0.1);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "divisionLong")
    public void divisionTestMethod(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class,
            dataProvider = "divisionLongZero",
            expectedExceptions = NumberFormatException.class)
    public void divisionZeroTestMethodDivision(long a, long b) {
        long actual = calculator.div(a, b);
    }
}

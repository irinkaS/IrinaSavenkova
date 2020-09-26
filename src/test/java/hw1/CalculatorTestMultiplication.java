package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CalculatorTestMultiplication {

    Calculator calculator;

    @BeforeMethod
    public void initializeCalculator() {
        calculator = new Calculator();
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "multiplicationDouble")
    public void multiplicationTestMethod(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected, 0.1);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "multiplicationLong")
    public void multiplicationTestMethod(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }
}

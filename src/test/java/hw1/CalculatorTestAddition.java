package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CalculatorTestAddition {

    Calculator calculator;

    @BeforeMethod
    public void initializeCalculator() {
        calculator = new Calculator();
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "additionDouble")
    public void additionTestMethod(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected, 0.1);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "additionLong")
    public void additionTestMethod(long a, long b, long expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }
}

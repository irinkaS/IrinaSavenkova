package hw1;

import calculator.Calculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CalculatorTestSubtraction {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "subtraction")
    public void substractionTestMethod(double a, double b, double expected) {
        Calculator calculator = new Calculator();
        double actual = calculator.subtraction(a, b);
        assertEquals(actual, expected, 0.1);
    }
}

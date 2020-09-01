package hw1;

import calculator.Calculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CalculatorTestMultiplication {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "multiplication")
    public void multiplicationTestMethod(double a, double b, double expected) {
        Calculator calculator = new Calculator();
        double actual = calculator.multiplication(a, b);
        assertEquals(actual, expected, 0.1);
    }
}

package hw1;

import calculator.Calculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CalculatorTestAddition {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "addition")
    public void additionTestMethod(double a, double b, double expected) {
        Calculator calculator = new Calculator();
        double actual = calculator.addition(a, b);
        assertEquals(actual, expected, 0.1);
    }
}

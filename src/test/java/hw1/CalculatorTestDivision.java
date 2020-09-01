package hw1;

import calculator.Calculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CalculatorTestDivision {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "division")
    public void divisionTestMethod(double a, double b, double expected) {
        Calculator calculator = new Calculator();
        double actual = calculator.division(a, b);
        assertEquals(actual, expected, 0.1);
    }
}

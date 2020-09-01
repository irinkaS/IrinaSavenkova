package hw1;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider(name = "addition")
    public static Object[][] additionDataProviderMethod() {
        return new Object[][]{{1.0, 0.0, 1.0}, {100.4, 99.6, 200.0}};
    }

    @DataProvider(name = "subtraction")
    public static Object[][] subtractionDataProviderMethod() {
        return new Object[][]{{6, 5, 1.0}, {100.00, 99.6, 0.4}};
    }

    @DataProvider(name = "multiplication")
    public static Object[][] multiplicationDataProviderMethod() {
        return new Object[][]{{1.0, 0.0, 0.0}, {5.0, 10, 50.0}};
    }

    @DataProvider(name = "division")
    public static Object[][] divisionDataProviderMethod() {
        return new Object[][]{{1.0, 1.0, 1.0}, {100, 10, 10}};
    }

}

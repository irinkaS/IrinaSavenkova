package hw1;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {


    @DataProvider(name = "additionDouble")
    public static Object[][] additionDoubleDataProviderMethod() {
        return new Object[][]{{1.0, 0.0, 1.0}, {100.4, 99.6, 200.0}};
    }

    @DataProvider(name = "additionLong")
    public static Object[][] additionLongDataProviderMethod() {
        return new Object[][]{{1, 0, 1}, {100, 99, 199}};
    }

    @DataProvider(name = "subtractionDouble")
    public static Object[][] subtractionDoubleDataProviderMethod() {
        return new Object[][]{{6.6, 5.5, 1.1}, {100.00, 99.6, 0.4}};
    }

    @DataProvider(name = "subtractionLong")
    public static Object[][] subtractionLongDataProviderMethod() {
        return new Object[][]{{6, 5, 1}, {100, 99, 1}};
    }

    @DataProvider(name = "multiplicationDouble")
    public static Object[][] multiplicationDoubleDataProviderMethod() {
        return new Object[][]{{1.0, 0.0, 0.0}, {5.0, 10, 50.0}};
    }

    @DataProvider(name = "multiplicationLong")
    public static Object[][] multiplicationLongDataProviderMethod() {
        return new Object[][]{{1, 0, 0}, {5, 15, 75}};
    }

    @DataProvider(name = "divisionDouble")
    public static Object[][] divisionDoubleDataProviderMethod() {
        return new Object[][]{{1.0, 1.0, 1.0}, {100.0, 12.5, 8.0}};
    }

    @DataProvider(name = "divisionLong")
    public static Object[][] divisionLongDataProviderMethod() {
        return new Object[][]{{1, 1, 1}, {100, 10, 10}};
    }

    @DataProvider(name = "divisionLongZero")
    public static Object[][] divisionLongZeroDataProviderMethod() {
        return new Object[][]{{100, 0}};
    }

}

package hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

@Test
public class Ex2 {
    WebDriver driver = null;

    @BeforeTest
    public void startBrowserNavUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    // 1. Open test site by URL
    @Test(priority = 1)
    public void testOpenSiteByUrl() {
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        assertNotEquals(driver.getTitle(), "Page not found · GitHub Pages");
    }

    // 2. Assert Browser title
    @Test(priority = 2)
    public void testAssertBrowserTitle() {
        assertEquals(driver.getTitle(), "Home Page");
    }

    // 3. Perform login
    @Test(priority = 3)
    public void testPerformLogin() {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        assertEquals(driver.findElement(By.cssSelector("div[role='menu']"))
                .findElement(By.className("logout"))
                .findElement(By.cssSelector(".btn-login"))
                .findElement(By.tagName("span"))
                .getText(), "LOGOUT");
    }

    // 4. Assert User name in the left-top side of screen that user is loggined
    @Test(priority = 4)
    public void testUserNameIsShowedCorrectly() {
        assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");
    }

    // 5. Click on "Service" subcategory in the header and check that drop down contains options
    @Test(priority = 5)
    public void testHeaderServiceSubcategories() {
        driver.findElement(By.xpath("//a[contains(text(), 'Service')]"))
                .click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(
                By.xpath("//a[contains(text(), 'Support')]")).getText(), "SUPPORT");
        softAssert.assertEquals(driver.findElement(
                By.xpath("//a[contains(text(), 'Dates')]")).getText(), "DATES");
        softAssert.assertEquals(driver.findElement(
                By.xpath("//a[contains(text(), 'Complex Table')]")).getText(), "COMPLEX TABLE");
        softAssert.assertEquals(driver.findElement(
                By.xpath("//a[contains(text(), 'Simple Table')]")).getText(), "SIMPLE TABLE");
        softAssert.assertEquals(driver.findElement(
                By.xpath("//a[contains(text(), 'Table with pages')]")).getText(),
                "TABLE WITH PAGES");
        softAssert.assertEquals(driver.findElement(
                By.xpath("//a[contains(text(), 'Different elements')]")).getText(),
                "DIFFERENT ELEMENTS");
        softAssert.assertAll();
    }

    // 6. Click on Service subcategory in the left section and check that drop down contains options
    @Test(priority = 6)
    public void testLeftSubcategoryServiceSubcategories() {
        driver.findElement(By.xpath("//span[contains(text(),'Service')]"))
                .click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(
                By.xpath("//span[contains(text(), 'Support')]")).getText(), "Support");
        softAssert.assertEquals(driver.findElement(
                By.xpath("//span[contains(text(), 'Dates')]")).getText(), "Dates");
        softAssert.assertEquals(driver.findElement(
                By.xpath("//span[contains(text(), 'Complex Table')]")).getText(), "Complex Table");
        softAssert.assertEquals(driver.findElement(
                By.xpath("//span[contains(text(), 'Simple Table')]")).getText(), "Simple Table");
        softAssert.assertEquals(driver.findElement(
                By.xpath("//span[contains(text(), 'Table with pages')]")).getText(),
                "Table with pages");
        softAssert.assertEquals(driver.findElement(
                By.xpath("//span[contains(text(), 'Different elements')]")).getText(),
                "Different elements");
        softAssert.assertAll();
    }

    // 7. Open through the header menu Service -> Different Elements Page
    @Test(priority = 7)
    public void testOpenDifferentElementPage() {
        driver.findElement(By.xpath("//a[contains(text(), 'Service')]"))
                .click();
        driver.findElement(By.xpath("//a[contains(text(), 'Different elements')]")).click();
        assertEquals(driver.getTitle(), "Different Elements");
    }

    // 8. Check interface on Different elements page, it contains all needed elements
    @Test(priority = 8)
    public void testBoxesAreDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElements(By.cssSelector(".label-checkbox")).size(), 4);
        for (WebElement element : driver.findElements(By.cssSelector(".label-checkbox"))) {
            assertTrue(element.isDisplayed());
        }
        softAssert.assertEquals(driver.findElements(By.cssSelector(".label-radio")).size(), 4);
        for (WebElement element : driver.findElements(By.cssSelector(".label-radio"))) {
            assertTrue(element.isDisplayed());
        }
        softAssert.assertEquals(driver.findElements(
                By.cssSelector(".colors .uui-form-element")).size(), 1);
        for (WebElement element : driver.findElements(By.cssSelector(
                ".colors .uui-form-element"))) {
            assertTrue(element.isDisplayed());
        }
        softAssert.assertEquals(driver.findElements(
                By.cssSelector(".main-content-hg .uui-button")).size(), 2);
        for (WebElement element : driver.findElements(By.cssSelector(
                ".main-content-hg .uui-bueeon"))) {
            assertTrue(element.isDisplayed());
        }
        softAssert.assertAll();
    }

    // 9. Assert that there is Right Section
    @Test(priority = 9)
    public void testRightSectionExists() {
        assertTrue(driver.findElement(By.name("log-sidebar")).isDisplayed());
    }


    // 10. Assert that there is Left Section
    @Test(priority = 10)
    public void testLeftSectionExists() {
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());
    }

    // 11. Select checkboxes
    @Test(priority = 11)
    public void testSelectCheckboxes() {
        SoftAssert softAssert = new SoftAssert();
        for (WebElement element : driver.findElements(By.cssSelector(".label-checkbox"))) {
            if (element.getText().equals("Water") || element.getText().equals("Wind")) {
                {
                    element.click();
                    softAssert.assertTrue(element.findElement(
                            By.tagName("input")).isSelected());
                }
            }
        }
        softAssert.assertAll();
    }

    // 12. Assert that for each checkbox there is an individual log row
    // and value is corresponded to the status of checkbox
    @Test(priority = 12)
    public void testLogRowForCheckboxTrue() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElements(By.cssSelector(
                ".logs li")).get(1).getText().contains(
                "Water: condition changed to true"));
        softAssert.assertTrue(driver.findElements(By.cssSelector(
                ".logs li")).get(0).getText().contains(
                "Wind: condition changed to true"));
        softAssert.assertAll();
    }


    // 13. Select radio
    @Test(priority = 13)
    public void testSelectRadio() {
        for (WebElement element : driver.findElements(By.cssSelector(".label-radio"))) {
            if (element.getText().equals("Selen")) {
                element.click();
                assertTrue(element.findElement(
                        By.tagName("input")).isSelected());
            }
        }
    }

    // 14. Assert that for radiobutton there is a log row
    // and value is corresponded to the status of radiobutton.
    @Test(priority = 14)
    public void testLogRowForRadioTrue() {
        assertTrue(driver.findElements(By.cssSelector(".logs li")).get(0).getText().contains(
                "metal: value changed to Selen"));
    }

    // 15. Select in dropdown
    @Test(priority = 15)
    public void testSelectDropdown() {
        new Select(driver.findElement(By.cssSelector(
                "select.uui-form-element"))).selectByVisibleText("Yellow");
        assertEquals(new Select(driver.findElement(By.cssSelector(
                "select.uui-form-element"))).getFirstSelectedOption().getText(), "Yellow");
    }

    // 16. Assert that for dropdown there is a log row
    // and value is corresponded to the selected value.
    @Test(priority = 16)
    public void testLogRowForDropdownTrue() {
        assertTrue(driver.findElements(By.cssSelector(".logs li")).get(0).getText().contains(
                "Colors: value changed to Yellow"));
    }

    // 17. Unselect and assert checkboxes
    @Test(priority = 17)
    public void testUnselectCheckboxes() {
        SoftAssert softAssert = new SoftAssert();
        for (WebElement element : driver.findElements(By.cssSelector(".label-checkbox"))) {
            if (element.getText().equals("Water") || element.getText().equals("Wind")) {
                {
                    element.click();
                    softAssert.assertFalse(element.findElement(
                            By.tagName("input")).isSelected());
                }
            }
        }
        softAssert.assertAll();
    }

    // 18. Assert that for each checkbox there is an individual
    // log row and value is corresponded to the status of checkbox
    @Test(priority = 18)
    public void testLogRowForCheckboxFalse() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElements(By.cssSelector(
                ".logs li")).get(1).getText().contains(
                "Water: condition changed to false"));
        softAssert.assertTrue(driver.findElements(By.cssSelector(
                ".logs li")).get(0).getText().contains(
                "Wind: condition changed to false"));
        softAssert.assertAll();
    }
}

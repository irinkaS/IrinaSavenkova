package hw2.ex1;

import com.sun.tools.javac.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

@Test
public class Ex1 {
    WebDriver driver = null;

    @BeforeTest
    public void startBrowserNavUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // 17. Close Browser
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

    // 5. Assert Browser title - look at number 2, it's the same
    @Test(priority = 5)
    public void testAssertBrowserTitle2() {
        assertEquals(driver.getTitle(), "Home Page");
    }

    // 6. Assert that there are 4 items on the header
    // section are displayed and they have proper texts
    @Test(priority = 6)
    public void testHeaderItemsAreShowedCorrectly() {
        assertEquals(driver.findElement(
                By.xpath("//a[contains(text(), 'Home')]")).getText(), "HOME");
        assertEquals(driver.findElement(
                By.xpath("//a[contains(text(), 'Contact form')]")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(
                By.xpath("//a[contains(text(), 'Service')]")).getText(), "SERVICE");
        assertEquals(driver.findElement(
                By.xpath("//a[contains(text(), 'Metals & Colors')]")).getText(), "METALS & COLORS");
    }

    // 7. Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 7)
    public void testImagesAreDisplayed() {
        assertEquals(driver.findElements(By.className("icons-benefit")).size(), 4);
        for (WebElement element : driver.findElements(By.className("icon-benefits"))) {
            assertTrue(element.isDisplayed());
        }
    }

    // 8. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 8)
    public void testTextsBelowImagesAreCorrect() {
        assertEquals(driver.findElements(By.className("benefit-txt")).size(), 4);
        ArrayList<String> textsBelowImages = new ArrayList<>(
                List.of("To include good practices\n"
                                + "and ideas from successful\n"
                                + "EPAM project",
                        "To be flexible and\n"
                                + "customizable",
                        "To be multiplatform",
                        "Already have good base\n"
                                + "(about 20 internal and\n"
                                + "some external projects),\n"
                                + "wish to get more…"
                ));
        int i = 0;
        for (WebElement element : driver.findElements(By.className("benefit-txt"))) {
            assertEquals(element.getText(), textsBelowImages.get(i++));
        }
    }

    // 9. Assert a text of the main headers
    @Test(priority = 9)
    public void testTextOfMainHeader() {
        assertEquals(driver.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.name("jdi-text")).getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING "
                        + "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE "
                        + "ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM "
                        + "VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO "
                        + "LABORIS NISI UT "
                        + "ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE "
                        + "DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE "
                        + "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }

    // 10. Assert that there is the iframe in the center of page
    @Test(priority = 10)
    public void testIFrameExists() {
        assertTrue(driver.findElements(By.tagName("iframe")).size() != 0);
    }

    // 11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
    @Test(priority = 11)
    public void testEpamLogo() {
        driver.switchTo().frame(driver.findElement(By.id("second_frame")));
        assertTrue(driver.findElement(By.id("epam-logo")).isDisplayed());
    }

    // 12. Switch to original window back
    @Test(priority = 12)
    public void testSwitchBackToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    // 13. Assert a text of the sub header
    @Test(priority = 13)
    public void testTextOfSubHeader() {
        assertEquals(driver.findElement(By.cssSelector("h3.text-center a")).getText(),
                "JDI GITHUB");
    }

    // 14. Assert that JDI GITHUB is a link and has a proper URL
    @Test(priority = 14)
    public void testLink() {
        assertEquals(driver.findElement(By.cssSelector("h3.text-center a")).getAttribute("href"),
                "https://github.com/epam/JDI");
    }

    // 15. Assert that there is Left Section
    @Test(priority = 15)
    public void testLeftSectionExists() {
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());
    }

    // 16. Assert that there is Footer
    @Test(priority = 16)
    public void testFooterExists() {
        assertTrue(driver.findElement(By.cssSelector(".footer-content")).isDisplayed());
    }
}

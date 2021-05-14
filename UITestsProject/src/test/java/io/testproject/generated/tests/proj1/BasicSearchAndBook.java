package io.testproject.generated.tests.proj1;

import io.testproject.sdk.drivers.ReportingDriver;
import io.testproject.sdk.drivers.web.RemoteWebDriver;
import io.testproject.sdk.interfaces.junit5.ExceptionsReporter;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@DisplayName("BaiscTest")
class BasicSearchAndBook implements ExceptionsReporter {
    public static WebDriver driver;

    /**
     * ApplicationURL test parameter
     */
    public String ApplicationURL = "http://localhost:8080/";

    @BeforeAll
    static void setup() throws Exception {
        driver = new RemoteWebDriver("coM_An2d3T7SqdUBEwHOl-L-Vzi46ud_-VC7g-Q2rPQ", new ChromeOptions(), "Shubham Rana");
    }

    @DisplayName("BaiscTest")
    @Test
    void execute() throws Exception {
        // set timeout for driver actions (similar to step timeout)
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
        By by;
        boolean booleanResult;

        // 1. Navigate to '{{ApplicationURL}}'
        //    Navigates the specified URL (Auto-generated)
        driver.navigate().to(ApplicationURL);

        // 2. Click 'from1'
        by = By.cssSelector("#origin");
        driver.findElement(by).click();

        // 3. Type 'Londo' in 'from1'
        by = By.cssSelector("#origin");
        driver.findElement(by).sendKeys("Londo");

        // 4. Click 'London'
        by = By.xpath("//li/div[. = 'London']");
        driver.findElement(by).click();

        // 5. Click 'destinationBox'
        by = By.cssSelector("#destinationBox");
        driver.findElement(by).click();

        // 6. Click 'dateBox'
        by = By.cssSelector("#dateBox");
        driver.findElement(by).click();

        // 7. Click 'Search2'
        by = By.xpath("//button[. = 'Search']");
        driver.findElement(by).click();

        // 8. Click 'Select'
        by = By.xpath("//tr[1]//a[. = 'Select']");
        driver.findElement(by).click();

        // 9. Click 'Add Ticket'
        by = By.cssSelector("#btn-ticket");
        driver.findElement(by).click();

        // 10. Click 'Add Ticket'
        by = By.cssSelector("#btn-ticket");
        driver.findElement(by).click();

        // 11. Click 'fullName'
        by = By.cssSelector("#fname");
        driver.findElement(by).click();

        // 12. Type 'Odin Steels' in 'fullName'
        by = By.cssSelector("#fname");
        driver.findElement(by).sendKeys("Odin Steels");

        // 13. Click 'navbarSupportedContent'
        by = By.cssSelector("#navbarSupportedContent");
        driver.findElement(by).click();

        // 14. Click 'customerEmail'
        by = By.cssSelector("#email");
        driver.findElement(by).click();

        // 15. Type 'customereemail@gmail.com' in 'customerEmail'
        by = By.cssSelector("#email");
        driver.findElement(by).sendKeys("customereemail@gmail.com");

        // 16. Click 'address1'
        by = By.cssSelector("#adr1");
        driver.findElement(by).click();

        // 17. Type '#7,  Gold Estate' in 'address1'
        by = By.cssSelector("#adr1");
        driver.findElement(by).sendKeys("#7,  Gold Estate");

        // 18. Click 'address2'
        by = By.cssSelector("#adr2");
        driver.findElement(by).click();

        // 19. Type 'High Road' in 'address2'
        by = By.cssSelector("#adr2");
        driver.findElement(by).sendKeys("High Road");

        // 20. Click 'city'
        by = By.cssSelector("#city");
        driver.findElement(by).click();

        // 21. Type 'Athens' in 'city'
        by = By.cssSelector("#city");
        driver.findElement(by).sendKeys("Athens");

        // 22. Click 'county'
        by = By.cssSelector("#county");
        driver.findElement(by).click();

        // 23. Type 'Greece' in 'county'
        by = By.cssSelector("#county");
        driver.findElement(by).sendKeys("Greece");

        // 24. Click 'postalCode'
        by = By.cssSelector("#zip");
        driver.findElement(by).click();

        // 25. Type 'ATH101' in 'postalCode'
        by = By.cssSelector("#zip");
        driver.findElement(by).sendKeys("ATH101");

        // 26. Click 'cardname'
        by = By.cssSelector("#cname");
        driver.findElement(by).click();

        // 27. Type 'Odin Steels' in 'cardname'
        by = By.cssSelector("#cname");
        driver.findElement(by).sendKeys("Odin Steels");

        // 28. Click 'cardnumber'
        by = By.cssSelector("#ccnum");
        driver.findElement(by).click();

        // 29. Type '7712345732932' in 'cardnumber'
        by = By.cssSelector("#ccnum");
        driver.findElement(by).sendKeys("7712345732932");

        // 30. Click 'exp'
        by = By.cssSelector("#exp");
        driver.findElement(by).click();

        // 31. Type '12/25' in 'exp'
        by = By.cssSelector("#exp");
        driver.findElement(by).sendKeys("12/25");

        // 32. Click 'cvv'
        by = By.cssSelector("#cvv");
        driver.findElement(by).click();

        // 33. Type '789' in 'cvv'
        by = By.cssSelector("#cvv");
        driver.findElement(by).sendKeys("789");

        // 34. Click 'LABEL'
        by = By.xpath("//label[6]");
        driver.findElement(by).click();

        // 35. Click 'Checkout'
        by = By.cssSelector("#btn-checkout");
        driver.findElement(by).click();

    }

    @Override
    public ReportingDriver getDriver() {
        return (ReportingDriver) driver;
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


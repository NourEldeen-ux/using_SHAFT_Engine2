package testPackage;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import gui.pages.Home;
import gui.pages.Results;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
   private ThreadLocal <WebDriver> driver = new ThreadLocal<>();
   private Home homepage;
   private ThreadLocal <JSONFileManager> testData = new ThreadLocal<>();

   @Description("Given the browser is open, When I navigate to google home, Then the google logo is displayed")
    @Test(description = "Check that google logo is displayed")
    public void checkThatGoogleLogoIsDisplayed11() {
       new Home(driver.get()).navigate();
        Validations.assertThat()
                .element(driver.get(), Home.googleLogo_image())
                .matchesReferenceImage()
                .withCustomReportMessage("Assert that the google logo image is displayed properly")
                .perform();
    }

    @Description("Given the browser is open, When I navigate to google home, And I search for SHAFT_Engine, Then the result stats text will not be empty")
    @Test(description = "Check that the result stats text is not empty when you search for SHAFT_Engine")
    public void checkThatResultStatsIsNotEmpty11() {
        testData.getTestData("searchQuery");
       new Home(driver.get()).searchForQuery(testData.getTestData("searchQuery"));
        Validations.assertThat()
                .element(driver.get(), Results.search_textbox())
                .text()
                .doesNotEqual("")
                .withCustomReportMessage("Assert that the result stats is not empty")
                .perform();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.set(DriverFactory.getDriver());
    new Home(driver.get()).navigate();
        testData.set(new JSONFileManager("src/test/resources/testDataFiles/googleSearch.json"));
    }

    @AfterMethod
    public void  afterMethod(){
        BrowserActions.closeCurrentWindow(driver.get());
    }

}

package gui.pages;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Home {
    //variables
    private WebDriver driver;
   private final String url= System.getProperty("googleURL");
    //locators

public static By googleLogo_image(){

    return By.xpath("//img[@alt='Google']");
}

    public static By search_textbox(){
        return By.name("q");
    }

    //constructors
    public Home(WebDriver driver){
     this.driver= driver;
    }

    /**
     * Navigates to google home
     * @return self-reference
     */
    //keywords
    public Home navigate(){
    BrowserActions.navigateToURL(driver, url);
    return this;
    }

    /**
     * Searches for a given string and presses enter
     * @param query the string you want to search for
     * @return self-reference
     */
    public Results searchForQuery(String query){
        (new ElementActions(driver)).type(search_textbox(), query)
                .keyPress(search_textbox(), Keys.ENTER);

      return new Results(driver);
    }


}

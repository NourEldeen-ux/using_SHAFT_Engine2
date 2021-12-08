package gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results {
    private WebDriver driver;

    //constructors
    public Results(WebDriver driver) {
        this.driver = driver;
    }


    public static By search_textbox(){
        return By.id("result-stats");
    }
}

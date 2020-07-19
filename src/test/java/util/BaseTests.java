package util;

import org.openqa.selenium.WebDriver;

public class BaseTests {
    private static WebDriver webDriver;

    public static WebDriver getWebDriver(){
        return webDriver;
    }

}

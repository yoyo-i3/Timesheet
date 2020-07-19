package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ServiceHooks {
    protected static WebDriver driver;


    public static void launchApp(){
        Properties props = System.getProperties();
        try {
            props.load(
                    new FileInputStream(new File("resources/test.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.getProperty("webdriver.chrome.driver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get(System.getProperty("app.url"));
        driver.manage().window().maximize();
        new LoginPage(driver).signIn();
    }

    public static void closeBrowser(){
        driver.quit();
    }

}

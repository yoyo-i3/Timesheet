package stepdefs;

import io.cucumber.java.en.Given;
import pages.LoginPage;
import util.BaseTests;

public class StepDefinitions {
    protected LoginPage loginPage;

    public StepDefinitions(){
        loginPage = new LoginPage(BaseTests.getWebDriver());
    }

    @Given("I login to workday")
    public void login(){
        loginPage.signIn("aya.omar@assurity.co.nz","8N0n0&yoyo" );
    }
}

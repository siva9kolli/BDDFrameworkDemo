package steps;

import Automation.BaseBDD;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginSteps extends BaseBDD {
    public LoginPage loginPage;

    @Given("I'm on Launch screen")
    public void i_m_on_launch_screen() {
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.verifyInputBoxPresent());
    }

    @Then("I login with email {string} and password {string}")
    public void i_login_with_email_and_password(String un, String pwd) {
        loginPage = new LoginPage(driver);
        loginPage.login(un, pwd);

    }

}

package steps;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class LoginSteps {
    public LoginPage loginPage;
    public static WebDriver driver;

    @Before
    public void intilaizeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void killSession(){
        driver.quit();
    }

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

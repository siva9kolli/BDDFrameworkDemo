package Automation;


import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseBDD {

    public static WebDriver driver;

    public static void intilaizeDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        desiredCapabilities.setCapability("browserName", "chrome");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("enable-automation");
        chromeOptions.merge(desiredCapabilities);
        driver = new RemoteWebDriver(new URL("http://192.168.88.2:4444"), chromeOptions);
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static void killSession(){
        driver.quit();
    }

    public void takeSceennShotWhenTestFails(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir")+"/screenshots/test.png");
        try {
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

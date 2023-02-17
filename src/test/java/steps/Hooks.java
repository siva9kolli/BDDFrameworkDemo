package steps;

import Automation.BaseBDD;
import io.cucumber.java.*;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;

public class Hooks {
    public static BaseBDD baseBDD;


    public Hooks(){
    baseBDD = new BaseBDD();
    }

    @BeforeAll
    public static void launchApplication() {
        try {
            baseBDD.intilaizeDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void takeScreensShot(Scenario scenario){
        if(scenario.isFailed()){
        baseBDD.takeSceennShotWhenTestFails();
        }
    }

    @AfterAll
    public static void stopSession(){
        baseBDD.killSession();
    }
}

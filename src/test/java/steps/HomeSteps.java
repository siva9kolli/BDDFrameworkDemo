package steps;

import io.cucumber.java.en.*;

public class HomeSteps {



    @Given("I login to application")
    public void i_login_to_application() {
        System.out.println("I login to application");
    }
    @Then("I verify username {string}")
    public void i_verify_username(String string) {
        System.out.println("I verify username " + string);
    }
    @Then("I logout")
    public void i_logout() {
        System.out.println("I logout");
    }
}

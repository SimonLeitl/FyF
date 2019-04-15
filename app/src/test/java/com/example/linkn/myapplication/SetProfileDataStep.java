package com.example.linkn.myapplication;

import android.support.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.And;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

import org.junit.Rule;

public class SetProfileDataStep extends GreenCoffeeSteps {

    @Rule
    public final ActivityTestRule<LoginActivity> main = new ActivityTestRule<>(LoginActivity.class);

    @When("^Startpage has finished loading")

    @And("^User declines to access location with answer \"([^\"]*)\"$")
    public void userDeclinesTheAccessForLocationWithAnswer(String arg0) throws Throwable {
        String answer = arg0;
        switch (answer) {
            case "accepted":
                onViewWithId(R.layout.registration).type("accepted");
                break;
            case "denied":
                onViewWithId(R.layout.registration).type("denied");
                break;
            default:
                throw new Exception("permission isn`t denied");
        }
    }

    @Then("^Display shows an message \"([^\"]*)\"$")
    public void displayShowsAnMessage(String arg0) throws Throwable {
        String message = arg0;
        switch (message) {
            case "no error":
                onViewWithId(R.layout.registration).type("no error");
                break;
            case "error":
                onViewWithId(R.layout.registration).type("error");
                break;
            default:
                throw new Exception("no error occurred");
        }
    }


}

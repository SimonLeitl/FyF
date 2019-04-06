package com.example.linkn.myapplication.feature;

import com.example.linkn.myapplication.R;
import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.And;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

public class SearchByLocationStep extends GreenCoffeeSteps {

    @When("^Startpage has finished loading")

    @And("^User declines to access location with answer \"([^\"]*)\"$")
    public void userDeclinesTheAccessForLocationWithAnswer(String arg0) throws Throwable {
        String answer = arg0;
        switch (answer) {
            case "accepted":
                onViewWithId(R.id.map).type("accepted");
                break;
            case "denied":
                onViewWithId(R.id.map).type("denied");
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
                onViewWithId(R.id.map).type("no error");
                break;
            case "error":
                onViewWithId(R.id.map).type("error");
                break;
            default:
                throw new Exception("no error occurred");
        }
    }
}
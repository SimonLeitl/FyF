package com.example.linkn.myapplication;

import android.support.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.And;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

import org.junit.Rule;

public class SetProfileDataStep extends GreenCoffeeSteps {

    @Rule
    public final ActivityTestRule<Profile> main = new ActivityTestRule<>(Profile.class);

    @When("^Startpage has finished loading$")

    @And("^User enters \"([^\"]*)\" into input field with id \"([^\"]*)\"$")
    public void userEntersIntoInputFieldWithId(String text, String id) throws Throwable {
        switch (id) {
            case "vorname":
                onViewWithId(R.id.vornameTextBox).type(text);
                break;
            case "nachname":
                onViewWithId(R.id.nameTextBox).type(text);
                break;
            case "name Inhaber":
                onViewWithId(R.id.inhaberTextBox).type(text);
                break;
            case "postcode":
                onViewWithId(R.id.plzTextBox).type(text);
                break;
            case "birthday":
                onViewWithId(R.id.gebTextBox).type(text);
                break;
            default:
                throw new Exception("case not specified");
        }
    }

   /*@Then("^Display shows an message \"([^\"]*)\"$")
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
*/

}

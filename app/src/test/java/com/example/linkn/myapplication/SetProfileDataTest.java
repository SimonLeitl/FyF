package com.example.linkn.myapplication;

import android.support.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeConfig;
import com.mauriciotogneri.greencoffee.GreenCoffeeTest;
import com.mauriciotogneri.greencoffee.ScenarioConfig;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;

@RunWith(Parameterized.class)
public class SetProfileDataTest extends GreenCoffeeTest {

    @Rule
    public ActivityTestRule activity = new ActivityTestRule(Profile.class);

    public SetProfileDataTest(ScenarioConfig scenario) {
        super(scenario);
    }
    @Parameterized.Parameters(name = "{0}")
    public static Iterable scenarios() throws IOException
    {
        return new GreenCoffeeConfig()
                .withFeatureFromAssets("assets/setProfileData.feature")
                .scenarios(
                        //new Locale("en", "GB")
                ); // the locales used to run the scenarios (optional)
    }

    @Test
    public void test()
    {
        start(new SetProfileDataStep());
    }
}

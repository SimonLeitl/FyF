package com.example.linkn.myapplication.feature;

import android.support.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeConfig;
import com.mauriciotogneri.greencoffee.GreenCoffeeTest;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.example.linkn.myapplication.SearchByLocation;
import com.mauriciotogneri.greencoffee.ScenarioConfig;

import java.io.IOException;

@RunWith(Parameterized.class)
public class SearchByLocationTest extends GreenCoffeeTest {

    @Rule
    public ActivityTestRule activity = new ActivityTestRule(SearchByLocation.class);

        public SearchByLocationTest(ScenarioConfig scenarioConfig)
        {
           super(scenarioConfig);
        }

        @Parameterized.Parameters(name = "{0}")
        public static Iterable scenarios() throws IOException
        {
            return new GreenCoffeeConfig()
                    .withFeatureFromAssets("assets/searchByLocation.feature")
                    .scenarios(
                            //new Locale("en", "GB")
                    ); // the locales used to run the scenarios (optional)
        }

        @Test
        public void test()
        {
            start(new SearchByLocationStep());
        }
    }

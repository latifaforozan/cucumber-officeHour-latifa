package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
we will be able to create pre and post conditions for all the Scenarios and even steps
 */
public class Hooks {

    // import the @Before coming from io.cucumber.java

    //@Before
    public void setUp(){
        System.out.println("---> Before: RUNNING BEFORE EACH SCENARIO");
    }

    //@Before (value = "@login", order = 1)
    public void login_Scenario_feature(){
       // System.out.println("---> Before: RUNNING BEFORE EACH SCENARIO");
    }

    /*
    @After will be executed automatically after every scenario in the project
         */
    @After
    public void tearDown(Scenario scenario) {

      //  if(scenario.isFailed()) {

            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/jpg", scenario.getName());

       // }
       // System.out.println("---> After: RUNNING AFTER EACH SCENARIO");
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }

    //@BeforeStep
    public void setUpStep(){
        System.out.println("-----> Before Step :Running Before each step");
    }

    //@AfterStep
    public void tearDownStep(){
        System.out.println("-----> After step : Running After each step");
    }
}

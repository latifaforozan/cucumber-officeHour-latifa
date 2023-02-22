package com.cydeo.step_definitions;

import com.cydeo.pages.ButtonPage;
import com.cydeo.pages.ElementsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class DemoQA_StepDefinition {

    ElementsPage elementsPage = new ElementsPage();
    ButtonPage buttonPage = new ButtonPage();
    Actions actions = new Actions(Driver.getDriver());

    @Given("Navigate to {string} page")
    public void navigate_to_page(String option) {
        Driver.getDriver().get(ConfigurationReader.getProperty("demo.qa.url"));
        BrowserUtils.sleep(7);
        buttonPage.ButtonLink.click();
    }

    @When("Double click on button")
    public void double_click_on_button() {

       actions.doubleClick(buttonPage.doubleClickMe).perform();

    }
    @Then("Verify text double click message {string} should be visible")
    public void verify_text_double_click_message_should_be_visible(String expectedMassage) {
        Assert.assertEquals(expectedMassage, buttonPage.doubleClickMessageYouHave.getText());
    }
    @Then("Right click on button")
    public void right_click_on_button() {
       actions.contextClick(buttonPage.rightClickMe).perform();
    }
    @Then("Verify text right click message {string} should be visible")
    public void verify_text_right_click_message_should_be_visible(String expectedMsg) {
Assert.assertEquals(expectedMsg, buttonPage.rightClickMessageYouHave.getText());
    }
    @Then("Click Me button")
    public void click_me_button() {
       buttonPage.clickMe.click();

    }
    @Then("Verify text click me message {string} should be visible")
    public void verify_text_click_me_message_should_be_visible(String expectedMassage) {
        Assert.assertEquals(expectedMassage, buttonPage.dynamicClickMessageYouHave.getText());

    }


}

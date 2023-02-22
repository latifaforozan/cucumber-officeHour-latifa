package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {


    //TC #2: Create utility method
    //1. Create a new class called BrowserUtils
    //2. Create a method to make Task1 logic re-usable
    //3. When method is called, it should switch window and verify title.
    //Method info:
    //• Name: switchWindowAndVerify
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedInUrl
    //• Arg3: String expectedTitle

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle) {

        Set<String> allWindows = Driver.getDriver().getWindowHandles();

        for (String eachWindow : allWindows) {

            Driver.getDriver().switchTo().window(eachWindow);

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    /*
    This method will accept int(in seconds)
    and execute Thread.sleep method for given duration
      */

    public static void sleep(int second) {
        second *= 1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    //TC #3: Create utility method
    //1. Create a new method for title verification
    //2. Create a method to make title verification logic re-usable
    //3. When method is called, it should simply verify expected title with actual
    //title
    //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle

    public static void verifyTitle(String expectedTitle) {//title verification
        Assert.assertEquals("Title verification did not pass!!!",expectedTitle,Driver.getDriver().getTitle() );
    }

    public static void verifyTitleContians(String expectedInTitle) {//title verification
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    public static  void verifyURLContains(String expectedInURL){
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedInURL));
    }

    /*
    accept a element target and wait to that lement not to be displayed on the page
     */
    public static void waitForInvisibilityOfGivenElement(WebElement target) {
        // creat object of  WebDriverWait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        // use the obj to create explicit wait condition
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /*
    This method accept a title and wait until title is matching
     */
    public static void waitForInvisibilityOfGivenElement(String title) {
        // creat object of  WebDriverWait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        // use the obj to create explicit wait condition
        wait.until(ExpectedConditions.titleContains(title));
    }

    /**
     * This method just accept a dropDown element and returns a list<String> that contsins all options values as String
     * @param dropDown
     * @returnactualMonthAsString
     */

    public  static List<String> dropDownOptins_as_String(WebElement dropDown){
        Select month = new Select(dropDown);
        //storing all the actual options in to a list of web element
        List<WebElement> actualMonthAsWebElement = month.getOptions();

        List<String> actualMonthAsString = new ArrayList<>();// creating an empty list of string to store actual options as String
  //lopping through the List<WebElement> getting all options's texts and storing them in a list<String>
        for (WebElement eachMonth : actualMonthAsWebElement) {
            actualMonthAsString.add(eachMonth.getText());
        }
     return actualMonthAsString;
    }
//-------------------------------------------------List of radio buttons------   value is differnt for each of them
    public static  void clickRadioButton(List<WebElement> radioButtons, String attributeValue){
        for (WebElement each : radioButtons) {
            if(each.getAttribute("value").equals(attributeValue)){
                each.click();
            }
            
        }




    }
}

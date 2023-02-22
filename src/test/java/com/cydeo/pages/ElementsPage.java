package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {

   public ElementsPage() { // if we are not using @findBy( not locate element) do not need cons// but if use @findBy we have to use cons

        PageFactory.initElements(Driver.getDriver(), this);// here we just click some links
    }

    public void clickOption(String option){
        String locator="//li[.='"+option+"']";
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }
}

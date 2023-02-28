package com.cydeo.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.time.Duration;

public class Driver {

    //Create a private constructor to prevent the access to this obj outside the class

    private Driver() {
    }

    /*
    Create a private WebDriver variable/obj to prevent the access to this obj outside the class
    we make it static because we use it in a static method( getter)
     */
    private static WebDriver driver;// default value = null

    // create public getDriver(getter) to access the driver outside the class but under our given condition

    /*
    Create a re_usable utility method which will return the same driver instance once we call it.
    If an instance does not exist , it will create first , and then it will always return same instance
     */

    public static WebDriver getDriver() {
        if (driver == null) {// singleton logic
            /*
            we will read our browser from configuration.properties file
            This way we will control which browser is opened from out side of our code
             */

            String browserType = ConfigurationReader.getProperty("browser");
        /*
        Depending on the browser type returned from the configuration.properties
        switch statement will determine the case and open the matching one
         */
            switch (browserType) {// using switch
                case "chrome":
                    //WebDriverManager.chromedriver().setup();// in the real work environment we might have the own dependency to use
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();// selenium has the webDriver manager as its internal tool so do not need to setup it and also add its dependencies in the pom.xmcatal
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "safari":
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "adfree-chrome":
                    ChromeOptions options = new ChromeOptions(); //Create options object so that we can change some browser options
                    options.addExtensions(new File("src/test/resources/AdBlock-—-best-ad-blocker (2).crx"));

                    DesiredCapabilities capabilities = new DesiredCapabilities(); //Setting up the capabilities of the browser
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    driver = new ChromeDriver(options);
                    break;
            }
        }
        return driver;
    }

    /*
   Create a new DriverClose() ; it will use .quit() method to quit browser ,
   and then set the driver value back to null
   */
    public static void closeDriver() {
        if (driver != null) {
            /*
          This line will terminate the currently existing driver completely it will not exist going forward
             */
            driver.quit();
            /*
            we assign value back to the "null" , so the "singleton" can create a newer one if needed
             */
            driver = null;
        }
    }
}

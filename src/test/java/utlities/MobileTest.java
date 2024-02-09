package utlities;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.*;


public class MobileTest {
    static DesiredCapabilities capabilities;
    static URL url;
    static AndroidDriver driver;
    @Before
    public void setup() throws MalformedURLException{
        System.out.println("Mobile");
        url = new URL("http://localhost:4723/wd/hub");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("deviceName", "sdk_gphone64_x86_64");

        driver = new AndroidDriver(url,capabilities);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
    @Given("user on Notification settings page")
    public void user_on_settings_page() {
        driver.activateApp("com.android.settings");
        System.out.println("Current Activity "+driver.currentActivity());
        System.out.println("Current Package"+driver.getCurrentPackage());
    }

    @When("user clicked Notification settings")
    public void userClickedSettingsIcon() {

        driver.findElement(By.xpath("//android.widget.TextView[@text='Notifications']")).click();

    }

    @Then("Notification settings should be displayed")
    public void settingsIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Current Activity "+driver.currentActivity());
        System.out.println("Current Package"+driver.getCurrentPackage());
    }

    @When("App notifications is clicked")
    public void appNotificationsIsClicked() {
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Control notifications')]")).click();
    }

    @Then("App notifications should be displayed")
    public void appNotificationsShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println("Current Activity "+driver.currentActivity());
        System.out.println("Current Package"+driver.getCurrentPackage());
    }

    @When("Notification history is clicked")
    public void notificationHistoryIsClicked() {
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'history')]")).click();
    }

    @Then("Notification history should be displayed")
    public void notificationHistoryShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println("Current Activity "+driver.currentActivity());
        System.out.println("Current Package"+driver.getCurrentPackage());
    }

    @When("Conversations is clicked")
    public void conversationsIsClicked() {
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'No priority')]")).click();
    }

    @Then("Conversations should be displayed")
    public void conversationsShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println("Current Activity "+driver.currentActivity());
        System.out.println("Current Package"+driver.getCurrentPackage());
    }

    @When("Bubbles is clicked")
    public void bubblesIsClicked() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Bubbles']")).click();
    }

    @Then("Bubbles should be displayed")
    public void bubblesShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println("Current Activity "+driver.currentActivity());
        System.out.println("Current Package"+driver.getCurrentPackage());
    }
    @After
    public void cleanUp(){
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }

}

package utlities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest {
    static DesiredCapabilities capabilities;
    static URL url;
    static AndroidDriver driver;
    static WebDriver webDriver;
    static RemoteWebDriver remoteWebDriver;
    @Before
    public void setup() throws MalformedURLException {
        System.out.println("Mobile");
        url = new URL("http://localhost:4723/wd/hub");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("deviceName", "sdk_gphone64_x86_64");

        driver = new AndroidDriver(url,capabilities);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
    @Given("user enters chrome browser")
    public void user_enters_chrome_browser() {
        driver.activateApp("com.android.chrome");
    }

    @When("user entered in search")
    public void userEnteredInSearch() {
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\'com.android.chrome:id/url_bar\']")).sendKeys("karthikesavan.online");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\'com.android.chrome:id/url_bar\']")).click();
//        driver = webDriver.Remote("");
    }

    @Then("results should be displayed")
    public void resultsShouldBeDisplayed() {

    }
}

package ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Base {

    public AppiumDriver driver;
    private long timeOutInSeconds = 30;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws Exception {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("platformVersion", "13.4");
        desiredCapabilities.setCapability("deviceName", "iPhone 8");
        desiredCapabilities.setCapability("isHeadless", false);
        desiredCapabilities.setCapability("fullReset", false);
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("useNewWDA", false);
        desiredCapabilities.setCapability("printPageSourceOnFindFailure", true);
        desiredCapabilities.setCapability("app", "/Users/zovsky/Downloads/UIKitCatalog.app");

        desiredCapabilities.setCapability("wdaStartupRetries", "4");
        desiredCapabilities.setCapability("iosInstallPause","8000" );
        desiredCapabilities.setCapability("wdaStartupRetryInterval", "20000");

//        desiredCapabilities.setCapability("fullContextList", true);
//        desiredCapabilities.setCapability("webViewConnectTimeout", 10000);


        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebElement waitForElement(String elementName) {
        wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.name(elementName)));
    }

    public void tapOnElement(String elementName) {
        WebElement element = waitForElement(elementName);
        element.click();
    }

    public void setPickerValue(String elementName, String value) {
        WebElement element = waitForElement(elementName);
        element.sendKeys(value);
    }

    public void setDatePickerValue(String value, int position) {
        WebElement element = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(position);
        element.sendKeys(value);
    }

    public void tapOnFirstFoundElement(String elementName) {
        List<WebElement> elements = driver.findElements(By.name(elementName));
        WebElement element = elements.get(0);
        element.click();
    }

    public void tapOnNthElementOfKind(String elementName, int elementNumber) {
        List<WebElement> elements = driver.findElements(By.name(elementName));
        WebElement element = elements.get(elementNumber);
        element.click();
    }

    public void swipeUpHalfScreen() {
        Dimension dimension = driver.manage().window().getSize();
        Double horizontalPoint = dimension.getWidth() * 0.5;
        int horiz = horizontalPoint.intValue();
        Double scrollHeightStart = dimension.getHeight() * 0.5;
        int scrollStart = scrollHeightStart.intValue();
        Double scrollHeightEnd = dimension.getHeight() * 0.05;
        int scrollEnd = scrollHeightEnd.intValue();

        new TouchAction((PerformsTouchActions) driver)
                .longPress(PointOption.point(horiz, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(horiz, scrollEnd))
                .release().perform();
    }

}

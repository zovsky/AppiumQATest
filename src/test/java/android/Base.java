package android;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "10");
        desiredCapabilities.setCapability("deviceName", "Android Emulator");
        desiredCapabilities.setCapability("isHeadless", false);
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("fullReset", false);
        desiredCapabilities.setCapability("noReset", false);
        desiredCapabilities.setCapability("useNewWDA", false);
        desiredCapabilities.setCapability("printPageSourceOnFindFailure", true);
        desiredCapabilities.setCapability("app", "/Users/zovsky/Downloads/apidemos.apk");

//        desiredCapabilities.setCapability("wdaStartupRetries", "4");
//        desiredCapabilities.setCapability("iosInstallPause","8000" );
//        desiredCapabilities.setCapability("wdaStartupRetryInterval", "20000");
//
//        desiredCapabilities.setCapability("fullContextList", true);
//        desiredCapabilities.setCapability("webViewConnectTimeout", 10000);


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebElement waitForElement(By by) {
        wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void tapOnElement(By by) {
        WebElement element = waitForElement(by);
        element.click();
    }

    public void longTapOnElement(By by) {
        WebElement element = waitForElement(by);
        TouchAction action = new TouchAction(driver);
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)));
        action.perform();
    }

    public void dragNDropFromTo(By fromElement, By toElement) {
        WebElement from = waitForElement(fromElement);
        WebElement to = waitForElement(toElement);
        TouchAction action = new TouchAction(driver);
        action.longPress(PointOption.point(getCenterPointOf(from)))
                .moveTo(PointOption.point(getCenterPointOf(to)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .release();
        action.perform();
    }

    public Point getCenterPointOf(WebElement element) {
        int x = element.getRect().getX() + element.getRect().getWidth()/2;
        int y = element.getRect().getY() + element.getRect().getHeight()/2;

        return new Point(x,y);

    }

//    public void setPickerValue(String elementName, String value) {
//        WebElement element = waitForElement(elementName);
//        element.sendKeys(value);
//    }

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

    public WebElement waitForMobileElement(String elementName) {
        wait = new WebDriverWait(driver, timeOutInSeconds);
        By element = MobileBy.AccessibilityId(elementName);
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void tapOnMobileElement(String accessibilityId) {
        WebElement element = waitForMobileElement(accessibilityId);
        element.click();
    }

    public void longTapOnMobileElement(String elementName) {
        WebElement element = waitForMobileElement(elementName);
        TouchActions action = new TouchActions(driver);
        action.longPress(element);
        action.perform();
    }

    public void typeIn(By by, String input) {
        WebElement element = waitForElement(by);
        element.click();
        element.sendKeys(input);
    }

    public void scrollIntoView(String text) {
        MobileElement element = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector()).setAsVerticalList().scrollIntoView(" +
                        "new UiSelector().text(\""+text+"\"))"));
    }

}

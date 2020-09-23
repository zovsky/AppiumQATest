package ios;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Steppers extends Base{

    @Test
    public void checkSteppersCounters() {
        tapOnElement("Steppers");
        WebElement def = driver.findElementByXPath("//*[contains(@name, 'DEFAULT')]/following-sibling::XCUIElementTypeCell/*[contains(@name, 'Increment')]");
        WebElement tin = driver.findElementByXPath("//*[contains(@name, 'TINTED')]/following-sibling::XCUIElementTypeCell/*[contains(@name, 'Increment')]");
        WebElement cus = driver.findElementByXPath("//*[contains(@name, 'CUSTOM')]/following-sibling::XCUIElementTypeCell/*[contains(@name, 'Increment')]");

        for (int i=0; i<7; i++) {
            def.click();
        }

        for (int i=0; i<4; i++) {
            tin.click();
        }

        for (int i=0; i<3; i++) {
            cus.click();
        }

        Assert.assertEquals(driver.findElementByXPath("//*[contains(@name, 'DEFAULT')]/following-sibling::XCUIElementTypeCell/child::XCUIElementTypeStaticText")
                        .getText(), "7");
        Assert.assertEquals(driver.findElementByXPath("//*[contains(@name, 'TINTED')]/following-sibling::XCUIElementTypeCell/child::XCUIElementTypeStaticText")
                .getText(), "4");
        Assert.assertEquals(driver.findElementByXPath("//*[contains(@name, 'CUSTOM')]/following-sibling::XCUIElementTypeCell/child::XCUIElementTypeStaticText")
                .getText(), "3");
    }

}

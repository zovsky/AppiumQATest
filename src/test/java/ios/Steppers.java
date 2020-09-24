package ios;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Steppers extends Base{

/*Steppers
• From the main view, navigate to Steppers
• Tap on + on Default section 7 times
• Tap on + on Tinted section 4 times
• Tap on + on Custom section 3 times
• The test success if: the counters at the right of each section are 7, 4 and 3
*/

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

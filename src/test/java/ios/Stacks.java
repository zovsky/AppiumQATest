package ios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Stacks extends Base{

    @Test
    public void checkStackViewsAdded() {
        tapOnElement("Stack Views");

//        tapOnFirstFoundElement("stepper increment");
//        tapOnNthElementOfKind("stepper increment", 1);

        driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name, 'Detail')]/following-sibling::XCUIElementTypeButton").click();
        driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name, 'Add/remove views')]/following-sibling::XCUIElementTypeButton").click();

        Assert.assertTrue(driver.findElementByName("Further Detail").isDisplayed());
        Assert.assertTrue(driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name, 'Add/remove views')]/parent::*/following-sibling::*/child::*")
                        .isDisplayed());
    }

}

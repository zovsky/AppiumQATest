package ios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Stacks extends Base{

/*Stacks
• From the main view, navigate through Views -> Stack Views
• Tap on the + button at the right of Detail
• Tap on the + button at the right of Add/remove views
• The test success if: Further Detail appeared in the Showing/hiding views section, and a color
square appeared in the Add/remove views section
*/

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

package ios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PickerView extends Base{

/*Color picker
• From the main view, navigate to Picker View
• Change the value of left, middle and right pickers to values of your choice
• The test success if: the three values were changed to the expected ones
*/

    @Test
    public void checkPickerViewValuesChanged() {
        tapOnElement("Picker View");
        setPickerValue("Red color component value", "60");
        setPickerValue("Green color component value", "65");
        setPickerValue("Blue color component value", "70");
        Assert.assertEquals(driver.findElementByName("Red color component value").getText(), "60");
        Assert.assertEquals(driver.findElementByName("Green color component value").getText(), "65");
        Assert.assertEquals(driver.findElementByName("Blue color component value").getText(), "70");

    }

}

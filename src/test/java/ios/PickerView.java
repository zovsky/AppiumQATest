package ios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PickerView extends Base{

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

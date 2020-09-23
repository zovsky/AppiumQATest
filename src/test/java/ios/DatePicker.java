package ios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePicker extends Base{

    @Test
    public void checkDateSetCorrectly() {
        tapOnElement("Date Picker");

        setDatePickerValue("Sep 26", 0);
        setDatePickerValue("7", 1);
        setDatePickerValue("56", 2);
        setDatePickerValue("AM", 3);

        Assert.assertEquals(((WebElement) driver
                .findElements(By.className("XCUIElementTypeStaticText")).get(1)).getText(), "Sep 26, 2020 at 7:56 AM");

    }

}

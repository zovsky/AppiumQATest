package android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragNDrop extends Base {

/*Drag and Drop
• From the main view, navigate through Views -> Drag and Drop
• Drag one circle into a different circle. For example, the top left circle to the top right circle
• The test success if: a text appears at the bottom saying “Dropped!”
*/

    @Test
    public void checkTheDropExclamationMark() {

        tapOnMobileElement("Views");
        tapOnMobileElement("Drag and Drop");

        dragNDropFromTo(By.id("io.appium.android.apis:id/drag_dot_1"), By.id("io.appium.android.apis:id/drag_dot_2"));

        Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(), "Dropped!");
    }

}

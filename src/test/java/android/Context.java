package android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Context extends Base {

    /*
    From the main view, navigate through Views -> Expandable Lists -> Custom Adapter
    Perform a long tap on People Names row
    Select Sample action in the Sample menu
    The test success if: a Toast appears with some text
     */

    @Test
    public void checkToastAppearsWithText() {

        tapOnMobileElement("Views");
        tapOnMobileElement("Expandable Lists");
        tapOnMobileElement("1. Custom Adapter");

        longTapOnElement(MobileBy.AndroidUIAutomator("text(\"People Names\")"));
        tapOnElement(MobileBy.AndroidUIAutomator("text(\"Sample action\")"));

        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.Toast[1]")).getText(), "People Names: Group 0 clicked");
    }

}

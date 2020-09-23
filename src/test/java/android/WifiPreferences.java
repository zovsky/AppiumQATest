package android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WifiPreferences extends Base {

    @Test
    public void checkWifiSettingsText() {

        final String text = "Hello there!";
        tapOnMobileElement("Preference");
        tapOnMobileElement("3. Preference dependencies");
        tapOnElement(By.className("android.widget.CheckBox"));
        tapOnElement(MobileBy.AndroidUIAutomator("text(\"WiFi settings\")"));
        typeIn(By.className("android.widget.EditText"), text);
        tapOnElement(By.id("android:id/button1"));
        tapOnElement(MobileBy.AndroidUIAutomator("text(\"WiFi settings\")"));

        Assert.assertEquals(driver.findElement(By.className("android.widget.EditText")).getText(), text);

    }

}

package android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends Base {

/*Search
• From the main view, navigate through Views -> Search View -> Filter
• Write ‘Colby' as text filter
• The test success if: the first result is Colby
*/

    @Test
    public void checkWifiSettingsText() {

        final String text = "Colby";

        tapOnMobileElement("Views");
        scrollIntoView("Search View");
        tapOnMobileElement("Search View");
        tapOnMobileElement("Filter");
        typeIn(By.className("android.widget.EditText"), text);

        Assert.assertEquals(driver.findElement(By.id("android:id/text1")).getText(), text);

    }

}

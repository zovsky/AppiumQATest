package android;

import org.testng.annotations.Test;

import java.util.Set;

public class WebView extends Base {

/*WebView
• From the main view, navigate through Views -> WebView
• Tap on the “I am a link” link
• The test success if: a web with the text “I am one other page content” appears
*/

    @Test
    public void checkHTMLContainsText() {

        tapOnMobileElement("Views");
        scrollIntoView("Webview");
        tapOnMobileElement("WebView");

        Set contextNames = driver.getContextHandles();
        System.out.println(contextNames.size());

    }

}

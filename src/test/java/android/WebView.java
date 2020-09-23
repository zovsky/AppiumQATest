package android;

import org.testng.annotations.Test;

import java.util.Set;

public class WebView extends Base {

    @Test
    public void checkHTMLContainsText() {

        tapOnMobileElement("Views");
        scrollIntoView("Webview");
        tapOnMobileElement("WebView");

        Set contextNames = driver.getContextHandles();
        System.out.println(contextNames.size());

    }

}

package ios;

import org.testng.annotations.Test;

import java.util.Set;

public class WKWebView extends Base{

    @Test
    public void checkHTMLContainsText() {
        swipeUpHalfScreen();
        tapOnElement("Web View");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set contextNames = driver.getContextHandles();
        System.out.println(contextNames.size());
        //driver.context((String) contextNames.toArray()[1]);

        System.out.println(driver.getPageSource());

    }

}

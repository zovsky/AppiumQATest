package ios;

import org.testng.annotations.Test;

import java.util.Set;

public class WKWebView extends Base{

/*WKWebView
• From the main view, navigate through Views -> Web View
• Obtain the text shown inside the web view
• The test success if: the text of the html content contains the text “This is HTML”
*/

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

    }

}

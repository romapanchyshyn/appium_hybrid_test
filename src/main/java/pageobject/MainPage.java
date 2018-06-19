package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private static final Logger LOGGER = LogManager.getLogger(MainPage.class);

    @FindBy(id = "buttonStartWebview")
    private WebElement webviewButton;

    public void clickWebviewButton() {
        LOGGER.info("Click on webview button");
        webviewButton.click();
    }
}

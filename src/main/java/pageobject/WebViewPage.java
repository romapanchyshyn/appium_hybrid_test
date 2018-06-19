package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebViewPage {
    private static final Logger LOGGER = LogManager.getLogger(WebViewPage.class);

    @FindBy(id = "name_input")
    private WebElement nameField;
    @FindBy(tagName = "body")
    private WebElement resultBody;

    public WebElement getResultBody() {
        return resultBody;
    }

    public void setNameField(String name) {
        LOGGER.info("Inputting [{}] to name field", name);
        nameField.clear();
        nameField.sendKeys(name);
        nameField.submit();
    }


}

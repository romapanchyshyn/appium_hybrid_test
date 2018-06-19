import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import javafx.scene.web.WebView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.MainPage;
import pageobject.WebViewPage;

import java.net.URL;
import java.util.Set;

public class TestWebView {
    private final static String NAME = "Roman Panchyshyn";
    private final static String CONTEXT_NAME = "WEBVIEW";
    private AppiumDriver<WebElement> driver;

    @BeforeMethod
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AppiumTest");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testResultPage() {
        MainPage mainPage = new MainPage();
        WebViewPage webViewPage = new WebViewPage();
        PageFactory.initElements(driver, mainPage);
        mainPage.clickWebviewButton();
        setContext(CONTEXT_NAME);
        PageFactory.initElements(driver, webViewPage);
        webViewPage.setNameField(NAME);
        Assert.assertTrue(webViewPage.getResultBody().getText().contains(NAME));
    }

    private void setContext(String name) {
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains(name)) {
                driver.context(contextName);
            }
        }
    }
}

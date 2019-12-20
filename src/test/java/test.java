import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class test {
    public WebDriver driver;
    @Test
    public void main() {
        driver.navigate().to("http://www.baidu.com");
        String strPageTitle = driver.getTitle();
        System.out.println("Page title: - "+strPageTitle);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("百度一下，你就知道"), "Page title doesn't match");
    }
    @BeforeClass
    public void beforeMethod() {
        File file = new File("D:\\webdriver\\chromedriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Yo-Sheng\\AppData\\Local\\CentBrowser\\Application\\chrome.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
    }
    @AfterClass
    public void afterMethod() {
        driver.quit();
    }
}

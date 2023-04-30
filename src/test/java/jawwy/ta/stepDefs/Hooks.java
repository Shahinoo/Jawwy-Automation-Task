package jawwy.ta.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    Scenario scenario;

    @Before
    public static void OpenBrowser() {
        //1. using chrome driver
        WebDriverManager.chromedriver().setup();
        //2. instantiate object from Chrome driver
        driver = new ChromeDriver();
        //3. configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //4. Navigation
        //driver.navigate().to("https://subscribe.stctv.com/");
    }

    @After
    public void CloseBrowser(Scenario sce) {
        this.scenario = sce;
        // take screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] data = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        sce.attach(data, "image/png", "screenshot attached");
        // close Browser
        driver.quit();
        scenario.log("Browser is closed");
    }
}

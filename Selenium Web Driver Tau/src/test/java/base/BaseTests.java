package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.List;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        homePage = new HomePage(driver);

        //1 - Maximize the window
        driver.manage().window().maximize();

        //2 - Fullscreen mode
        driver.manage().window().fullscreen();

        //3 - Specific width (iPhoneX)
        driver.manage().window().setSize(new Dimension(375, 812));

        List<WebElement> links =  driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        
        WebElement inputLink =  driver.findElement(By.linkText("Shifting Content"));
        inputLink.click();

        WebElement inputLink02 =  driver.findElement(By.linkText("Example 1: Menu Element"));
        inputLink02.click();

        List<WebElement> links02 =  driver.findElements(By.tagName("li"));
        System.out.println("Shifting Content: Menu Element " + links02.size());

        WebElement inputLink =  driver.findElement(By.linkText("Angie"));
        inputLink.click();

        System.out.println(driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    
    public static void main(String args[]){
        BaseTests test = new BaseTests();
        test.setUp();
    }
     
}

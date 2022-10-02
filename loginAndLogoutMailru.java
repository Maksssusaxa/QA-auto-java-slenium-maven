import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class loginAndLogoutMailru {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\777\\Documents\\DRIVER CHROME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.mail.ru/login");


        WebElement username = driver.findElement(By.xpath("//input[@class=\"input-0-2-77\"]")); //login
        username.sendKeys("testpost95");

        driver.findElement(By.xpath("//div[@class=\"box-0-2-119 activeBox-0-2-124\"]")).click(); //radio button

        driver.findElement(By.xpath("//button[@data-test-id=\"next-button\"]")).click();  //next button

        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));  //password
        password.sendKeys("Testpassword2");

        driver.findElement(By.xpath("//button[@data-test-id=\"submit-button\"]")).click();  // submit

        driver.findElement(By.xpath("//div[@data-testid=\"whiteline-account\"]")).click(); //exit

        driver.findElement(By.xpath("//div[@data-click-counter=\"75068944\"]")).click(); //exit


    }
}

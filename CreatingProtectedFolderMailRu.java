import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class CreatingProtectedFolderMailRu {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\777\\Documents\\DRIVER CHROME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.mail.ru/login");
        Actions action = new Actions(driver);


        WebElement username = driver.findElement(By.xpath("//input[@class=\"input-0-2-77\"]")); //login
        username.sendKeys("testpost95");

        driver.findElement(By.xpath("//div[@class=\"box-0-2-119 activeBox-0-2-124\"]")).click();

        driver.findElement(By.xpath("//button[@data-test-id=\"next-button\"]")).click();

        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("Testpassword2");

        driver.findElement(By.xpath("//button[@data-test-id=\"submit-button\"]")).click();


        //create folder
        driver.findElement(By.xpath("//span[@class=\"button2 button2_has-ico button2_has-ico-s button2_actions_add button2_pure button2_compact button2_nowrap button2_fluid button2_text-overflow button2_hover-support\"]")).click();



        WebElement[] element = driver.findElements(By.className("box-0-2-106")).toArray(new WebElement[0]);  //Trying to get a second class of radio button because it doesn't find by xpath
        element[1].click();


        WebElement folderName = driver.findElement(By.xpath("//input[@name=\"name\"]"));
        folderName.sendKeys("Папка для папок");

        driver.findElement(By.xpath("//button[@data-test-id=\"submit\"]")).click();


        WebElement folderPassword = driver.findElement(By.xpath("//input[@data-test-id=\"password\"]"));  //Some inputs
        folderPassword.sendKeys("TestFolderPassword123");

        WebElement folderPasswordRepeat = driver.findElement(By.xpath("//input[@data-test-id=\"passwordRepeat\"]"));
        folderPasswordRepeat.sendKeys("TestFolderPassword123");

        WebElement theSecretQuestion = driver.findElement(By.xpath("//input[@data-test-id=\"question\"]"));
        theSecretQuestion.sendKeys("What is your foot size?");

        WebElement answerOnASecretQuestion = driver.findElement(By.xpath("//input[@data-test-id=\"answer\"]"));
        answerOnASecretQuestion.sendKeys("48");

        WebElement userPassword = driver.findElement(By.xpath("//input[@data-test-id=\"userPassword\"]"));
        userPassword.sendKeys("Testpassword2");

        driver.findElement(By.xpath("//button[@data-test-id=\"submit\"]")).click();


        driver.findElement(By.xpath("//div[@data-testid=\"whiteline-account\"]")).click(); //exit

        driver.findElement(By.xpath("//div[@data-click-counter=\"75068944\"]")).click();

        driver.close();
        driver.quit();


    }
}

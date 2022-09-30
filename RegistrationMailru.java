import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegistrationMailru {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\777\\Documents\\DRIVER CHROME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().setSize(new Dimension(750, 920));

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://mail.ru/");

        String winHandleBefore = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@class=\"resplash-btn resplash-btn_outlined-blue resplash-btn_mailbox-big svelte-j4p44z\"]")).click();


        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);                      //window swap
        }


        WebElement fName = driver.findElement(By.xpath("//input[@id=\"fname\"]"));
        fName.sendKeys("Oleg");

        WebElement lName = driver.findElement(By.xpath("//input[@id=\"lname\"]"));
        lName.sendKeys("Tinkov");

        driver.manage().window().setSize(new Dimension(750, 920));


        driver.findElement(By.xpath("//select[@class=\"select-0-2-131\"]")).click();    //date of birth
        driver.findElement(By.xpath("//option[text()=\"10\"]")).click();

        driver.findElement(By.xpath("//select[@class=\"select-0-2-131\"]")).click();
        driver.findElement(By.xpath("//option[text()=\"Апрель\"]")).click();

        driver.findElement(By.xpath("//select[@class=\"select-0-2-131\"]")).click();
        driver.findElement(By.xpath("//option[text()=\"2001\"]")).click();

        driver.findElement(By.xpath("//div[@class=\"radio-0-2-151\"]")).click();   //gender radio

        WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));   //username
        userName.sendKeys("TestUserNameQa");

        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));   //password
        password.sendKeys("ayuoooo23428");

        WebElement repeatPassword = driver.findElement(By.xpath("//input[@id=\"repeatPassword\"]"));
        repeatPassword.sendKeys("ayuoooo23428");

        driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();    //submit

        driver.close();
        driver.quit();


    }
}

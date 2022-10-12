import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SendAndClearLetterMailRu {
    private static String[] args;

    public static void main(String[] args) throws InterruptedException {
        SendAndClearLetterMailRu.args = args;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\777\\Documents\\DRIVER CHROME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://account.mail.ru/login");


        WebElement username = driver.findElement(By.xpath("//input[@class=\"input-0-2-77\"]")); //login
        username.sendKeys("testpost95");

        driver.findElement(By.xpath("//div[@class=\"box-0-2-119 activeBox-0-2-124\"]")).click();

        driver.findElement(By.xpath("//button[@data-test-id=\"next-button\"]")).click();

        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("Testpassword2");

        driver.findElement(By.xpath("//button[@data-test-id=\"submit-button\"]")).click();

        //Sending 3 letter to itself
        for (int i = 1; i < 4; i++) {
            driver.findElement(By.xpath("//div[@class=\"dropdown dropdown_collapsed dropdown_scroll-style_normal dropdown_hover-support dropdown_pony-mode\"]")).click();

            driver.findElement(By.xpath("//div[@class=\"list-item list-item_hover-support list-item_pure\"]")).click();

            WebElement topic = driver.findElement(By.xpath("(//input[@class=\"container--H9L5q size_s_compressed--2c-eV dark--7GF6F\"])[2]"));
            topic.sendKeys("Test topic");

            driver.findElement(By.xpath("//div[@role=\"textbox\"]")).clear();

            WebElement textarea = driver.findElement(By.xpath("//div[@role=\"textbox\"]"));
            textarea.sendKeys("Test text");

            driver.findElement(By.xpath("//button[@data-test-id=\"send\"]")).click();

            driver.findElement(By.xpath("//span[@class=\"button2 button2_has-ico button2_has-ico-s button2_close button2_pure button2_short button2_hover-support\"]")).click();
        }
        //clear all sent letters
        driver.findElement(By.xpath("(//a[@class=\"nav__item nav__item_expanded_true nav__item_child-level_1\"] )[5]")).click();

        driver.findElement(By.xpath("//div[@class=\"portal-menu-element portal-menu-element_select portal-menu-element_expanded portal-menu-element_not-touch portal-menu-element_pony-mode\"]")).click();

        driver.findElement(By.xpath("//div[@class=\"portal-menu-element portal-menu-element_remove portal-menu-element_expanded portal-menu-element_not-touch portal-menu-element_pony-mode\"]")).click();

        driver.findElement(By.xpath("//div[@class=\"layer__submit-button\"]")).click();



        driver.findElement(By.xpath("//div[@data-testid=\"whiteline-account\"]")).click(); //exit

        driver.findElement(By.xpath("//div[@data-click-counter=\"75068944\"]")).click();

        driver.close();
        driver.quit();


    }
}

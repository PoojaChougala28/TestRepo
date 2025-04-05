import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://capgemini.udemy.com/organization/home/");
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("Java Selenium");
        driver.findElement(By.name("q")).sendKeys("Java Selenium");

    }
}

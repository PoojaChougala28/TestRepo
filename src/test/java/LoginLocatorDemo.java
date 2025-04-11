import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLocatorDemo {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        driver.get("https://capgeminibrandstore.printstop.co.in/capgemini-new-arrivals/products/");
        driver.findElement(By.id("email_signup")).sendKeys("pooja.chougala@capgemini.com");
        //driver.findElement(By.name("inputPassword")).sendKeys("Pooja");
        driver.findElement(By.id("btnlogin")).click();
    }
}

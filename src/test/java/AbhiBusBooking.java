import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbhiBusBooking {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.abhibus.com/?utm_source=google&utm_medium=cpc&utm_campaign=Generic_KWs_PanIndia_NewUsers_03Oct24&gad_source=1&gclid=EAIaIQobChMIgM2FlITKjAMV6xODAx0BqiawEAAYASAAEgJSqfD_BwE");
        driver.findElement(By.id("From Station")).sendKeys("Pune");

    }
}

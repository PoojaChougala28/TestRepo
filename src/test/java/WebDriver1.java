import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver1 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        String title=driver.getTitle();

        if(title.equals("Your Store")){
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Failed");
        }
        driver.quit();

    }
}

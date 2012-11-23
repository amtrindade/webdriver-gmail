import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public void login(WebDriver driver){
		driver.findElement(By.name("Email")).sendKeys("email@gmail.com");
		driver.findElement(By.name("Passwd")).sendKeys("email");
		driver.findElement(By.name("signIn")).click();
	}
}

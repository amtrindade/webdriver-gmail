import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public void login(WebDriver driver, String email, String password) {

		driver.findElement(By.name("Email")).sendKeys(email);
		driver.findElement(By.name("Passwd")).sendKeys(password);
		driver.findElement(By.name("signIn")).click();
	}
	
}

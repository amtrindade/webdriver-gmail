import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public void login(WebDriver driver) {

		driver.findElement(By.name("Email")).sendKeys("cwi.teste1@gmail.com");
		driver.findElement(By.name("Passwd")).sendKeys("cwi.teste1");
		driver.findElement(By.name("signIn")).click();
	}
	
	public void loginWrongPassword(WebDriver driver) {
		
		driver.findElement(By.id("Email")).sendKeys("cwi.teste1@gmail.com");
	    driver.findElement(By.id("Passwd")).clear();
	    driver.findElement(By.id("Passwd")).sendKeys("teste");
	    driver.findElement(By.id("signIn")).click();
	}
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public String login(WebDriver driver){
	
		driver.findElement(By.name("Email")).sendKeys("email@gmail.com");
		driver.findElement(By.name("Passwd")).sendKeys("email");
		driver.findElement(By.name("signIn")).click();
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Nenhum e-mail novo.".equals(driver.findElement(By.cssSelector("td.TC")).getText())) 
				break; 
			} 
			catch (Exception e)	{}
			Thread.sleep(1000);
		}

		result = driver.findElement(By.cssSelector("td.TC")).getText();
	}
}

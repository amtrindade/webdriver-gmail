import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginTest {

	public LoginPage loginPage;
	public WebDriver driver;
	public StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setup() {
		
		loginPage = new LoginPage();

		driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() throws Exception {

		loginPage.login(driver);	
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Nenhum e-mail novo.".equals(driver.findElement(By.cssSelector("td.TC")).getText())) 
				break; 
			} 
			catch (Exception e)	{}
			Thread.sleep(1000);
		}

		String MessageNothing =  driver.findElement(By.cssSelector("td.TC")).getText();		
		assertEquals("Nenhum e-mail novo.",	MessageNothing);
	}
	
	@Test
	public void shouldMessageLoginWrong() throws Exception {
		
		loginPage.loginWrongPassword(driver);	
		
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Nome de usuário incorreto ou senha incorreta[\\s\\S]*$"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}

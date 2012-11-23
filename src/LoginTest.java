import static org.junit.Assert.*;

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
	}

	@Test
	public void loginTest() throws InterruptedException {

		String MessageNothing = loginPage.login(driver);	
		assertEquals("Nenhum e-mail novo.",	MessageNothing);
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

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

		loginPage.login(driver, "cwi.teste1@gmail.com", "cwi.teste1");	
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Nenhum e-mail novo.".equals(driver.findElement(By.cssSelector("td.TC")).getText())) 
				break; 
			} 
			catch (Exception e)	{}
			Thread.sleep(1000);
		}

		String MessageNothing =  driver.findElement(By.cssSelector("td.TC")).getText();		
		assertEquals("Deveria ter realizado o login!", "Nenhum e-mail novo.", MessageNothing);
	}
	
	@Test
	public void shouldMessageLoginWrong() throws Exception {
		
		loginPage.login(driver, "cwi.teste1@gmail.com", "teste");	
		
		//String MessageWrong = driver.findElement(By.cssSelector("id=errormsg_0_Passwd")).getText();
		//assertEquals("Deveria ter exibido mensagem de erro do login!", 
				//"Nome de usu�rio incorreto ou senha incorreta.", MessageWrong);
		assertTrue("Deveria ser exibido mensagem de erro!", 
				driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Nome de usu�rio incorreto ou senha incorreta[\\s\\S]*$"));		
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

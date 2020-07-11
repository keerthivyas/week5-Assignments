package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectCreateLead {
	
	   public static ChromeDriver driver;
	   
	   public String excelFileName;
	   
	@Parameters({"url","login","password"})   

	@BeforeMethod
	public void openApp(String url, String login, String password) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys(login);
		driver.findElementById("password").sendKeys(password);
		driver.findElementByClassName("decorativeSubmit").click();

	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();

	}
	
	@DataProvider(name = "SendData")
	public String[][] sendData() throws IOException {
		
		
		String[][] array = ReadExcel.readExcel(excelFileName);
		return array;
	
}

}
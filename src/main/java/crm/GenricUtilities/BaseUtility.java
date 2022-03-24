package crm.GenricUtilities;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import crm.POMRepository.HomePage;
import crm.POMRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseUtility {
	
	public ExcelLibrary eLIB=new ExcelLibrary();
	public FileLibrary fLIB=new FileLibrary();
	public JavaLibrary jLIB=new JavaLibrary();
	public WebDriverLibrary wLIB=new WebDriverLibrary();
	public WebDriver driver=null;
	public static WebDriver edriver=null;
		
	
	@BeforeSuite
	public void dbConnection() {
		System.out.println("DB Connection Attempt");
	}
	
	@AfterSuite
	public void dbDisConnection() {
		System.out.println("DB DisConnection Attempt");
	}
	
	//@Parameters("browser")
	@BeforeClass
	public void openBrowser(/*String browser*/) throws IOException {
		WebDriverManager.chromedriver().setup();
		//String browserToOpen=System.getProperty("browser");  //reading or accepting the data from mvn cmd
		String browser = fLIB.readProperty("browser");
		//String browserToOpen=browser;
		if(browser.contains("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.contains("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.err.println("invalid browser");
		}
		edriver=driver;
		wLIB.winMaximize(driver);
		System.out.println("Launching Browser Sucessful");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		System.out.println("Browser Closed");
	}
	

	//@Parameters({"username","password"})
	@BeforeMethod
	public void loginProcess(/*String username, String password*/) throws IOException {
		//String URL1=fLIB.readProperty("url");
		driver.get(fLIB.readProperty("url"));
		
		wLIB.winWaitImplicity(driver, 5);
		
		LoginPage lp=new LoginPage(driver);
		
		String username1=fLIB.readProperty("username");
		String password1=fLIB.readProperty("password");
		
		lp.loginLogic(username1, password1);
		
		System.out.println("Login Sucessfull");
	}
	
	@AfterMethod
	public void logoutProcess() {
		HomePage hp=new HomePage(driver);
		hp.logoutProcess();
		
		System.out.println("Logout Sucessfull");
				
	}
}
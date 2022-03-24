package crm.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.GenricUtilities.BaseUtility;

public class OrganizationPage extends BaseUtility {
	
	WebDriver localdriver;
	
	public OrganizationPage(WebDriver driver) {
		this.localdriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindAll({@FindBy(linkText = "Organizations"),@FindBy(className = "hdrLink")})
	private WebElement orgText;


	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement creatOrg;


	@FindAll({@FindBy(xpath = "//input[@class='detailedViewTextBox']"),@FindBy(name ="accountname")})
	private WebElement nameOrg;


	@FindBy(name = "industry")
	private WebElement indSelect;


	@FindBy(name = "accounttype")
	private WebElement typeSelect;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;


	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement confText;


	@FindBy(id = "dtlview_Industry")
	private WebElement induText;


	@FindBy(id = "dtlview_Type")
	private WebElement typeText;


	public WebElement getOrgText() {
		return orgText;
	}

	public WebElement getCreatOrg() {
		return creatOrg;
	}

	public WebElement getNameOrg() {
		return nameOrg;
	}

	public WebElement getIndSelect() {
		return indSelect;
	}

	public WebElement getTypeSelect() {
		return typeSelect;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getConfText() {
		return confText;
	}

	public WebElement getinduText() {
		return induText;
	}
	
	public WebElement gettypeText() {
		return typeText;
	}


	public void createOrg(String orgName) {
		getNameOrg().sendKeys(orgName);
		
	}

}
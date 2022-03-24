package crm.POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import crm.GenricUtilities.BaseUtility;


public class InvoicePage extends BaseUtility {
	WebDriver localDriver;

	public InvoicePage(WebDriver driver) {
		this.localDriver=driver;
		PageFactory.initElements(localDriver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Invoice...']")
	private WebElement invBtn;

	@FindBy(xpath = "//input[@name='subject']")
	private WebElement subBox;

	@FindBy(xpath = "//input[@name='account_name']/../img[@src='themes/softed/images/select.gif']")
	private WebElement orgNameSelect;

	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement billAdd;

	@FindBy(xpath = "//textarea[@name='ship_street']")
	private WebElement shipAdd;

	@FindBy(xpath = "//img[@title='Products']")
	private WebElement prdSearch;

	@FindBy(id = "qty1")
	private WebElement qtnNum;

	@FindBy(id = "listPrice1")
	private WebElement listPri;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	//POPUP WINDOW WEBELEMENTS FOR ORGANIZATION LINK
	@FindBy(xpath = "//input[@name='search_text' and @id='search_txt']")
	private WebElement searchTextNew;

	@FindBy(xpath = "//input[@type='button']")
	private WebElement searhBoxNew;

	public void searchProduct(String popUpSearch) {
		searchTextNew.sendKeys(popUpSearch);
		searhBoxNew.click();

		try {
			localDriver.findElement(By.xpath("//a[text()='"+popUpSearch+"']")).getText();
		} 
		catch (Exception e) {
			Reporter.log("Avaialble",true);
			System.err.println("Not Avaialble");
			Assert.fail();
		}

		//Saving the search product
		String searchProduct=localDriver.findElement(By.xpath("//a[text()='"+popUpSearch+"']")).getText();

		if(searchProduct.contains(popUpSearch)) {
			System.out.println("Linked");
			Reporter.log("Linked");
			Assert.assertTrue(true);
			localDriver.findElement(By.xpath("//a[text()='"+popUpSearch+"']")).click();
		}
		else {
			System.err.println("Not Linked");
			Reporter.log("Not Linked",true);
			Assert.assertFalse(false);
		}
	}
	
	public void alertPop() {
		localDriver.switchTo().alert().accept();
	}

	/**
	 * @return the localDriver
	 */
	public WebDriver getLocalDriver() {
		return localDriver;
	}

	/**
	 * @return the invBtn
	 */
	public WebElement getInvBtn() {
		return invBtn;
	}

	/**
	 * @return the subBox
	 */
	public WebElement getSubBox() {
		return subBox;
	}

	/**
	 * @return the orgNameSelect
	 */
	public WebElement getOrgNameSelect() {
		return orgNameSelect;
	}

	/**
	 * @return the billAdd
	 */
	public WebElement getBillAdd() {
		return billAdd;
	}

	/**
	 * @return the shipAdd
	 */
	public WebElement getShipAdd() {
		return shipAdd;
	}

	/**
	 * @return the prdSearch
	 */
	public WebElement getPrdSearch() {
		return prdSearch;
	}

	/**
	 * @return the qtnNum
	 */
	public WebElement getQtnNum() {
		return qtnNum;
	}

	/**
	 * @return the listPri
	 */
	public WebElement getListPri() {
		return listPri;
	}

	/**
	 * @return the saveBtn
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * @return the searchTextNew
	 */
	public WebElement getSearchTextNew() {
		return searchTextNew;
	}

	/**
	 * @return the searhBoxNew
	 */
	public WebElement getSearhBoxNew() {
		return searhBoxNew;
	}
}
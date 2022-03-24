package crm.ProdVendTest;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import crm.GenricUtilities.BaseUtility;
import crm.POMRepository.HomePage;
import crm.POMRepository.ProductPage;
import crm.POMRepository.VendorPage;

//@Listeners(com.vtiger.genericUtility.ListnersLibrary.class)
public class CreateProVenEndtoEndTest extends BaseUtility  {

	@Test(groups = "RT")
	public void vendorCreate() throws IOException {
		//Verify Homepage is displayed or not
		int append=jLIB.randomNumbers();
		HomePage hp=new HomePage(driver);
		String homepage = hp.getDispHomeText().getText();
		System.out.println(homepage);		
		Assert.assertEquals(homepage,hp.getActualHome());

		//Navigate vendor page & Verify
		VendorPage vp=new VendorPage(driver);
		wLIB.mouseHover(driver, hp.getMoreBtn());
		hp.getVenBtn().click();
		String vendorpage = vp.getDispVendorText().getText();
		Assert.assertEquals(vendorpage,vp.getActualVendorPage());

		//Entering Vendor Data and saving it
		String createdVender = eLIB.readExcel("VTiger", 1, 6)+append;
		vp.getAddBtn().click();
		vp.getTextBox().sendKeys(createdVender);
		vp.getSaveBtn().click();
		

		//Verify Product page is displayed or not
		hp.getProdBtn().click();
		ProductPage pp=new ProductPage(driver);
		String productspage=pp.getDispProductsText().getText();
		Assert.assertEquals(productspage,pp.getActualProductsPage());		
		String parentWind = driver.getTitle();
		
		//Entering Product Data and linking the Vendor and saving it		
		pp.getAddBtn().click();
		pp.getTextBox().sendKeys(eLIB.readExcel("VTiger", 1, 5)+append);		
		pp.getLinkBtn().click();		
		wLIB.winSwitch(driver, vp.getWindSwitchText());			
		pp.searchProduct(createdVender);		
		wLIB.winSwitch(driver, parentWind);			
		pp.getSaveBtn().click();
	}
}
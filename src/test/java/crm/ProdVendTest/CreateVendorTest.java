package crm.ProdVendTest;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import crm.GenricUtilities.BaseUtility;
import crm.POMRepository.HomePage;
import crm.POMRepository.VendorPage;


public class CreateVendorTest extends BaseUtility  {
	
	@Test(groups = "RT")
	public void vendorCreateTest() throws IOException {
		//Navigate vendor page & Verify
		int append=jLIB.randomNumbers();
		VendorPage vp=new VendorPage(driver);
		HomePage hp=new HomePage(driver);
		wLIB.mouseHover(driver, hp.getMoreBtn());
		hp.getVenBtn().click();
		String vendorpage = vp.getDispVendorText().getText();
		Assert.assertEquals(vendorpage,vp.getActualVendorPage());
		
		//Entering Vendor Data and saving it
		vp.getAddBtn().click();
		vp.getTextBox().sendKeys(eLIB.readExcel("VTiger", 1, 6)+append);
		vp.getSaveBtn().click();
		
	}
}
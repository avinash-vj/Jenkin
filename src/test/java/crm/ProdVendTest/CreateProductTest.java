package crm.ProdVendTest;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import crm.GenricUtilities.BaseUtility;
import crm.POMRepository.HomePage;
import crm.POMRepository.ProductPage;

public class CreateProductTest extends BaseUtility {
	
	@Test(groups = {"ST" , "RT"})
	public void productCreateTest() throws IOException {
		//Verify Homepage is displayed or not
		int append=jLIB.randomNumbers();
		
		HomePage hp=new HomePage(driver);
		String homepage = hp.getDispHomeText().getText();
		System.out.println(homepage);
		wLIB.winWaitImplicity(driver, 10);
		Assert.assertEquals(homepage,hp.getActualHome());
		
		//Verify Product page is displayed or not
		hp.getProdBtn().click();
		wLIB.winWaitImplicity(driver, 10);
		ProductPage pp=new ProductPage(driver);
		String productspage=pp.getDispProductsText().getText();
		
		Assert.assertEquals(productspage,pp.getActualProductsPage());
		
		//Entering Product Data and saving it
		pp.getAddBtn().click();
		wLIB.winWaitImplicity(driver, 10);
		pp.getTextBox().sendKeys(eLIB.readExcel("VTiger", 1, 5)+append);
		pp.getSaveBtn().click();
		
	}

}
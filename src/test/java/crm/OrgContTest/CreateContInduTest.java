package crm.OrgContTest;
import java.io.IOException;

import org.testng.annotations.Test;

import crm.GenricUtilities.BaseUtility;
import crm.POMRepository.HomePage;
import crm.POMRepository.OrganizationPage;

public class CreateContInduTest extends BaseUtility {
	@Test (groups = {"ST" , "RT"})
	public void createOrgIndAnnotationTest() throws IOException {
		System.out.println();
		int lastRow = eLIB.rowCount("VTiger");
		int lastCell = eLIB.cellCount("VTiger");
		int append=jLIB.randomNumbers();

		eLIB.objarray("vTiger", lastRow, lastCell);
		OrganizationPage op=new OrganizationPage(driver);		
		HomePage hp=new HomePage(driver);
		hp.getOrgBtn().click();
		wLIB.winWaitImplicity(driver, 5);
		op.getCreatOrg().click();

		for (int i=1;i<=lastRow-1;i++){
			String[][] obj=eLIB.objarray("vTiger", lastRow, lastCell);
			
			String orgName = obj[i][1];
			op.getNameOrg().sendKeys(orgName+append);
			
			String indName = obj[i][2];
			wLIB.dropDown(op.getIndSelect(), indName);
			
			op.getSaveBtn().click();
			wLIB.winWaitExplicit(driver, 5, op.getCreatOrg());
			try {
				op.getCreatOrg().click();
			} catch (Exception e) {
				System.out.println("Exception Caught");
			}
			hp.getOrgBtn().click();

			wLIB.winWaitImplicity(driver, 5);
			op.getCreatOrg().click();
		}
	}
}
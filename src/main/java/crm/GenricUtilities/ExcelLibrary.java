package crm.GenricUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelLibrary {

	public String readExcel(String sheet, int rownum, int cellnum) throws IOException {
		FileInputStream fis=new FileInputStream(InstancePath.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		String excelData = wb.getSheet(sheet).getRow(rownum).getCell(cellnum).getStringCellValue();
		return excelData;
	}

	public void writeExcel(String sheetName, int rownum, int cellnum, String userResult) throws IOException {
		FileInputStream fis=new FileInputStream(InstancePath.excelPath);
		Workbook wb=WorkbookFactory.create(fis);

		Sheet sheet = wb.getSheet(sheetName);
		Row rowNum=sheet.getRow(rownum);
		Cell cellNum=rowNum.getCell(cellnum);
		cellNum.setCellValue(userResult);
		FileOutputStream fos=new FileOutputStream(InstancePath.excelPath);
		wb.write(fos);
		wb.close();
	}

	public int rowCount(String sheetName) throws IOException {
		FileInputStream fis=new FileInputStream(InstancePath.excelPath);
		Workbook wb=WorkbookFactory.create(fis);

		Sheet sheet = wb.getSheet(sheetName);
		int rowCoun=sheet.getLastRowNum();
		return rowCoun;

	}

	//Last coluum number
	public int cellCount(String sheetName) throws IOException {
		FileInputStream fis=new FileInputStream(InstancePath.excelPath);

		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row rowCoun = sheet.getRow(0);
		int cellCount = rowCoun.getLastCellNum();

		return cellCount;

	}

	@DataProvider
	public String[][] objarray(String sheetName, int lastRow, int lastCell) throws IOException {
		FileInputStream fis=new FileInputStream(InstancePath.excelPath);
		Workbook wb=WorkbookFactory.create(fis);

		String obj[][]=new String[lastRow][lastCell-4];

		for(int i=0;i<lastRow;i++) {
			String rowName1=readExcel(sheetName, i, 0);

			for(int j=1;j<lastCell-4;j++) {
				String rowName2=readExcel(sheetName, i, j);

				obj[i][0]=rowName1;
				obj[i][j]=rowName2;	

			}
		}
		return obj;

	}
}
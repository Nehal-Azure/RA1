package api.utilities;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	@Test(dataProvider = "TestDPOne")
	public void dp1(String id, String username, String firstname, String lastname, String email, String password, String phone, String status ) {
		
		System.out.println("Starting Test");
		System.out.println(id +" : "+username+" : "+firstname+" : "+lastname+" : "+email+" : "+password+" : "+phone+" : "+status);
		System.out.println("Closing Test");
		
		
	}
	
	
	@DataProvider(name = "TestDPOne")
	public Object[][] dpMethod1() throws IOException {
		String filePath = System.getProperty("user.dir")+"/Testdata.xlsx";
		
		Object[][] obj = getExcelData(filePath, "Sheet1");
	
		
		
		return obj;
		
	}
	
	public Object[][] getExcelData(String filePath, String sheetName ) throws IOException {
		Object[][] data = null;
		
		FileInputStream fis = new FileInputStream(new File(filePath));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowNumber = sheet.getLastRowNum()+1;		
		int colNumber = sheet.getRow(0).getLastCellNum();
		data = new Object[rowNumber-1][colNumber];
		
		for(int rowNo = 1; rowNo<rowNumber; rowNo++)
		{
			for(int colNo=0; colNo<colNumber; colNo++)
			{
				data[rowNo-1][colNo] = sheet.getRow(rowNo).getCell(colNo).getStringCellValue();
			}
			
		}
		wb.close();
		return data;
	}

}

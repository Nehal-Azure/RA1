package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProvider2 {
	
	@DataProvider(name="AllData")
	public String [][] AllDataProvider()
	{
		String filePath = System.getProperty("user.dir")+"/Testdata.xlsx";
		
		int ttlRowCnt = ExcelUtil4.getRowCount(filePath, "Sheet1");
		int ttlColCnt= ExcelUtil4.getColCount(filePath, "Sheet1");
		
		String userData[][] = new String[ttlRowCnt-1][ttlColCnt];
		
		for(int rowNo = 1; rowNo<ttlRowCnt; rowNo++)
		{
			for(int colNo=0; colNo<ttlColCnt; colNo++)
			{
				userData[rowNo-1][colNo] = ExcelUtil4.getCellValue(filePath, "Sheet1", rowNo, colNo);
			}
			
		}
		return userData;
	}
	
	
	@DataProvider(name="UserNamesData")
	public String [] UserNamesDataProvider()
	{
		String filePath = System.getProperty("user.dir")+"/Testdata.xlsx";
		
		int ttlRowCnt = ExcelUtil4.getRowCount(filePath, "Sheet1");
	//	int ttlColCnt= ReadExcelFile.getColCount(fName, "Sheet1");
		
		String userNamesData[] = new String[ttlRowCnt-1];
		
		for(int rowNo = 1; rowNo<ttlRowCnt; rowNo++)
		{
			userNamesData[rowNo-1] = ExcelUtil4.getCellValue(filePath, "Sheet1", rowNo, 1);
			
		}
		return userNamesData;
	}

}

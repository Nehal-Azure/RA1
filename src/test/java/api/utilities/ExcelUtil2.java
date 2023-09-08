package api.utilities;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtil2 {
	
	@Test
	public void testExcelUtil1() {
		
		String filePath = System.getProperty("user.dir")+"/Testdata.xlsx";
		File file = new File(filePath);
		try {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			int rowNumber = sheet.getLastRowNum();
			System.out.println("Total Number of rows found:"+rowNumber);
			int colNumber = sheet.getRow(1).getLastCellNum();
			System.out.println("Total Number of column found:"+colNumber);
			Iterator<Row> itrrow = sheet.rowIterator();
			while(itrrow.hasNext()) {
				Row row = itrrow.next();
				Iterator<Cell> itrcell = row.cellIterator();
				while(itrcell.hasNext()) {
					Cell cell = itrcell.next();
					CellType cellType = cell.getCellType();
					switch(cellType) {
					case STRING:
						System.out.print(cell.getStringCellValue());
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue());
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue());
						break;
				}
					System.out.println(" : ");
			}
			
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

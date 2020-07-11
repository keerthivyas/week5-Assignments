package testNG;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	
    
	public static String[][] readExcel(String excelFileName) throws IOException {
		
		XSSFWorkbook book = new XSSFWorkbook("./data/" +excelFileName+ ".xlsx");
		
		XSSFSheet sheet = book.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		
		XSSFRow row = sheet.getRow(0);
		
		int columnCount = row.getLastCellNum();
		
		String[][] array = new String[rowCount][columnCount];
		
		for (int i = 1; i <= rowCount; i++) {
			
			XSSFRow eachRow = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				
				XSSFCell eachColumn = eachRow.getCell(j);
				
				array[i-1][j] = eachColumn.getStringCellValue();
				
				//System.out.println(data);
				
			}
			
		}
		
		return array;
		

	}

}

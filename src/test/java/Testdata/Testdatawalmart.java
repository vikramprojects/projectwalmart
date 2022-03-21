package Testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Testdatawalmart {
	public class DemoExcelsheet {
		public Workbook book;
		public Sheet sheet;
		
	public Object[][] readdata(String sheetname){
		FileInputStream file=null;
		try {
			file=new FileInputStream("C:\\Users\\vikram\\eclipse-workspace\\Walmart\\src\\test\\java\\Testdata\\details.xlsx");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
	book = WorkbookFactory.create(file); //HSSF 	XSSF
		}
		catch(IOException a) {
			a.printStackTrace();
		}
	sheet= book.getSheet(sheetname);
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for (int i=0; i<sheet.getLastRowNum();i++) {

		for(int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
		
	}
	return data;
	}
	}
}

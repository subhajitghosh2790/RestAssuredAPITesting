package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcelSheet {

	public static void main(String[] args) throws Exception {
		
		File file = new File("C:\\Users\\Sai\\Desktop\\Book1.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet s = wb.getSheetAt(0);
		
		String cellValue = s.getRow(0).getCell(0).getStringCellValue();
		
		System.out.println("Data at cell is :"+cellValue);
		
		//wb.close();
		
		int rowCount = s.getLastRowNum();
		int colCount = s.getRow(0).getLastCellNum();
		
		System.out.println("row count is:"+rowCount+ " column count is:"+colCount);
		
		s.getRow(0).createCell(0).setCellValue("Subhajit");
		
		FileOutputStream fout = new FileOutputStream(file);
		
		wb.write(fout);
		
		wb.close();
	}
}

package UsingPOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

//To read .xls file
public class ExcelDemo {
	
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("Input/TestJXL.xls");
			Workbook book = new HSSFWorkbook(file);
			HSSFSheet sheet = (HSSFSheet) book.getSheet("Sheet1");
			int rows = sheet.getLastRowNum();
			System.out.println("Total no. of Rows: " + rows);
			for (int i = 0; i <= rows; i++) {
				Row row = sheet.getRow(i);
				int cells = row.getLastCellNum();
				for (int j = 0; j < cells; j++) {
					Cell cell = row.getCell(j);
					if (cell.getCellType().name().equals("NUMERIC")) {
						System.out.print(cell.getNumericCellValue() + "\t");
					} else if (cell.getCellType().name().equals("STRING")) {
						System.out.print(cell.getStringCellValue() + "\t");
					}
				}
				System.out.println();
			}

		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}

}

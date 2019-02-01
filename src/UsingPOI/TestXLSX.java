package UsingPOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestXLSX {

	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("Input/TestPOI.xlsx");
			XSSFWorkbook book=new XSSFWorkbook(fis);
			XSSFSheet sheet=book.getSheetAt(0);
			int rows=sheet.getLastRowNum();
			Row row;
			for(int i=0;i<=rows;i++){
				row=sheet.getRow(i);
				int cells=row.getLastCellNum();
				for(int j=0;j<cells;j++){
					Cell cell=row.getCell(j);
					if(cell.getCellType().name().equals("NUMERIC")){
						System.out.print(cell.getNumericCellValue()+"\t");
					}else if(cell.getCellType().name().equals("STRING")){
						System.out.print(cell.getStringCellValue()+"\t");
					}
				}System.out.println();
			}
		} catch (IOException e) {
			System.out.println("File not present");
			e.printStackTrace();
		}
		
	}

}

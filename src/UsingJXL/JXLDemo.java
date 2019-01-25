package UsingJXL;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JXLDemo {
	public static String[][] readExcel(){
		String path=System.getProperty("user.dir");
		File file=new File(path+"/Input/TestJXL.xls");
		String[][] content=null;
		try {
			Workbook book=Workbook.getWorkbook(file);
			Sheet sheet=book.getSheet(0);
			int rows=sheet.getRows();
			int cols=sheet.getColumns();
			
			content=new String[rows][cols];
			
			System.out.println("Rows: "+rows+"\t"+"Columns: "+cols);
			for(int i=0;i<rows;i++){
				for(int j=0;j<cols;j++){
					Cell cell=sheet.getCell(j,i);
					content[i][j]=cell.getContents();
				}
				System.out.println();
			}
			
		} catch (BiffException | IOException e) {
			System.err.println("Unable to open Excel file");
			e.printStackTrace();
		}
		return content;
	}

}

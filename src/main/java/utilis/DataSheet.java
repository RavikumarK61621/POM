package utilis;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataSheet {

public static String[][] readExcel(String filename) throws IOException {
		
		//step 1 set path of the workbook
		  XSSFWorkbook wb=new XSSFWorkbook("./excelSheet/"+filename+".xlsx");
		  
		  //step 2 - get sheet value
		  //index - will start from '0'
		  XSSFSheet sheetValue = wb.getSheetAt(0);
		  
		  //step 3 count row value and read value from the row
		  int rowcount = sheetValue.getLastRowNum();
		  System.out.println("Row count :"+rowcount);

		  //step 4 count cell value
		  short cellcount = sheetValue.getRow(1).getLastCellNum();
		  System.out.println("Cell count :"+cellcount);
		  
		  //Step 1
		  String[][] data=new String[rowcount][cellcount];
 
		  for (int i = 1; i <=rowcount; i++) {
		   for (int j = 0; j < cellcount; j++) {
		    String stringCellValue2 = sheetValue.getRow(i).getCell(j).getStringCellValue();
		   //Step 2
		    data[i-1][j]=stringCellValue2;
		   }
		  }
		  	  
		  //step 3
		  wb.close();
		  return data;
	}

}

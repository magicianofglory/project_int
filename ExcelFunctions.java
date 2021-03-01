import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunctions {

	public void SaveDataToExcel(HashMap<String,String>excel) throws FileNotFoundException
	 {
			XSSFWorkbook  workbook=new XSSFWorkbook();
			XSSFSheet sheet=workbook.createSheet("Sheet1");
			int rowIndex=0;
			Cell cell_link_text;
			Cell cell_link_url;
			for(Map.Entry<String,String> eachMapItem : excel.entrySet())
			{
				Row row=sheet.createRow(rowIndex++);
				cell_link_text=row.createCell(0);
				cell_link_url=row.createCell(1);
				
				cell_link_text.setCellValue(eachMapItem.getKey());
				cell_link_url.setCellValue(eachMapItem.getValue());
			}
			
			FileOutputStream file=new FileOutputStream("C://LinkText.xlsx");
			try {
				workbook.write(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
}

package resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager{
	
	public static HashMap<String,String> config = new HashMap<String,String>();
	public static HashMap<String,String> locators = new HashMap<String,String>();
	public static HashMap<String,String> testdata = new HashMap<String,String>();
	
	//Method to load all the Excel Files into the respective HashMap Objects
	public static void loadExcelFiles() {
		
		String path = "./Utilities/config.xlsx";
		
		config = loadExeclDataIntoHashMap(path);
		
		path = config.get("TestDataFilePath");
		
		testdata = loadExeclDataIntoHashMap(path);
		
		path = config.get("LocatorsFilePath");
		
		locators = loadExeclDataIntoHashMap(path);
		
	}
	
	//Method takes the Excel File Path as argument, loads it into a HashMap ,and returns the HashMap object 
	//Consider First Column A as Key and Column B as Value
	//If any content within the two is null or starts with '#' then that row is left out
	static public HashMap<String,String> loadExeclDataIntoHashMap(String path) {
		
		HashMap<String,String> hashmap = new HashMap<String,String>();
		
		XSSFSheet excelSheet = loadExcelSheet(path);
		
		Iterator<Row> rowIterator = excelSheet.rowIterator();
		
		String key = null, value = null;
		
		while(rowIterator.hasNext()) {
			
			Row row =  rowIterator.next();
			
			if(row.getCell(0)==null || row.getCell(1)==null || row.getCell(0).getStringCellValue().charAt(0)=='#')
				continue;
			
			//get key , i.e., data in first column
			key = row.getCell(0).getStringCellValue();
			if(key.equals("platformVersion")) {
				value = row.getCell(1).toString();
				hashmap.put(key, value);
				continue;
			}
			
			//get value , i.e., data in second column
			switch(row.getCell(1).getCellType())
			{
			case NUMERIC:
				int num = (int) row.getCell(1).getNumericCellValue();
//				if(row.getCell(1).getNumericCellValue() - num == 0.0)
					value = Integer.toString(num);
//				else
//					value = row.getCell(1).toString();
				break;
			case STRING:
				value = row.getCell(1).getStringCellValue();
				break;
			default:
				break;
			}
			
			
			hashmap.put(key, value);
			
		}
		
		return hashmap;
		
	}
	
	//Method takes the Excel file path and return the ExcelSheet(XSSFSheet object)
	static public XSSFSheet loadExcelSheet(String path) {
		
		try {
			FileInputStream excelFile = new FileInputStream(new File(path));
			
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			
			XSSFSheet worksheet = workbook.getSheetAt(0);
			
			workbook.close();
			
			return worksheet;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}

package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static XSSFWorkbook excelWBook;
	private static XSSFSheet excelWSheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	private static String excelFilePath;
	
	/**
	 * This method is to set the File path and to open the Excel file, Pass
	    Excel Path and Sheetname as Arguments to this method
	 * @param path
	 * @param sheetName
	 */
	public static void openExcelFile(String path, String sheetName) {
		excelFilePath = path;
		try {
			File file = new File(path);
			FileInputStream ExcelFile = new FileInputStream(file);
			excelWBook = new XSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(sheetName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	 /**
	  * This method is to read the test data from the Excel cell, in this we are
	 passing parameters as Row num and Col num
	  * @param rowNum
	  * @param colNum
	  * @return
	  */
	public static String getCellData(int rowNum, int colNum) {
		try {
			cell = excelWSheet.getRow(rowNum).getCell(colNum);
			String cellData = cell.toString();
			return cellData;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	
	
	
	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters
	public static void setCellData(String value, int rowNum, int colNum) {
		try {
			
			if (row == null) {
				row = excelWSheet.createRow(rowNum);
			}
			
			row = excelWSheet.getRow(rowNum);
			cell = row.getCell(colNum);
			
			
			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(excelFilePath);
			excelWBook.write(fileOut);

			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getUsedRowsCount() {
		try {
			int rowCount = excelWSheet.getPhysicalNumberOfRows();
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
}

package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandle {

	public static String excelresultName;
	
	public static void createExcelFile(String excelName) throws IOException{
		String fileName = System.getProperty("user.dir") + "\\report\\excelResult\\" + excelName + ".xlsx";
		excelresultName = fileName;
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet workSheet = workBook.createSheet("Result");
		XSSFRow rowHead = workSheet.createRow((short)0);
		rowHead.createCell(0).setCellValue("Scenario");
		rowHead.createCell(1).setCellValue("Execution_Status");
		
		FileOutputStream fileOutput = new FileOutputStream(fileName);
		workBook.write(fileOutput);
		workBook.close();
		fileOutput.close();
	}
	
	public static void updateResultInExcelSheet(String scenario, String result) throws IOException{
		File myFile = new File(excelresultName);
		FileInputStream myXLSX = new FileInputStream(myFile);
		XSSFWorkbook resultWorkbook = new XSSFWorkbook(myXLSX);
		XSSFSheet resultSheet = resultWorkbook.getSheetAt(0);
		int lastRowNum = resultSheet.getLastRowNum();
		XSSFRow row = resultSheet.createRow(++lastRowNum);
		row.createCell(0).setCellValue(scenario);
		row.createCell(1).setCellValue(result);
		FileOutputStream fileOut = new FileOutputStream(myFile);
		resultWorkbook.write(fileOut);
		
		fileOut.close();
		resultWorkbook.close();
		myXLSX.close();
	}
}

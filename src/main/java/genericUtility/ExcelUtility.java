package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This is an utility class which works with Excel File
 * @author rajat burnwal
 * @version 01.05.25
 */
public class ExcelUtility {

	/**
	 * This is a generic method to fetch single cell data from Excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 * @throws Exception
	 */
	public String getDataFromExcel(String sheetName, int rowIndex, int cellIndex) throws Exception
	{
		FileInputStream fis =new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex);
		DataFormatter df=new DataFormatter();
		String value=df.formatCellValue(cell);
		return value;
	}
	
	/**
	 * This is a generic method to fetch multiple data from excel file
	 * @param sheetName
	 * @param startRowIndex
	 * @param startCellIndex
	 * @return
	 * @throws Exception
	 */
	public List<String> getMultipleDataFromExcel(String sheetName, int startRowIndex, int startCellIndex) throws Exception
	{
		FileInputStream fis =new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		DataFormatter df=new DataFormatter();
		List<String> data=new ArrayList<>();
		for(int i=startRowIndex;i<=sh.getLastRowNum();i++)
		{
			Row row=sh.getRow(i);
			for(int j=startCellIndex;j<row.getLastCellNum();j++)
			{
				Cell cell=row.getCell(j);
				String value=df.formatCellValue(cell);
				data.add(value);
			}
		}
		return data;
	}
	
	/**
	 * This is a generic method to write a data to a cell in Excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @param value
	 * @throws Exception
	 */
	public void writeDataToExcel(String sheetName, int rowIndex, int cellIndex, String value) throws Exception
	{
		FileInputStream fis =new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		sh.createRow(rowIndex).createCell(cellIndex).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IPathUtility.excelPath);
		wb.write(fos);
	}
}

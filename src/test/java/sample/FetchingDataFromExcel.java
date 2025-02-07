package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class FetchingDataFromExcel {

	public static void main(String[] args) throws Exception {

		//		FileInputStream fis =new FileInputStream("C:\\Users\\rajat burnwal\\Desktop\\modules.xlsx");
		//		Workbook wb = WorkbookFactory.create(fis);
		//		Cell cell = wb.getSheet("Animal").getRow(4).getCell(1);
		//		DataFormatter df=new DataFormatter();
		//		String value=df.formatCellValue(cell);
		//		System.out.println(value);

		//		ExcelUtility eUtil=new ExcelUtility();
		//		String value=eUtil.getDataFromExcel("Leads", 2, 2);
		//		System.out.println(value);

//		FileInputStream fis =new FileInputStream("C:\\Users\\rajat burnwal\\Desktop\\modules.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh=wb.getSheet("Animal");
//		System.out.println(sh.getLastRowNum());
//		DataFormatter df=new DataFormatter();
//		Row row=sh.getRow(1);
//		for(int j=0;j<row.getLastCellNum();j++)
//		{
//			Cell cell=row.getCell(j);
//			String value=df.formatCellValue(cell);
//			System.out.println(value);
//		}

		//		ExcelUtility eUtil=new ExcelUtility();
		//		List<String> value = eUtil.getMultipleDataFromExcel("Animal", 1, 0);
		//		System.out.println(value);

		FileInputStream fis =new FileInputStream("C:\\Users\\rajat burnwal\\Desktop\\modules.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Animal");
		sh.createRow(6).createCell(2).setCellValue("Buffalo");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\rajat burnwal\\Desktop\\modules.xlsx");
		wb.write(fos);


	}

}

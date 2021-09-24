package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MakeMyTripHotelData {

	public static Object[][]  getDatas(String Filename,String Sheet) throws IOException
	{	
		//Excel file Location
		FileInputStream File= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\testdata\\"+Filename+".xlsx");
		//Open the Excel book in excel file
		XSSFWorkbook workbook = new XSSFWorkbook(File);
		//Open the Excel sheet
		XSSFSheet worksheet = workbook.getSheet("Sheet1");
		
	     int RowCount = worksheet.getLastRowNum();
		
		int ColumnCount = worksheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[RowCount][ColumnCount];

		for(int i=1;i<=RowCount;i++)
		{
			for(int j=0;j<ColumnCount;j++)
			{
		    DataFormatter formatter = new DataFormatter();
		    data[i-1][j] = formatter.formatCellValue(worksheet.getRow(i).getCell(j));
		   }
		}
		
		return data;
	}
}

package com.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	FileInputStream fis;
	Object[][] data;
	Workbook wb;
	
	public  Object[][] getTestData(String path)
	{
		try {
			fis=new FileInputStream(path);
		    wb= new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			System.out.println("File that you are referring has not found");
			e.printStackTrace();
			
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		Sheet s=wb.getSheetAt(0);
		return data=new Object[s.getLastRowNum()][s.getRow(0).getLastCellNum()];
	}

}

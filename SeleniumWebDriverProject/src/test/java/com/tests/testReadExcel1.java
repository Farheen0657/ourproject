package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class testReadExcel1 {
	
	
	@Test
	public void testReadExcel1()
	{
		File file =new File("src\\test\\resources\\Book1.xlsx");
		try {
			InputStream is=new FileInputStream(file);
			try {
				XSSFWorkbook workbook=new XSSFWorkbook(is);
				XSSFSheet sheet1=workbook.getSheet("Sheet1");
				for(int i=1;i<=sheet1.getLastRowNum();i++)
				{
					for(int j=0;j<sheet1.getRow(i).getPhysicalNumberOfCells();j++)
					{
						System.out.println(sheet1.getRow(i).getCell(j).getStringCellValue());
					}
					sheet1.getRow(i).createCell(2).setCellValue("valid User");
					System.out.println();
				}
				
				is.close();
				OutputStream os=new FileOutputStream(file);
				workbook.write(os);
				os.close();
				
				workbook.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

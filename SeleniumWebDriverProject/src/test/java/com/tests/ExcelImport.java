package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelImport {


	public static Object[][] testWriteExcel(String sheetname)
	{
		File file =new File("src\\test\\resources\\Book2.xlsx");
		Object[][] obj=null;
		try {
			InputStream is=new FileInputStream(file);
			try {
				XSSFWorkbook workbook=new XSSFWorkbook(is);
				XSSFSheet sheet1=workbook.getSheet(sheetname);
				obj=new Object[sheet1.getLastRowNum()][];
				for(int i=1;i<=sheet1.getLastRowNum();i++)
				{
					obj[i-1]=new Object[sheet1.getRow(i).getPhysicalNumberOfCells()];
					for(int j=0;j<sheet1.getRow(i).getPhysicalNumberOfCells();j++)
					{
						obj[i-1][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
					}
					//sheet1.getRow(i).createCell(2).setCellValue("valid User");
					//System.out.println();
				}

				is.close();
				//OutputStream os=new FileOutputStream(file);
				//workbook.write(os);
				//os.close();

				workbook.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;

	}
}

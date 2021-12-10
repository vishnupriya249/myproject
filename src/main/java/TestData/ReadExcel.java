package TestData;


import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	
	File f;
	FileInputStream fis;
	FileOutputStream outputStream;
	XSSFWorkbook wb;
	XSSFSheet sh;
	XSSFRow r;
	public ReadExcel() throws IOException 
	{
	f = new File("src\\test\\resources\\Write5.xlsx");
	
	fis = new FileInputStream(f);
	
	wb = new XSSFWorkbook(fis);
	
	sh = wb.getSheet("Sheet2");
	
	
	}
	public String getExcelData(int shno, int row , int col)
	{
		sh = wb.getSheetAt(shno);
	
		String data = sh.getRow(row).getCell(col).getStringCellValue();
		//String data1 = sh.getRow(0).getCell(0).getStringCellValue();
		//System.out.println("the sheet name is"+sh.getSheetName());
		//System.out.println("the data is"+data+" data in 0,0 "+data1);
		return data;
	}
	public int getRowCount(int shno)
	{
		sh = wb.getSheetAt(shno);
		int Rows = sh.getLastRowNum()+1;
		
		System.out.println("The last row num is:"+sh.getLastRowNum()+"The first Row num is:"+sh.getFirstRowNum());
	
		return Rows; 
		
	}
	public int getColCount(int shno)
	{
		sh = wb.getSheetAt(shno);
		int Cols = sh.getRow(0).getLastCellNum();
		System.out.println("The last column count is:"+sh.getRow(0).getLastCellNum());
		return Cols;
	}
	
	public void write(int i,String text) throws IOException
	{
		
		 r.createCell(i).setCellValue(text);
		// String data = sh.getRow(1).getCell(i).getStringCellValue();
		 //System.out.println(data);
		 outputStream = new FileOutputStream("src\\test\\resources\\Write5.xlsx");
		 wb.write(outputStream);
		
	}
	public void row(String name)
	{
		if (name.equalsIgnoreCase("phonename"))
		r =sh.createRow(1);
		if(name.equalsIgnoreCase("price"))
		r =sh.createRow(2);
	}

}

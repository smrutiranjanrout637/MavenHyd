package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.text.Style;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.xml.LaunchSuite.ExistingSuite;

public class ExcelFileutil {
	XSSFWorkbook wb;
	//constructor for reading excel path
	public ExcelFileutil(String Excelfile)throws Throwable
	{
		FileInputStream fi = new FileInputStream(Excelfile);
		wb=new XSSFWorkbook(fi);
	}
	//method for counting no of rows in sheet
	public int rowcount(String SheetName) 
	{
		return wb.getSheet(SheetName).getLastRowNum();
	}
	//method for reading cell data
	public String getcellData(String SheetName,int row,int column) 
	{
		String data="";
		if(wb.getSheet(SheetName).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC) 
		{
			int celldata = (int)wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
			data = String.valueOf(celldata);
		}
		else 
		{
			data= wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		}
		return data;
	}
	//method for setcelldata
	public void setcell(String SheetName,int row,int coloumn,String Status,String writeExcel)throws Throwable
	{
		//get sheet from wb
		XSSFSheet ws = wb.getSheet(SheetName);
		//get row from sheet
		XSSFRow rownum=ws.getRow(row);
		//create cell
		XSSFCell cell = rownum.createCell(coloumn);
		cell.setCellValue(Status);
		if(Status.equalsIgnoreCase("pass"))
		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font=wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rownum.getCell(coloumn).setCellStyle(style);
		}
		else if(Status.equalsIgnoreCase("fail"))

		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font=wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rownum.getCell(coloumn).setCellStyle(style);
		}
		else if (Status.equalsIgnoreCase("Blocked"))

		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font=wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			//rownum.getCell(coloumn).setCellStyle(style);
		}
		FileOutputStream fo=new FileOutputStream(writeExcel);
		wb.write(fo);
	}
	public void Setcelldata(String tCSheet, int i, int j, String string, String outputpath) {
		// TODO Auto-generated method stub
		
	}

}














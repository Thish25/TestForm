package com.form.test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilPage {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static String TESTDATA_PATH ="/Users/thish/eclipse-workspace/TestForm/src/main/java/com/form/test/testdata/testdata.xlsx";
	
	static Workbook book;
	static Sheet sheet;

	//Reading Excel data
	public static Object[][] getTestData(String sName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(data.length);
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				DataFormatter df = new DataFormatter();
				data[i][k] = df.formatCellValue(sheet.getRow(i + 1).getCell(k));
			}
		}
		return data;
	}
	
}

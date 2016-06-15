package com.workday.salesforce.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author NeerajAgarwal
 *
 */
public class DataIO {
	
	private static String propertyFilePath = "\\resources\\testData\\%22%.properties";

	
	/**
	 * To Fetch the cell value from xls file
	 * @param objectName - Name of locator mentioned in the file
	 * @param fileName - Name of the file in which you need some data
	 * @return - list of related values correspond to the given locator
	 * @throws IOException
	 */
	public static ArrayList<String> getValueFromExcelFile(String objectName, String fileName) throws IOException{
		String filePath = System.getProperty("user.dir")+"\\resources\\ObjectRepository\\"+fileName+".xls";
		FileInputStream fis = new FileInputStream(filePath);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheetAt(0);
		ArrayList<String> elements = new ArrayList<String>();
		for(int i=0; i<= sheet.getLastRowNum(); i++){
			HSSFRow row = sheet.getRow(i);
			if(row.getCell(0).toString().equalsIgnoreCase(objectName)){
				elements.add(row.getCell(0).toString());
				elements.add(row.getCell(1).toString());
				elements.add(row.getCell(2).toString());
				break;
			}
		}
		workbook.close();
		return elements;
	}
	
	
	/**
	 * To Overwrite existing value in properties file.
	 * @param Property
	 * @param Data
	 * @throws Exception
	 */
	public static void overwritePropertiesFile(String Property, String Data) {
		try {
			FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "\\resources\\testdata\\TestData.properties");
		  	Properties props = new Properties();
		  	props.load(in);
		  	in.close();
		  	FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\testdata\\TestData.properties");
		  	props.setProperty(Property, Data);
		  	props.store(out, null);
		  	out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
      } 
  

    /**
     * readData From properties file
     * @param property
     * @return text
     */
    public static String get(String property, String fileName) {
        try {
            Properties prop = ResourceLoader.loadProperties(System.getProperty("user.dir") + propertyFilePath.replaceAll("%22%", fileName));
            return prop.getProperty(property);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static String updateDataInPropertiesFile(String key, String value){
		try {
			overwritePropertiesFile(key, value);
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}
    
   
}

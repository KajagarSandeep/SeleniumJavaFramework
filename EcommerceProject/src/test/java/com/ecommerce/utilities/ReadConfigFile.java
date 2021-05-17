package com.ecommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {

	Properties prop;
	
	public ReadConfigFile() {
		File src=new File("./configurations/config.properties");
		
		try {
			FileInputStream readFile=new FileInputStream(src);
			prop=new Properties();
			prop.load(readFile);
			
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
		}
	}
	
	public String baseURL() {
		String url=prop.getProperty("baseUrl");
		return url;
	}
	
}

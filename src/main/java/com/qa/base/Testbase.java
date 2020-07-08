package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Testbase {

	public Properties prop;
	
	public Testbase()
	{
		try {
			prop =new Properties();
			FileInputStream ip= new FileInputStream(System.getProperty(("user.dir")+"/src/main/java/com/qa/config/confi.properties"));
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

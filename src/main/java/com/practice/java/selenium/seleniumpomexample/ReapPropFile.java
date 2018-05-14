package com.practice.java.selenium.seleniumpomexample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReapPropFile {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		try {
			String dir = System.getProperty("user.dir");
			System.out.println("dir - "+dir);
			FileInputStream io = new FileInputStream(dir+"\\src\\main\\java\\com\\practice\\java\\selenium\\files\\credential.properties");
			prop.load(io);
			System.out.println(prop.getProperty("username"));
			
			System.out.println("ReapPropFile.main()");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

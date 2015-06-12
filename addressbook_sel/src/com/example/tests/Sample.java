package com.example.tests;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.example.fw.ApplicationManager;
import com.example.fw.JdbcHelper;

public class Sample {
	public static void main (String[] args) throws FileNotFoundException, IOException{
		
		Properties properties = new Properties();
	    properties.load(new FileReader (new File( "application.properties")) );
	    ApplicationManager app=new ApplicationManager(properties);
	    JdbcHelper jdbs = new JdbcHelper(app, "jdbs:mysql://localhost/addressbook?user=root&password=");
	    System.out.println(jdbs.listGroups());
	

		// String b = "+7(816)615-0899";
		// b = b.trim();
		// b = b.replaceAll("[ ( arg1)\\-]","");
		// System.out.println(b.matches("\\+\\d+"));

		// String line = ",test-797202123,";
		// System.out.println(line.split(",").length);

	}
}

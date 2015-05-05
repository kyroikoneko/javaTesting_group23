package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	
	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();

	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	  }

	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for(int i =0;i<1;i++){
			GroupData group = new GroupData();
			group.groupName = generateRandomString(10);
			group.footer = generateRandomString(100);
			group.header=generateRandomString(100);
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	
	public String generateRandomString(int index)
	{
		Random rnd = new Random();
		if (rnd.nextInt(3)==0)
		{
			return "";
		}
		else{
		return app.getGroupHelper().CharacterRandomizer(index);
		}
		
	}
}

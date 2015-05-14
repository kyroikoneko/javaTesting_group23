package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	
	  @Test
	  public void testContactRemoval() throws Exception {
		app.navigateTo().mainPage();
		
	    //������ ������ - ������ �����
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		   Random rnd = new Random();
		   int index = rnd.nextInt(oldList.size() - 1); 
		   
		   app.getContactHelper().deleteContact(index);    
		   
		   
	
		   SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //merge states
		  assertEquals(newList,oldList.without(index));
		
		
	  }

}

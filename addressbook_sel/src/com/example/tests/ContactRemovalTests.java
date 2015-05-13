package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	  @Test
	  public void testContactRemoval() throws Exception {
		app.navigateTo().mainPage();
		
	    //старый список - начало треша
		   List<ContactData> oldList = app.getContactHelper().getContacts();
		   Random rnd = new Random();
		   int index = rnd.nextInt(oldList.size() - 1); 
		   
		app.getContactHelper().openEditPage(index);
		app.getContactHelper().deleteContactCreation();
		app.getContactHelper().returnToMainPage();
		
		  List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //merge states
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(oldList,newList);
		
		
	  }

}

package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	
	  @Test
	  public void testContactRemoval() throws Exception {
		app.navigateTo().mainPage();
		
	    //старый список - начало треша
		SortedListOf<ContactData> oldList =  app.getModel().getContacts();
		   Random rnd = new Random();
		   int index = rnd.nextInt(oldList.size() - 1); 
		   
		   app.getContactHelper().deleteContact(index);    
		   
		   
	
		   SortedListOf<ContactData> newList =  app.getModel().getContacts();
	    
	    //merge states
		  assertEquals(newList,oldList.without(index));
		  if (wantToCheck()) {
				if ("yes".equals(app.getProperty("check.db"))) {
					assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));
				}
				if ("yes".equals(app.getProperty("check.ui"))) {
					assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUIContacts()));
				}
			}
		
	  }

}

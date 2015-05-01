package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationsTests extends TestBase{
	
	  @Test
	  public void testContactModifications() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openEditPage(1);

	    ContactData contact = new ContactData();
	    contact.firstName = "Natalechka";
	    contact.secondName = "Bianochka";
		app.getContactHelper().fillContactDetails(contact);
		app.getContactHelper().updateContactCreation();
		app.getContactHelper().returnToMainPage();
		
	  }

}

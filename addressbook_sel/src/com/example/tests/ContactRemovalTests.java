package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	  @Test
	  public void testContactRemoval() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openEditPage(1);
		app.getContactHelper().deleteContactCreation();
		app.getContactHelper().returnToMainPage();
		
	  }

}

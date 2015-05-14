package com.example.tests;
import static com.example.fw.ContactHelper.CREATION;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;



public class ContactCreationTests extends TestBase {
 
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
    //старый список - начало треша
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		
	app.getContactHelper().createContact(contact, CREATION);
	   SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	   assertEquals(newList,oldList.withAdded(contact));

   }
}

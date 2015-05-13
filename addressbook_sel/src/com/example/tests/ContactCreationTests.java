package com.example.tests;
import java.util.Collections;
import java.util.List;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.CREATION;



public class ContactCreationTests extends TestBase {
 
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
	app.navigateTo().mainPage();
	
    //������ ������ - ������ �����
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
   
	   
	   app.getContactHelper().createContact(contact, CREATION);
    
 // ����� ������
	   SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

    // merge states

    assertEquals(newList,equalTo(oldList.withAdded(contact)));
    
    
    
    
   }
}

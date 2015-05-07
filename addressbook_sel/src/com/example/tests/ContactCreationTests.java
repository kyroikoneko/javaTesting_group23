package com.example.tests;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
 
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();
	
    //старый список - начало треша
	   List<ContactData> oldList = app.getContactHelper().getContacts();
    app.getContactHelper().goToNewContactPage();


  Random rnd = new Random();
  int index = rnd.nextInt(oldList.size() - 1); 

    //action
	app.getContactHelper().fillContactDetails(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToMainPage();
    
 // новый список
 //   List<ContactData> newList = app.getContactHelper().getContacts();

    // merge states
  //  oldList.remove(index);
 //   Collections.sort(oldList);
 //   assertEquals(newList, oldList);
   }
}

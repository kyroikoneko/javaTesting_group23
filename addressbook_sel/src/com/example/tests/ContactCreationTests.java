package com.example.tests;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
 
  @Test
  public void testContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().goToNewContactPage();
    ContactData contact = new ContactData();

    contact.firstName = app.getContactHelper().NameRandomizer();
    contact.secondName = app.getContactHelper().NameRandomizer();
    contact.postAddress = "North Pole";
    contact.homePhoneNum = app.getContactHelper().phoneRandomizer();
    contact.mobilePhonNum = app.getContactHelper().phoneRandomizer();
    contact.workPhoneNum = app.getContactHelper().phoneRandomizer();
    contact.postPrimary = app.getContactHelper().emailRandomizer();
    contact.postSecondary = app.getContactHelper().emailRandomizer();
    contact.day ="18";
    contact.month = "January";
    contact.year = "1982";
    contact.group = "primaryGroup";
    contact.secondaryPostAddress = "South Pole";
    contact.secondaryPhone = "+42300011122";
	app.getContactHelper().fillContactDetails(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToMainPage();
  }
  
}

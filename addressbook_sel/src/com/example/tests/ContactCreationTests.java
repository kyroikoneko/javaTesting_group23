package com.example.tests;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
 
  @Test
  public void testContactCreation() throws Exception {
	openMainPage();
    goToNewContactPage();
    ContactData contact = new ContactData();

    contact.firstName = NameRandomizer();
    contact.secondName = NameRandomizer();
    contact.postAddress = "North Pole";
    contact.homePhoneNum = phoneRandomizer();
    contact.mobilePhonNum = phoneRandomizer();
    contact.workPhoneNum = phoneRandomizer();
    contact.postPrimary = emailRandomizer();
    contact.postSecondary = emailRandomizer();
    contact.day ="18";
    contact.month = "January";
    contact.year = "1982";
    contact.group = "primaryGroup";
    contact.secondaryPostAddress = "South Pole";
    contact.secondaryPhone = "+42300011122";
	fillContactDetails(contact);
    submitContactCreation();
    returnToMainPage();
  }
  
}

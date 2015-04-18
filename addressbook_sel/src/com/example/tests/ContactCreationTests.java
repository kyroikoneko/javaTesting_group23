package com.example.tests;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
 
  @Test
  public void testContactCreation() throws Exception {
	openMainPage();
    goToNewContactPage();
    ContactData contact = new ContactData();
    /* ���� ����� ������� �����������, 
    �� ��� ������ ������ ��� ������� ���� � ��������������
    ����������, ��� ������� ���� �����������. ������� ����� ������ ������ � 
    ������ ����. � ���������, ������� �������� ��� ����, ����� ���� � ��������� �����
    ������������.
    */
    contact.firstName = "Natalie";
    contact.secondName = "Bianko";
    contact.postAddress = "North Pole";
    contact.homePhoneNum = "3332211";
    contact.mobilePhonNum = "2221133";
    contact.workPhoneNum = "1112233";
    contact.postPrimary = "blabl@bl.vl";
    contact.postSecondary = "blblabl@vl";
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

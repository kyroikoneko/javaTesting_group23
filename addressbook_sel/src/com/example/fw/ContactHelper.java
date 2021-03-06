package com.example.fw;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;
public class ContactHelper  extends WebDriverHelperBase{
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	


	public SortedListOf<ContactData> getUIContacts() { 
	SortedListOf<ContactData> contacts = new SortedListOf<ContactData>(); 
 		 
 		manager.navigateTo().mainPage(); 
 		List<WebElement> secondNames = driver.findElements(By.xpath("//tr[@name='entry']/td[2]"));
		for (WebElement secondName : secondNames) {
		
		 String lastName = secondName.getText();
		 contacts.add(new ContactData().withSecondName(lastName));
 		}	
		return contacts;
 	} 

	
public ContactHelper createContact(ContactData contact, boolean formType) {
	manager.navigateTo().mainPage();
	goToNewContactPage();
	fillContactDetails(contact, CREATION);
	submitContactCreation();
	returnToMainPage();
	//update model
	manager.getModel().addContact(contact);
	return this;
}

public ContactHelper modifyContact(int index, ContactData contact) {
	manager.navigateTo().mainPage();
	openEditPage(index);
	fillContactDetails(contact, MODIFICATION);
	updateContactCreation();
	returnToMainPage();
	//update model
	manager.getModel().removeContact(index).addContact(contact);
	return this;
}


public ContactHelper deleteContact(int index) {
	manager.navigateTo().mainPage();
	openEditPage(index);
	deleteContactCreation();
	returnToMainPage();
	//update model
	manager.getModel().removeContact(index);
	return this;
	
}
	
	//*************************************************

	public void goToNewContactPage() {
		click(By.linkText("add new"));
	}
	
	public void returnToMainPage() {
		click(By.linkText("home page"));
	}
	
	public void submitContactCreation() {
		 click(By.name("submit"));
	}
	
	public void updateContactCreation() {
		 click(By.xpath("//*[@id='content']/form[1]/input[11]"));
	}
	
	public void deleteContactCreation() {
		 click(By.xpath("//*[@id='content']/form[2]/input[2]"));
	}
	

	public String phoneRandomizer() {
		  String charset = ("123456789");
		  String phoneN = RandomStringUtils.random(7,charset);
		  phoneN = "+7000"+phoneN;
		  return phoneN;	  
	 }

	public String emailRandomizer() {
		   String charset = ("abcdefghijklmopqrstuvwxyz");
		   String emailN = RandomStringUtils.random(7,charset);
		  emailN = emailN +"@blabla.bl";
		  return emailN;	  
	 }

	public String NameRandomizer() {
		   String charset = ("abcdefghijklmopqrstuvwxyz");
		   String name = RandomStringUtils.random(7,charset);
		   return name;	  
	 }

	public ContactHelper fillContactDetails(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getSecondName());
		type(By.name("address"), contact.getPostAddress());
		type(By.name("home"), contact.getHomePhoneNum());
		type(By.name("mobile"), contact.getMobilePhonNum());
		type(By.name("work"), contact.getWorkPhoneNum());
		type(By.name("email"), contact.getPostPrimary());
		type(By.name("email2"), contact.getPostSecondary());
		type(By.name("address2"), contact.getSecondaryPostAddress());
		type(By.name("phone2"), contact.getSecondaryPhone());
		type(By.name("byear"), contact.getYear());
		
	    selectByText(By.name("bday"), contact.getDay());
	    selectByText(By.name("bmonth"), contact.getMonth());
	  //  selectByText(By.name("new_group"), contact.getGroup());
	    
	    if (formType == CREATION) {  
	    	} else
	    	{  
	    		if (driver.findElements(By.name("Group")).size() != 0) {  
	    		throw new Error("Group selector exists in contact modification form");  
	    	}  
	    }  

	    return this;
	    
	}
	
	public void openEditPage(int index)
	{

		int count = clicks(By.xpath("//input[@type='checkbox']"));
		if (count != 0 && index <= count){
			index = index+2; 
		click(By.xpath("//*[@id='maintable']/tbody/tr["+index+"]/td[7]/a/img"));
		}

	}




}
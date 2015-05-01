package com.example.fw;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper  extends HelperBase{
	
	

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

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

	public void fillContactDetails(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.secondName);
		type(By.name("address"), contact.postAddress);
		type(By.name("home"), contact.homePhoneNum);
		type(By.name("mobile"), contact.mobilePhonNum);
		type(By.name("work"), contact.workPhoneNum);
		type(By.name("email"), contact.postPrimary);
		type(By.name("email2"), contact.postSecondary);
		type(By.name("address2"), contact.secondaryPostAddress);
		type(By.name("phone2"), contact.secondaryPhone);
		type(By.name("byear"), contact.year);
		
		type(By.name("lastname"), contact.secondName);
		type(By.name("lastname"), contact.secondName);
		type(By.name("lastname"), contact.secondName);
		type(By.name("lastname"), contact.secondName);

	    selectByText(By.name("bday"), contact.day);
	    selectByText(By.name("bmonth"), contact.month);
	    selectByText(By.name("new_group"), contact.group);
	}
	
	public void openEditPage(int index)
	{
		//проверяем наличие списков с помощью функции кликс, еденица - потому что чекбокс выделить все присутствует изначально. 
		//в проверке так же убрала возможность ввести заведомо больший индекс ^^
		int count = clicks(By.xpath("//input[@type='checkbox']"));
		if (count != 1 && index < count){
			index = index+1; //шапка находится по тому же пути и имеет индекс 1, соответственно все сдвигается
		click(By.xpath("//*[@id='maintable']/tbody/tr["+index+"]/td[7]/a/img"));
		}
	}
}

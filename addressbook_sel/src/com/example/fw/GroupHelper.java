package com.example.fw;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase {
	
	
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
	    initGroupCreation();
	    fillGroupForm(group);
	    submitGroupCreation();
	    returnToGroupPage();
	    rebuildCache();
		return this;
		
	}
	
	
	
	private SortedListOf<GroupData> cachedGroups;
	
	public SortedListOf<GroupData> getGroups() {
		if(cachedGroups == null){
			rebuildCache();
		}
		return cachedGroups;
		
		
	}
	
	private void rebuildCache() {
		cachedGroups = new SortedListOf<GroupData>();
		manager.navigateTo().groupsPage();
		
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
		String title = checkbox.getAttribute("title");
		String groupName = title.substring("Select (".length(), title.length()-")".length());
		 cachedGroups.add(new GroupData().withName(groupName));
		}
	}

	public GroupHelper deleteGroup(int index) {
		int count = clicks(By.xpath("//input[@name='selected[]']"));
		if (count != 0 && index <= count){
		selectGroupByIndex(index);
		submitGroupDelete();
		}
		returnToGroupPage();
		 rebuildCache();
		return this;
	}
	
	public GroupHelper deleteGroups() {
		selectAllGroups();
		submitGroupDelete();
		returnToGroupPage();
		return this;
	}

	public GroupHelper deleteSomeGroups(int index) {
		selectSomeGroups(index);
		submitGroupDelete();
		return this;
		}

	
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
	    initGroupModification(index+1);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupPage();
		 rebuildCache();
		return this;
	}


	//**********************************************************

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		 return this;
	}

	public GroupHelper submitGroupCreation() {
		 click(By.name("submit"));
		 return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
	   type(By.name("group_name"), group.getGroupName());
	   type(By.name("group_header"), group.getHeader());
	   type(By.name("group_footer"), group.getFooter());
		 return this;
	  }

	public GroupHelper returnToGroupPage() {
		click(By.linkText("group page"));
		return this;
	}



	private void selectGroupByIndex(int index) {
		
		int count = clicks(By.xpath("//input[@name='selected[]']"));
		if (count != 0 && index <= count){
		click(By.xpath("//input[@name='selected[]'][" + index+"]"));
		}
	}
	
	private void selectAllGroups() {
		
		int count = clicks(By.xpath("//input[@name='selected[]']"));
		if (count != 0){
		for (int i=1;i<=count;i++){
		click(By.xpath("//input[@name='selected[]'][" + i+"]"));
			}
		}
	}
	
	
	private void selectSomeGroups(int index) {
		
		int count = clicks(By.xpath("//input[@name='selected[]']"));
		if (count != 0 && index < count){
		for (int b=1;b<=index;b++){
		click(By.xpath("//input[@name='selected[]'][" + b+"]"));
			}
		}
		else {
			
			for (int b=1;b<count;b++){
				click(By.xpath("//input[@name='selected[]'][" + b+"]"));
					}
		}
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;

	}

	public GroupHelper submitGroupModification() {
		
		click(By.name("update"));
		cachedGroups = null;
		return this;
		
	}


	



	
	public String CharacterRandomizer(int index) {
		   String charset = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmopqrstuvwxyz");
		   String name = RandomStringUtils.random(index,charset);
		   return name;	  
	 }
	
	
	public int returnCount() {
		
		int count = clicks(By.xpath("//input[@name='selected[]']"));
		return count;
	}
	
	private void submitGroupDelete() {
		click(By.name("delete"));
		cachedGroups = null;
	}



}

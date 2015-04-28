package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {
	

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initGroupCreation() {
	    click(By.name("new"));
	}

	public void submitGroupCreation() {
		 click(By.name("submit"));
	}

	public void fillGroupForm(GroupData group) {
	   type(By.name("group_name"), group.groupName);
	   type(By.name("group_header"), group.header);
	   type(By.name("group_footer"), group.footer);
	  }

	public void returnToGroupPage() {
		click(By.linkText("group page"));
	}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index+"]"));
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

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));

	}

	public void submitGroupModification() {
		
		click(By.name("update"));
		
	}

	public void deleteGroups() {
		selectAllGroups();
		click(By.name("delete"));
		
	}
	
	public void deleteSomeGroups(int index) {
		selectSomeGroups(index);
		click(By.name("delete"));
		}

}

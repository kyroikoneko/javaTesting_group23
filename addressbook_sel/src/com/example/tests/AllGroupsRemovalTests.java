package com.example.tests;

import org.testng.annotations.Test;

public class AllGroupsRemovalTests extends TestBase {
	
	@Test
	public void deleteAllGroup()throws Exception{
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToGroupPage();
		app.getGroupHelper().deleteGroups();
		app.getGroupHelper().returnToGroupPage();
	//и создадим эталонную группу, чтоб была
	    app.getGroupHelper().initGroupCreation();
	    GroupData group = new GroupData();
	    group.groupName = "primaryGroup";
	    group.header = "тут находится хедер этоц группы, просто очередная рыба";
	    group.footer = "тут находится футер этоц группы, просто очередная рыба";
		app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupPage();
	}
}

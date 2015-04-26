package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

	@Test
	public void modifySomeGroup()throws Exception
	{
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToGroupPage();
		app.getGroupHelper().initGroupModification(7);
		
		GroupData group = new GroupData();
		group.groupName = "new name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();
	}

	
}

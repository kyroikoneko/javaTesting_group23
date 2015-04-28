package com.example.tests;

import org.testng.annotations.Test;

public class SomeGroupsDeleteTests extends TestBase {
	
	@Test
	public void deleteSomeGroup()throws Exception{
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToGroupPage();
		app.getGroupHelper().deleteSomeGroups(2);
		//тест не будет удалять группу, если она единственная в списке
		app.getGroupHelper().returnToGroupPage();
		}
}
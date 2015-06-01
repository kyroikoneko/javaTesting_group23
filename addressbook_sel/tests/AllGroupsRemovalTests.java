package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AllGroupsRemovalTests extends TestBase {
	
	@Test
	public void deleteAllGroup()throws Exception{
		app.navigateTo().mainPage();
	    app.navigateTo().groupsPage();
	   


	    app.getGroupHelper()
	    .deleteGroups();

	    int count = app.getGroupHelper().returnCount();

	    assertEquals(count,0);
	}
}

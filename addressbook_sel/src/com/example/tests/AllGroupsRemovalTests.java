package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class AllGroupsRemovalTests extends TestBase {
	
	@Test
	public void deleteAllGroup()throws Exception{
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToGroupPage();
	   


	    app.getGroupHelper().deleteGroups();
		app.getGroupHelper().returnToGroupPage();
	    int count = app.getGroupHelper().returnCount();

	    assertEquals(count,0);
	}
}

package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

public class EmptyGroupCreationTests extends TestBase {

//@Test
  public void testEmptyGroupCreation() throws Exception {
	app.navigateTo().mainPage();
    app.navigateTo().groupsPage();
    
    //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();

    GroupData group = new GroupData("", "", ""); 
    app.getGroupHelper().initGroupCreation();
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    
    // save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //merge states
    assertEquals(newList.size(), oldList.size()+1);
    
    oldList.add(group);
    Collections.sort(oldList);
    
    assertEquals(newList,oldList);
    
  }
}

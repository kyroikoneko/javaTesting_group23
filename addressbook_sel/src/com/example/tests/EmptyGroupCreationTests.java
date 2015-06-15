package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import com.example.utils.SortedListOf;

public class EmptyGroupCreationTests extends TestBase {

//@Test
  public void testEmptyGroupCreation() throws Exception {
	app.navigateTo().mainPage();
    app.navigateTo().groupsPage();
    
    //save old state
	SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());


    GroupData group = new GroupData("", "", ""); 
    app.getGroupHelper().initGroupCreation();
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    
    // save new state
    List<GroupData> newList = app.getModel().getGroups();
    
    //merge states
    assertEquals(newList.size(), oldList.size()+1);
    
    oldList.add(group);
    Collections.sort(oldList);
    
    assertEquals(newList,oldList);
    
  }
}

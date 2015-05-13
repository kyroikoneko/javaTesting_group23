package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class GroupCreationTests extends TestBase {
	
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
		//save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    //action
	    app.getGroupHelper().createGroup(group); 

	    
	    //save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //merge states
	    assertEquals(newList.size(), oldList.size()+1);
	 
	    
	    assertThat(newList, equalTo(oldList.withAdded(group)));

	  }

}
//46.34
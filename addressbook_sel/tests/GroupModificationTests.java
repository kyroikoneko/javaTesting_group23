package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group)throws Exception
	{
	    //save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    Random rnd = new Random(); 
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
	    app.getGroupHelper().modifyGroup(index, group);

		
		 // save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //merge states
	    
	    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));

	}

	
}
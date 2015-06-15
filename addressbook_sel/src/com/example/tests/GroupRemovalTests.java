package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


public class GroupRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeGroup()throws Exception{

	    
	    //save old state
		SortedListOf<GroupData> oldList = app.getModel().getGroups(); //new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
	    
	    Random rnd = new Random(); 
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    app.getGroupHelper()
	    .deleteGroup(index);
	    
		
		 // save new state
	    SortedListOf<GroupData> newList = app.getModel().getGroups();
	    
	    //merge states
	    
	    assertThat(newList, equalTo(oldList.without(index)));
		
	    if (wantToCheck()) {
			if ("yes".equals(app.getProperty("check.db"))) {
				assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
			}
			if ("yes".equals(app.getProperty("check.ui"))) {
				assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUIGroups()));
			}
		}
	}

}
 
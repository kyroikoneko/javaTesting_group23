package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


public class GroupRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeGroup()throws Exception{

	    
	    //save old state
	    SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random(); 
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    app.getGroupHelper()
	    .deleteGroup(index);
	    
		
		 // save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //merge states
	    
	    assertThat(newList, equalTo(oldList.without(index)));

	}

}

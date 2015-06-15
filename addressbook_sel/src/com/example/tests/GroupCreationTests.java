package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		// return wrapGroupsForDataProvider(loadGroupsFromCsvFile(new
		// File("groups.txt"))).iterator();
		return wrapGroupsForDataProvider(
				loadGroupsFromXmlFile(new File("groups.xml"))).iterator();

	}

	// groupsFromFile
	// randomValidGroupGenerator
	@Test(dataProvider = "groupsFromFile")
	public void testGroupCreationWithValidData(GroupData group)
			throws Exception {
		// save old state
		// SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		SortedListOf<GroupData> oldList = app.getModel().getGroups();
		// action
		app.getGroupHelper().createGroup(group);

		// save new state
		 SortedListOf<GroupData> newList = app.getModel().getGroups();
		//SortedListOf<GroupData> newList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());

		// merge states

		assertThat(newList, equalTo(oldList.withAdded(group)));
	//	assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
	//	assertThat(app.getModel().getGroups(),equalTo(app.getGroupHelper().getUIGroups()));

	//	compare model to implementation
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
// 57.45
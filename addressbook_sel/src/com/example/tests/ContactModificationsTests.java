package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationsTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactModifications(ContactData contact) throws Exception {

		SortedListOf<ContactData> oldList = app.getModel().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getContactHelper().modifyContact(index, contact);

		SortedListOf<ContactData> newList = app.getModel().getContacts();

		// merge states

		assertEquals(newList, oldList.without(index).withAdded(contact));
		if (wantToCheck()) {
			if ("yes".equals(app.getProperty("check.db"))) {
				assertThat(app.getModel().getContacts(), equalTo(app
						.getHibernateHelper().listContacts()));
			}
			if ("yes".equals(app.getProperty("check.ui"))) {
				assertThat(app.getModel().getContacts(), equalTo(app
						.getContactHelper().getUIContacts()));
			}
		}
	}

}

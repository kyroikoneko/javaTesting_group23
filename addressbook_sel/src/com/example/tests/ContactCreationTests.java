package com.example.tests;

import static com.example.fw.ContactHelper.CREATION;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreation(ContactData contact) throws Exception {
		// старый список - начало треша
		SortedListOf<ContactData> oldList = app.getModel().getContacts();

		app.getContactHelper().createContact(contact, CREATION);

		SortedListOf<ContactData> newList = app.getModel().getContacts();
		assertEquals(newList, oldList.withAdded(contact));

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

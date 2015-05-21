package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import com.example.fw.ApplicationManager;

public class TestBase {

	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();

	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
	}

	public static List<Object[]> wrapGroupsForDataProvider(
			List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[] { group });

		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		// for(int i =0;i<1;i++){
		// ContactData contact = new ContactData()
		// .withName(generateRandomString(10))
		// .withSecondName(generateRandomString(10))
		// .withPostAddress(generateRandomString(20))
		// .withHomePhoneNum(app.getContactHelper().phoneRandomizer())
		// .withMobilePhonNum(app.getContactHelper().phoneRandomizer())
		// .withWorkPhoneNum(app.getContactHelper().phoneRandomizer())
		// .withPostPrimary(app.getContactHelper().emailRandomizer())
		// .withPostSecondary(app.getContactHelper().emailRandomizer())
		// .withDay("18")
		// .withMonth("January")
		// .withYear("1992")
		// .withSecondaryPostAddress(generateRandomString(20))
		// .withSecondaryPhone(app.getContactHelper().phoneRandomizer());
		//
		//
		//
		// list.add(new Object[]{contact});
		// }
		return list.iterator();
	}

	// public String generateRandomString(int index)
	// {
	// Random rnd = new Random();
	// if (rnd.nextInt(5)==0)
	// {
	// return "";
	// }
	// else{
	// return app.getGroupHelper().CharacterRandomizer(index);
	// }
	//
	// }
}

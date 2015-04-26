package com.example.tests;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
@Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.groupName = "group name 1";
    group.header = "header name 1";
    group.footer = "footer name 1";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}
//
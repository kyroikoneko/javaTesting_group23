package com.example.tests;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
@Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    goToGroupPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.groupName = "group name 1";
    group.header = "header name 1";
    group.footer = "footer name 1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

}

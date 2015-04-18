package com.example.tests;
import org.testng.annotations.Test;

public class EmptyGroupCreationTests extends TestBase {

@Test
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupPage();
  }
}

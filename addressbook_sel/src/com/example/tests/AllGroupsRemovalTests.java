package com.example.tests;

import org.testng.annotations.Test;

public class AllGroupsRemovalTests extends TestBase {
	
	@Test
	public void deleteAllGroup()throws Exception{
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToGroupPage();
		app.getGroupHelper().deleteGroups();
		app.getGroupHelper().returnToGroupPage();
	//� �������� ��������� ������, ���� ����
	    app.getGroupHelper().initGroupCreation();
	    GroupData group = new GroupData();
	    group.groupName = "primaryGroup";
	    group.header = "��� ��������� ����� ���� ������, ������ ��������� ����";
	    group.footer = "��� ��������� ����� ���� ������, ������ ��������� ����";
		app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupPage();
	}
}

package com.example.tests;


public class SomeGroupsRemovalTests extends TestBase {
	
	//@Test
	public void deleteSomeGroup()throws Exception{
		app.navigateTo().mainPage();
	    app.navigateTo().groupsPage();
		app.getGroupHelper().deleteSomeGroups(2);
		//���� �� ����� ������� ������, ���� ��� ������������ � ������
		app.getGroupHelper().returnToGroupPage();
		}
}
package com.example.tests;

public class Sample {
public static void main(String[] args){
	
	String b = "+7(816)615-0899";
	b = b.trim();
	b = b.replaceAll("[ ( arg1)\\-]","");
	System.out.println(b.matches("\\+\\d+"));
}
}

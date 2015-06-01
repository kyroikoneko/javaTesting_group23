package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

import org.apache.commons.lang3.RandomStringUtils;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out
					.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}

		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];

		if (file.exists()) {
			System.out.println("File exists, please remove it manually: "
					+ file);

		}

		List<ContactData> contacts = generateRandomContacts(amount);
		if (format.equals("csv")) {
			saveContactsToCsvFile(contacts, file);
		} else if (format.equals("xml")) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts,
			File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	public static List<ContactData> loadContactsFromXmlFile(File file)
			throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getSecondName() + "," + contact.getFirstName()
					+ "," + contact.getPostAddress() + ","
					+ contact.getHomePhoneNum() + ","
					+ contact.getMobilePhonNum() + ","
					+ contact.getWorkPhoneNum() + ","
					+ contact.getPostPrimary() + ","
					+ contact.getPostSecondary() + ","
					+ contact.getSecondaryPostAddress() + ","
					+ contact.getSecondaryPhone() + "\n");
		}
		writer.close();
	}

	public static List<ContactData> loadContactsFromCsvFile(File file)
			throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData().withName(part[0])
					.withSecondName(part[1]).withPostAddress(part[2])
					.withHomePhoneNum(part[3]).withMobilePhonNum(part[4])
					.withWorkPhoneNum(part[5]).withPostPrimary(part[6])
					.withPostSecondary(part[7])
					.withSecondaryPostAddress(part[8]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData()
					.withName(generateRandomString(10))
					.withSecondName(generateRandomString(10))
					.withPostAddress(generateRandomString(20))
					.withHomePhoneNum(phoneRandomizer())
					.withMobilePhonNum(phoneRandomizer())
					.withWorkPhoneNum(phoneRandomizer())
					.withPostPrimary(emailRandomizer())
					.withPostSecondary(emailRandomizer()).withDay("18")
					.withMonth("January").withYear("1992")
					.withSecondaryPostAddress(generateRandomString(20))
					.withSecondaryPhone(phoneRandomizer());
			list.add(contact);
		}
		return list;
	}

	public static String generateRandomString(int index) {
		Random rnd = new Random();
		if (rnd.nextInt(5) == 0) {
			return "";
		} else {
			return CharacterRandomizer(index);
		}

	}

	public static String phoneRandomizer() {
		String charset = ("123456789");
		String phoneN = RandomStringUtils.random(7, charset);
		phoneN = "+7000" + phoneN;
		return phoneN;
	}

	public static String emailRandomizer() {
		String charset = ("abcdefghijklmopqrstuvwxyz");
		String emailN = RandomStringUtils.random(7, charset);
		emailN = emailN + "@blabla.bl";
		return emailN;
	}

	public static String CharacterRandomizer(int index) {
		String charset = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmopqrstuvwxyz");
		String name = RandomStringUtils.random(index, charset);
		return name;
	}

}
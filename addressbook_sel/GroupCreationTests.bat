java -cp bin com.example.tests.GroupDataGenerator 10 group.txt csv
java -cp bin com.example.tests.GroupDataGenerator 10 group.xml xml
java -cp bin com.example.tests.ContactDataGenerator 10 contact.txt csv
java -cp bin com.example.tests.ContactDataGenerator 10 contact.xml xml
java -cp bin;C:\selenium\lib\xstream-1.4.8.jar;C:\selenium\lib\xstream\xpp3_min-1.1.4c.jar;C:\selenium\lib\xstream\xmlpull-1.1.3.1.jar;C:\selenium\selenium-server-standalone-2.45.0.jar org.testng.TestNG testng-customsuite.xml
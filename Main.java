import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		PhoneBookApplication phonebook = new PhoneBookApplication();
		Scanner reader = new Scanner(System.in);
		int response;

		do {

			System.out.println("---Welcome to the Phonebook---");

			System.out.println("1. Add" + "\n2. List" + "\n3. Count" + "\n4. Info" + "\n5. Delete" + "\n6. Search"
					+ "\n7. Exit" + "\n\nPlease choose an option:");

			response = reader.nextInt();
			reader.nextLine();

			switch (response) {

			case 1:
				System.out.println("Person or organization?");
				String choice = reader.nextLine().toLowerCase();

				if (choice.equals("person")) {
					addPerson(phonebook);
				} else if (choice.equals("organization")) {
					addOrganization(phonebook);
				} else {
					System.out.println("Invalid entry.");
					continue;
				}

				break;
			case 2:
				System.out.println("List of contacts:");
				phonebook.list();
				System.out.println();
				break;
			case 3:
				System.out.println("The count is " + phonebook.count() + ".");
				break;
			case 4:
				phonebook.info();
				break;
			case 5:
				phonebook.delete();
				break;
			case 6:
				phonebook.search();
				break;
			case 7:
				break;
			default:
				System.out.println("\nDid you listen fuckboi? That wasn't an option.\n");
			}

		} while (response != 7);

	}

	public static boolean validPhoneNumber(String phoneNumber) {

		try {

			Long.valueOf(phoneNumber);

			return phoneNumber.length() == 10;
		}

		catch (Exception e) {

			return false;

		}

	}

	public static void addPerson(PhoneBookApplication phonebook) {
		Scanner reader = new Scanner(System.in);

		System.out.println("Enter name:");
		String name = reader.nextLine();

		String phoneNumber;
		while (true) {
			System.out.println("Enter phone number (no spaces or dashes):");
			phoneNumber = reader.nextLine();
			if(validPhoneNumber(phoneNumber)) {
				break;
			}
		}

		System.out.println("Enter email address:");
		String email = reader.nextLine();

		LocalDateTime birthday = LocalDateTime.now();

		phonebook.add(new Person(name, phoneNumber, birthday, email));

	}

	public static void addOrganization(PhoneBookApplication phonebook) {

		Scanner reader = new Scanner(System.in);

		System.out.println("Enter name:");
		String name = reader.nextLine();

		System.out.println("Enter phone number (no spaces or dashes):");
		String phoneNumber = reader.nextLine();

		LocalDateTime birthday = LocalDateTime.now();

		System.out.println("Enter website:");
		String website = reader.nextLine();

		phonebook.add(new Organization(name, phoneNumber, birthday, website));

	}

}

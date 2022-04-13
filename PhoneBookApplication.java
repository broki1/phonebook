import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookApplication {
	Scanner reader=new Scanner(System.in);

	ArrayList<Contact> phonebook;
	
	public PhoneBookApplication() {
		
		this.phonebook = new ArrayList<Contact>();
		
	}
	
	public void add(Contact contact) {
		
		phonebook.add(contact);
		
	}
	
	public void list() {
		
		for(Contact contact : phonebook) {
			
			System.out.println(contact);
			
		}
		
	}
	
	public int count() {
		
		return this.phonebook.size();
		
	}
	
	public void info() {
		
		this.list();
		
		System.out.println("Enter contact ID:");
		int response = reader.nextInt();
		
		boolean foundId = false;
		
		for(Contact contact : phonebook) {
			
			if(contact.getId() == response) {
				
				System.out.println(contact);
				foundId = true;
				
			}
			
		}
		
		if(!foundId) {
			System.out.println("ID not found.");
		}
		
	}
	
	public void delete() {
		
		this.list();
		
		System.out.println("Enter contact ID:");
		int response = reader.nextInt();
		
		for(int i = 0; i < this.phonebook.size(); i++) {
			
			if(this.phonebook.get(i).getId() == response) {
				
				this.phonebook.remove(i);
				
			}
			
		}
		
	}
	
	public void search() {
		//Ask user for search query. Enter name or part. Look at phonebook and display information for user. 
			System.out.println("Please enter a search query:");
			String query = reader.nextLine();
			//Search through each contact
			for(Contact contact : phonebook) {	
				
				if (contact.getName().contains(query)) {
					
					System.out.println(contact);
					
				}
				
			}
			
		}
	
	
	
	
	
}

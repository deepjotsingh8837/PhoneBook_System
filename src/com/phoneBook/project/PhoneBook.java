package com.phoneBook.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
	List<Contact> contacts=new ArrayList<>();
	public void addContact(String name, String phoneNumber) {
		Contact c=new Contact(name,phoneNumber);
		contacts.add(c);
		System.out.println("Contact added : "+c);
	}
	public void searchContact(String name) {
		for(Contact c : contacts) {
				 if(c.getName().equalsIgnoreCase(name)) {
					System.out.println("Contact found: "+c);
					return;
				}
			}
			
		}
	public void UpdateContactNumber(String name,String newPhoneNumber) {
		for(Contact c:contacts) {
			if(c.getName().equalsIgnoreCase(name)) {
				c.setPhoneNumber(newPhoneNumber);
				System.out.println("Contact Number updated Successfully : "+c);
				return;
				
			}
			else {
				System.out.println("Contact not found!!!!");
			}
		}
		
	}
	public void UpdateConatctName(String name,String name2) {
		for(Contact c:contacts) {
			if(c.getName().equalsIgnoreCase(name)) {
				c.setName(name2);
				System.out.println("Contact Name updated Successfully"+c);
				return;
			}
			else {
				System.out.println("Enter the correct name!!!");
			}
		}
	}
	
	public void deleteContact(String name) {
		for(Contact c:contacts) {
			if(c.getName().equalsIgnoreCase(name)) {
				contacts.remove(c);
				System.out.println("Contact deleted : "+c);
				return;
			}
		}
		System.out.println("Contact not found: "+name);
	}
	public void displayAllContacts() {
		if(contacts.isEmpty()) {
			System.out.println("PhoneBook Empty!!!");
			System.out.println("No contacts found");
		}else {
		for(Contact c:contacts) {
			System.out.println(c);
		}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneBook p=new PhoneBook();
		
		while(true) {
			System.out.println("******PhoneBook******");
			System.out.println("1. Add Contact");
			System.out.println("2. Search Contact");
			System.out.println("3. Update Contact");
			System.out.println("4. Delete Contact");
			System.out.println("5. Display All Contacts");
			System.out.println("6. Exit");
			System.out.println("Select an option: ");
			
			Scanner s=new Scanner(System.in);
			int ch=s.nextInt();
			//System.out.println();
			s.nextLine();
			
			switch(ch) {
			case 1:
				System.out.println("Enter Name: ");
				String name=s.nextLine();
				try {
					if(name.length()==0) {
						throw(new Exception("Enter the name again!!!"));
						///System.out.println("Enter the name again!!!");
						///break;
					}
					
				}
				catch(Exception e) {
					System.out.println(e);
					break;
				}
				
				System.out.println("Enter PhoneNumber: ");
				String phoneNumber=s.nextLine();
				try {
					if(phoneNumber.length()!=10) {
						throw(new Exception("Enter the Phone Number Again!!!"));
						///System.out.println("Enter the Phone Number Again!!!");
						///break;
					}
				}
				catch(Exception e) {
					///System.out.println("In the catch block");
					System.out.println(e);
					break;
				}
				p.addContact(name, phoneNumber);
				
				break;
				
			case 2:
				System.out.println("Enter Name to Search: ");
				String searchName=s.nextLine();
				p.searchContact(searchName);
				break;
			
			case 3:
				///outer:
					
					while(true) {
						System.out.println("Press A. To Update the Name.");
						System.out.println("Press B. To Update the Phone Number.");
						System.out.println("Press C. Exit");
						String ch1=s.nextLine();
						System.out.println("Please enter your Choice : ");
						switch(ch1) {
						case "A":
							
							System.out.println("Enter old Name : ");
							String oldName=s.nextLine();
							System.out.println("Enter new Name: ");
							String newName=s.nextLine();
							p.UpdateConatctName(oldName,newName);
							System.out.println("New Contact Name Updated Successfully");
							break;
						case "B":
							System.out.println("Enter the name: ");
							String name1=s.nextLine();
							System.out.println("Enter New Phone Number to Update: ");
							String newphoneNumber=s.nextLine();
							if(newphoneNumber.length()!=10){
								System.out.println("Please enter the correct 10 digit Phone Number");
							}
							else {
								
								p.UpdateContactNumber(name1,newphoneNumber);
								System.out.println("New Phone Number Updated Successfully");
							}
						//p.UpdateContact(updateName, newPhoneNumber);
							break;
						case "C":
							
							//s.close();
							//System.exit(0);
							break;
							
						}
						break;
				}
				break;
			case 4:
				System.out.println("Enter Name to Delete: ");
				String deleteName=s.nextLine();
				p.deleteContact(deleteName);
				break;
			case 5:
				p.displayAllContacts();
				break;
			case 6:
				System.out.println("Exiting PhoneBook. GoodBye!!!!");
				s.close();
				System.exit(0);
				break;
			default:
			
				System.out.println("Invalid option. Please choose a valid option.");
				
			}
	
		}

	}
}
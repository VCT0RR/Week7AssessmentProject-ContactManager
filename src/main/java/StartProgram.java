/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Feb 27, 2023
 */

import java.util.List;
import java.util.Scanner;

import controller.ListContactHelper;
import model.ListContacts;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListContactHelper lch = new ListContactHelper();

		private static void addAContact() {
			// TODO Auto-generated method stub
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter an email: ");
			String email = in.nextLine();
			System.out.print("Enter a phone number: ");
			String phone = in.nextLine();
			ListContacts toAdd = new ListContacts(name, email, phone);
			lch.insertContact(toAdd);

		}

		private static void deleteAContact() {
			// TODO Auto-generated method stub
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the email to delete: ");
			String email = in.nextLine();
			System.out.print("Enter the phone number to delete: ");
			String phone = in.nextLine();
			
			ListContacts toDelete = new ListContacts(name, email, phone);
			lch.deleteContact(toDelete);

		}

		private static void editAContact() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");
			System.out.println("2 : Search by Email");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListContacts> foundContacts;
			if (searchBy == 1) {
				System.out.print("Enter the contact's name: ");
				String contactName = in.nextLine();
				foundContacts = lch.searchForEmailByName(contactName);
			}
			else {
				System.out.print("Enter the contact's email: ");
				String contactEmail = in.nextLine();
				foundContacts = lch.searchForEmailByEmail(contactEmail);
			}

			if (!foundContacts.isEmpty()) {
				System.out.println("Found Results.");
				for (ListContacts l : foundContacts) {
					System.out.println(l.getId() + " : " + l.getEmail());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListContacts toEdit = lch.searchForEmailById(idToEdit);
				System.out.println("Retrieved " + toEdit.getEmail() + " from " + toEdit.getName());
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Email");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 2) {
					System.out.print("New Email: ");
					String newEmail = in.nextLine();
					toEdit.setEmail(newEmail);
				}

				lch.updateContact(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the Contact Manager! ---");
			while (goAgain) {
				System.out.println("*  Select a contact:");
				System.out.println("*  1 -- Add a contact");
				System.out.println("*  2 -- Edit a contact");
				System.out.println("*  3 -- Delete a contact");
				System.out.println("*  4 -- View all contacts");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAContact();
				} else if (selection == 2) {
					editAContact();
				} else if (selection == 3) {
					deleteAContact();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lch.cleanUp();
					System.out.println("---Thank you. Goodbye!---");
					goAgain = false;
				}
			}
		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListContacts> allContacts = lch.showAllContacts();
			for(ListContacts singleContact : allContacts) {
				System.out.println(singleContact.returnContactDetails());
			}

		}

	}

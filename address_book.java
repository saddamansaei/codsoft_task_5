import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class Contact {
    String Name;
    String phone_no;
    String email_Address;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.Name = name;
        this.phone_no = phoneNumber;
        this.email_Address = emailAddress;
        
    }

      String getName() {
        return Name;
    }

     String getPhoneNumber() {
        return phone_no;
    }

     String getEmailAddress() {
        return email_Address;
    }
    
}

     class address_book {
         List<Contact> contacts;

        address_book() {
        contacts = new ArrayList<>();
    }

         void addContact(Contact contact) {
        contacts.add(contact);
    }

          void displayContacts() {
           for (Contact contact : contacts) {
        	String l = contact.getName();
        	
        	String la = contact.getName();
        	
        	String laa = contact.getName();
        	
            System.out.println("Name: " + l);
            
            System.out.println("Phone Number: " + la);
            
            System.out.println("Email Address: " + laa);
            
            System.out.println("----------------------");
            
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches("\\d{10}", phoneNumber);
    }

    public static boolean isValidEmail(String email) {
        return Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email);
    }

    public static void main(String[] args) {
    	address_book addressBook = new address_book();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Exit");
            System.out.print("Enter your option : ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    if (!isValidPhoneNumber(phoneNumber)) {
                        System.out.println("Invalid phone number. Please enter 10 digits.");
                        continue;
                    }
                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();
                    if (!isValidEmail(email)) {
                        System.out.println("Invalid email address. Please enter a valid email.");
                        continue;
                    }
                    Contact newContact = new Contact(name, phoneNumber, email);
                    addressBook.addContact(newContact);
                    break;

                case 2:
                    addressBook.displayContacts();
                    break;

                case 3:
                    System.out.println("Exiting Address Book.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("____Please enter a valid option____");
            }
        }
    }
}
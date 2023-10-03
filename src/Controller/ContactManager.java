package Controller;

import java.util.ArrayList;

import Common.Algorithm;
import Common.Library;
import Model.Contact;
import View.Menu;

public class ContactManager extends Menu<String> {
    static String[] options = { "Add a contact", "Display all contacs", "Delete a contact", "Exit" };
    Library library = new Library();
    protected Algorithm algorithm;
    ArrayList<Contact> dataContact = new ArrayList<>();

    public ContactManager(ArrayList<Contact> dataContact) {
        super("Display the menu", options);
        this.dataContact = dataContact;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                do {
                    Contact contact = new Contact();
                    contact.input(dataContact);
                    dataContact.add(contact);
                } while (Algorithm.isTrue("Do you want to continue (Y/N)?", "Y", "N"));
                break;
            case 2:
                library.displayAllContact(dataContact);

                break;
            case 3:
                System.out.println("Delete");
                Algorithm.Delete(dataContact);
                library.displayAllContact(dataContact);
                break;
            case 4:
                System.exit(0);
                break;
        }

    }

    public static void main(String[] args) {
        ArrayList<Contact> dataContact = new ArrayList<>();
        new ContactManager(dataContact).run();
    }

}

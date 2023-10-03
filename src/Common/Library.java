package Common;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Contact;

public class Library {
    public static String validPhone(String prompt) {
        Scanner sc = new Scanner(System.in);
        String phone;
        do {
            System.out.print(prompt);
            phone = sc.nextLine();
            if (!phone
                    .matches("^\\(?(\\d{3})\\)?[-.]?(\\d{3})[-.]?(\\d{4})(?:\\s?(?:x|ext)\\d{1,4})?$")) {
                System.out.println("A phone number only has the following format");
                System.out.println("• 1234567890");
                System.out.println("• 123-456-7890");
                System.out.println("• 123-456-7890 x1234");
                System.out.println("• 123-456-7890 ext1234");
                System.out.println("• (123)-456-7890");
                System.out.println("• 123.456.7890");
                System.out.println("• 123 456 7890");
            }
        } while (!phone
                .matches("^\\(?(\\d{3})\\)?[-.]?(\\d{3})[-.]?(\\d{4})(?:\\s?(?:x|ext)\\d{1,4})?$"));
        return phone;
    }

    public static String validString(String promt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(promt + ":");
        String Str = sc.nextLine();
        return Str;
    }

    public static int getInt(String promt, int m, int n) {
        int a = -1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }

    public void displayAllContact(ArrayList<Contact> dataContact) {
        System.out.println("Display All Contact");
        System.out.printf("%-3s%-20s%-10s%-10s%-7s%-10s%-20s%n", "Id", "Fullname", "Firstname", "Lastname", "Group",
                "Address", "Phone");

        dataContact.stream().forEach(contact -> {
            System.out.printf("%-3d%-20s%-10s%-10s%-7s%-10s%-20s%n", contact.getId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(), contact.getGroup(), contact.getAddress(),
                    contact.getPhone());
        });
    }

}

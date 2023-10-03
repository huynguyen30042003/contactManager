package Common;

import java.util.ArrayList;

import Model.Contact;

public class Algorithm {
    public static Boolean isTrue(String question, String ans1, String ans2) {
        String isNext;
        do {
            isNext = Library.validString(question);
        } while (!isNext.equalsIgnoreCase(ans1) && !isNext.equalsIgnoreCase(ans2));
        return isNext.equalsIgnoreCase(ans1);
    }

    public static int nextId(ArrayList<Contact> arr) {
        if (arr.size() == 0) {
            return 1;
        }
        int id = arr.get(arr.size() - 1).getId() + 1;
        return id;
    }

    public static void Delete(ArrayList<Contact> arr) {
        int idDelete = Library.getInt("input id to delete", 1, nextId(arr));
        arr.removeIf(contact -> contact.getId() == idDelete);
    }
}

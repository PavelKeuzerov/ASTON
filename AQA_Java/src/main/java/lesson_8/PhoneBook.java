package lesson_8;

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("cat", "111-222-3333");
        phoneBook.add("dog", "222-3333");
        phoneBook.add("ant", "333-444-5555");
        phoneBook.add("ant", "444-5555");
        phoneBook.add("rat", "444-5555");


        System.out.println("Phonebook");
        System.out.println("Ant number: " + phoneBook.get("ant"));
        System.out.println("Dog number: " + phoneBook.get("dog"));
        System.out.println("Rat number: " + phoneBook.get("rat"));

    }

    private final Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        List<String> phones = phoneBook.getOrDefault(lastName, new ArrayList<>());
        phones.add(phoneNumber);
        phoneBook.put(lastName, phones);
    }

    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }
}

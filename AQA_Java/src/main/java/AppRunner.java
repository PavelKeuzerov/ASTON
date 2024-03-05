import java.util.Arrays;

public class AppRunner {
    public static void main(String[] args) {


        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("cat", "111-222-3333");
        phoneBook.add("dog", "222-3333");
        phoneBook.add("ant", "333-444-5555");
        phoneBook.add("ant", "444-5555");

        for (String s : Arrays.asList("Phonebook", "Ant number: " + phoneBook.get("ant"),
                "Dog number: " + phoneBook.get("dog"))) {
            System.out.println(s);
        }
    }
}

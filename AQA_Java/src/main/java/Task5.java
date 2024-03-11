import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> logins = new ArrayList<>();

        System.out.println("Enter logins. Click to finish \"Enter\"");
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            logins.add(input);
        }

        System.out.println("Logins starting with f - " + logins.stream()
                .filter(o -> o.startsWith("f")).collect(Collectors.toList()));
    }
}

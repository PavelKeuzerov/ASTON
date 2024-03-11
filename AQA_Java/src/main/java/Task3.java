import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<String> fCollection = new ArrayList<>(Arrays.asList("f10", "a15", "f2", "f4", "f5", "b54", "a16"));
        fCollection.stream().sorted().forEach(System.out::println);
    }
}

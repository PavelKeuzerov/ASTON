import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<>();
        collection.add("Highload");
        collection.add("High");
        collection.add("Load");
        collection.add("Highload");

        System.out.println(collection.stream().filter(s -> s.equals("High")).count() + " time object \"High\" repeated");
        System.out.println(collection.stream().findFirst().orElse("0") + " - first element");
        System.out.println(collection.stream().reduce((a, b) -> b).orElse("0") + " - last element");
    }
}
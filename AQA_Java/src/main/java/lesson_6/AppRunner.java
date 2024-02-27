package lesson_6;

public class AppRunner {
    public static void main(String[] args) {
        String[] header = {"Value1", "Value2", "Value3"};
        int[][] data = {
                {100, 200, 300},
                {400, 500, 600},
                {7, 8, 9}
        };
        AppData appData = new AppData(header, data);

        appData.save("data.csv");

        AppData loadedData = AppData.load("data.csv");
        if (loadedData != null) {
            for (String element : loadedData.header) {
                System.out.print(element + " ");
            }
            System.out.println();
            for (int[] row : loadedData.data) {
                for (int element : row) {
                    System.out.print(element + "\t\t");
                }
                System.out.println();
            }
        }
    }
}

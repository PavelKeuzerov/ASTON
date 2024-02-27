package lesson_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppData {
    String[] header;
    int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < header.length; i++) {
                writer.append(header[i]);
                if (i < header.length - 1) {
                    writer.append(";");
                } else {
                    writer.append("\n");
                }
            }

            for (int[] datum : data) {
                for (int j = 0; j < datum.length; j++) {
                    writer.append(String.valueOf(datum[j]));
                    if (j < datum.length - 1) {
                        writer.append(";");
                    } else {
                        writer.append("\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppData load(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String[] header = reader.readLine().split(";");

            int numRows = 0;
            int numCols = header.length;
            while (reader.readLine() != null) {
                numRows++;
            }
            reader.close();

            int[][] data = new int[numRows][numCols];
            reader = new BufferedReader(new FileReader(fileName)); //открываем файл снова, чтобы начать с самого начала
            reader.readLine(); //пропускаем строку заголовка
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                for (int i = 0; i < values.length; i++) {
                    data[row][i] = Integer.parseInt(values[i]);
                }
                row++;
            }
            reader.close();
            return new AppData(header, data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

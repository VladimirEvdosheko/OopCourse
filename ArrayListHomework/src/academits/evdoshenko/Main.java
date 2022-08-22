package academits.evdoshenko;

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("D:\\input.txt"))) {
            ArrayList<String> list = new ArrayList<>();

            String line = fileReader.readLine();

            while (line != null) {
                list.add(line);
                line = fileReader.readLine();
            }

            System.out.println(list);
        } catch (FileNotFoundException e) {
            System.out.println("The File is not exists!");
        } catch (IOException e) {
            System.out.println("Input or output error!");
        }

        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16));

        for (int i = 0; i < numbers1.size(); i++) {
            if (numbers1.get(i) % 2 == 0) {
                numbers1.remove(i);
                i--;
            }
        }

        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 5, 5, 4, 4, 8, 11,
                9, 9, 9, 15, 16));

        ArrayList<Integer> resultNumbers = new ArrayList<>(numbers2.size());

        for (Integer number : numbers2) {
            if (!resultNumbers.contains(number)) {
                resultNumbers.add(number);
            }
        }

        System.out.println(resultNumbers);
    }
}
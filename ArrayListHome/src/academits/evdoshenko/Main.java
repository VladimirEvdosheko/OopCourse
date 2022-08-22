package academits.evdoshenko;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("D:\\input.txt"))) {
            String line = fileReader.readLine();

            ArrayList<Integer> numbers1 = new ArrayList<>();

            while (line != null) {
                numbers1.add(Integer.valueOf(line));
                line = fileReader.readLine();
            }

            System.out.print("Outputting from file: ");
            System.out.println(numbers1);
        } catch (FileNotFoundException var6) {
            System.out.println("The File is not exists!");
        } catch (IOException e) {
            System.out.println("Input or output error!");
        }

        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 14, 15, 16));

        for (int i = 0; i < numbers2.size(); ++i) {
            if (numbers2.get(i) % 2 == 0) {
                numbers2.remove(i);
                --i;
            }
        }

        System.out.println("ArrayList without even numbers: " + numbers2);

        numbers2 = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 5, 5, 4, 4, 8, 11, 9, 9, 9, 15, 16));

        ArrayList<Integer> resultNumbers = new ArrayList<>(numbers2.size());

        for (Integer number : numbers2) {
            if (!resultNumbers.contains(number)) {
                resultNumbers.add(number);
            }
        }

        System.out.println("ArrayList without repeats: " + resultNumbers);
    }
}
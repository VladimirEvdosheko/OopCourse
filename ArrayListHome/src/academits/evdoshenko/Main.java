package academits.evdoshenko;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("D:\\input.txt"))) {
            String line = fileReader.readLine();

            ArrayList<Integer> numbersList = new ArrayList<>();

            while (line != null) {
                numbersList.add(Integer.valueOf(line));
                line = fileReader.readLine();
            }

            System.out.print("Outputting from file: ");
            System.out.println(numbersList);
        } catch (FileNotFoundException var6) {
            System.out.println("The File is not exists!");
        } catch (IOException e) {
            System.out.println("Input or output error!");
        }

        ArrayList<Integer> numbersListWithoutEvenNumbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 14, 15, 16)
        );

        for (int i = 0; i < numbersListWithoutEvenNumbers.size(); ++i) {
            if (numbersListWithoutEvenNumbers.get(i) % 2 == 0) {
                numbersListWithoutEvenNumbers.remove(i);
                --i;
            }
        }

        System.out.println("ArrayList without even numbers: " + numbersListWithoutEvenNumbers);

        numbersListWithoutEvenNumbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 3, 3, 5, 5, 4, 4, 8, 11, 9, 9, 9, 15, 16)
        );

        ArrayList<Integer> NumbersListWithoutRepeats = new ArrayList<>(numbersListWithoutEvenNumbers.size());

        for (Integer number : numbersListWithoutEvenNumbers) {
            if (!NumbersListWithoutRepeats.contains(number)) {
                NumbersListWithoutRepeats.add(number);
            }
        }

        System.out.println("ArrayList without repeats: " + NumbersListWithoutRepeats);
    }
}
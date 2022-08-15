import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListHome {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream("D:\\input.txt"));

            ArrayList<String> list = new ArrayList<>();

            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }

            System.out.println(list);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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

        ArrayList<Integer> resultNumbers = new ArrayList<>();

        for (Integer integer : numbers2) {
            if (!resultNumbers.contains(integer)) {
                resultNumbers.add(integer);
            }
        }

        System.out.println(resultNumbers);
    }
}
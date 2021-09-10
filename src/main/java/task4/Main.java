package task4;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = readArray(args[0]);
        System.out.println(countSteps(array));
    }

    //можно прочитать имя файла из консоли, введенное пользователем
    public static String readFileName() {
        String line = "";
        try {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                line = scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return line;
        }
    }

    public static ArrayList<Integer> readArray(String fileName) {
        ArrayList<Integer> array = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextInt()) {
                array.add(scanner.nextInt());
            }
        } catch (Exception e) {
            array.clear();
        } finally {
            return array;
        }
    }

    public static int countSteps(List<Integer> array) {
        if (array.size() > 1) {
            int sum = 0;
            for (int element : array) {
                sum += element;
            }
            double average = (double) sum / array.size();
            int goalNumber = array.get(0);
            for (int i = 0; i < array.size() - 1; i++) {
                if (Math.abs(average - array.get(i + 1)) < Math.abs(average - array.get(i))) {
                    goalNumber = array.get(i + 1);
                }
            }
            sum = 0;
            for (int element : array) {
                sum += Math.abs(goalNumber - element);
            }
            return sum;
        }
        return 0;
    }
}

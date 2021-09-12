package task4;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> elements = readArray(args[0]);
            System.out.println(countSteps(elements));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> readArray(String fileName) throws Exception {
        ArrayList<Integer> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            int temp;
            while (scanner.hasNextLine()) {
                if (!scanner.hasNextInt()) {
                    throw new NumberFormatException("Incorrect format of input data");
                } else {
                    temp = scanner.nextInt();
                    result.add(temp);
                }
            }
            return result;
        } catch (NullPointerException | FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static int countSteps(List<Integer> elements) throws Exception {
        if (elements.size() == 0) {
            throw new Exception("An empty file!");
        }
        if (elements.size() == 1) {
            throw new Exception("Input data need to be more than 1 element!");
        }

        int sum = 0;
        for (int element : elements) {
            sum += element;
        }
        double average = (double) sum / elements.size();
        int goalNumber = elements.get(0);
        for (int i = 0; i < elements.size() - 1; i++) {
            if (Math.abs(average - elements.get(i + 1)) < Math.abs(average - elements.get(i))) {
                goalNumber = elements.get(i + 1);
            }
        }
        sum = 0;
        for (int element : elements) {
            sum += Math.abs(goalNumber - element);
        }
        return sum;
    }
}
